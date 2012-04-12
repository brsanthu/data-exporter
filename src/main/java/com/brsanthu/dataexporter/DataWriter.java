package com.brsanthu.dataexporter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.StringEscapeUtils;

import com.brsanthu.dataexporter.model.BeanRow;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.Column;
import com.brsanthu.dataexporter.model.DataExporterCallback;
import com.brsanthu.dataexporter.model.HeaderCellDetails;
import com.brsanthu.dataexporter.model.Row;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;
import com.brsanthu.dataexporter.util.Util;

/**
 * Workhorse of the library, which coordinates and exports the header, rows and footer as
 * appropriate. This method has list of abstract classes, so called hooks, which subclasses
 * can make use to write the data at appropriate time.
 * <p>
 * Subclasses must extend {@link AbstractDataWriter} instead of this class.
 * 
 * @author Santhosh Kumar
 */
public abstract class DataWriter {
    
    protected ExportOptions options = null;
    private PrintWriter out = null;
    private boolean autoFlush = true;
    private AtomicInteger rowIndex = new AtomicInteger();
    
    /**
     * Initializes DataWriter with given export options and output stream
     * 
     * @param options the options to use during exporting. Cannot be <code>null</code>.
     * @param out the output stream to write the data to. Cannot be <code>null</code>.
     */
    public DataWriter(ExportOptions options, OutputStream out) {
        this(options, new OutputStreamWriter(out));
    }
    
    /**
     * Initializes the datawriter with given export options and writer.
     * 
     * @param options the options to use during exporting. Cannot be <code>null</code>.
     * @param out the output writer to write the data to. Cannot be <code>null</code>.
     */
    public DataWriter(ExportOptions options, Writer out) {
        Util.checkForNotNull(out, "out");
        Util.checkForNotNull(options, "options");
        
        this.options = options;
        this.out = new PrintWriter(out);
    }
    
    /**
     * Returns the currently active options.
     * 
     * @return the current options
     */
    public ExportOptions getOptions() {
        return options;
    }
    
    /**
     * This method could be used to export the given table and rows.
     * 
     * @param table the table to export to. Cannot be <code>null</code>.
     * @param rows the list of rows to export to. Cannot be <code>null</code>.
     */
    public void writeTable(Table table, List<Row> rows) {
        Util.checkForNotNull(rows, "rows");
        Util.checkForNotNull(table, "table");
        
        beforeTable(table);
        writeHeader(table);
        writeRows(table, rows);
        afterTable(table);
    }
    
    /**
     * Writes the given set of rows to the output stream.
     * 
     * @param table the table. Cannot be <code>null</code>.
     * @param rows list of rows to write to. Cannot be <code>null</code>.
     */
    public void writeRows(Table table, List<Row> rows) {
        Util.checkForNotNull(rows, "rows");
        Util.checkForNotNull(table, "table");
        
        for (Row row : rows) {
            RowDetails rowDetails = new RowDetails(table, rowIndex.getAndIncrement(), row);
            
            writeRow(rowDetails);
        }
    }
    
    /**
     * Writes the header for given table.
     * 
     * @param table the table whose header needs to be written. Cannot be <code>null</code>.
     */
    public void writeHeader(Table table) {
        Util.checkForNotNull(table, "table");
        
        if (options.isPrintHeaders() && table.getColumns() != null) {
            beforeHeaderRow(table);
            
            for (int i = 0; i < table.getColumns().size(); i++) {
                
                HeaderCellDetails headerCellDetails = new HeaderCellDetails(table, i);
                
                beforeHeaderCell(headerCellDetails);
                writeHeaderCell(headerCellDetails);
                afterHeaderCell(headerCellDetails);
            }
            
            afterHeaderRow(table);
        }
    }
    
    /**
     * Writes the row from given <code>rowDetails</code>
     * 
     * @param rowDetails the row details of the row being exported. Cannot be <code>null</code>.
     */
    public void writeRow(RowDetails rowDetails) {
        Util.checkForNotNull(rowDetails, "rowDetails");
        
        //Generate the row data
        generateRowData(rowDetails);

        DataExporterCallback callback = rowDetails.getTable().getCallback();
        if (callback != null) {
            callback.beforeRow(rowDetails);
        }
        
        beforeRow(rowDetails);
        
        for (int columnIndex = 0; columnIndex < rowDetails.getTable().getColumns().size(); columnIndex++) {
            CellDetails cellDetails = new CellDetails(rowDetails, columnIndex);
            cellDetails.setCellValue(rowDetails.getRow().getCellValue(cellDetails));
            
            if (callback != null) {
                callback.beforeCell(cellDetails);
            }
            
            beforeRowCell(cellDetails);
            writeRowCell(cellDetails);
            afterRowCell(cellDetails);

            if (callback != null) {
                callback.afterCell(cellDetails);
            }
        }
        
        afterRow(rowDetails);

        if (callback != null) {
            callback.afterRow(rowDetails);
        }
    }
    
    protected void print(char value) {
        print("" + value);
    }

    protected void print(String value) {
        out.print(options.isEscapeHtml()?StringEscapeUtils.escapeHtml(value):value);
        
        if (autoFlush) {
            out.flush();
        }
    }
    
    protected void println(String value) {
        out.print(options.isEscapeHtml()?StringEscapeUtils.escapeHtml(value):value);
        println();
        
        if (autoFlush) {
            out.flush();
        }
    }
    
    protected void println() {
        out.print(options.getLineSeparatorString());
        
        if (autoFlush) {
            out.flush();
        }
    }
    
    public void flush() {
        out.flush();
    }
    
    public void finishExporting() {
        rowIndex = new AtomicInteger();
    }

    /**
     * Method generates the cell values for columns which generates its own data
     * and gives a chance for cell override if there is a call back.
     * 
     * @param rowDetails
     */
    protected void generateRowData(RowDetails rowDetails) {
        List<Column> columns = rowDetails.getTable().getColumns();
        List<Object> cellValues = new ArrayList<Object>();
        
        //If column is configured as 'generates own data', then there would
        //be less number of cell values in the row. We need to fill those
        //missing cell values with null before asking call back to generate
        //the data. This is to make sure column index reference is consistent.
        int skippedColumns = 0;
        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            Column column = columns.get(columnIndex);
            CellDetails cellDetails = new CellDetails(rowDetails, columnIndex - skippedColumns);
            cellDetails.setColumn(column);
            
            if (column.isGeneratesOwnData()) {
                cellValues.add(null);
                skippedColumns++;
            } else {
                Object cellValue = null;
                
                if (rowDetails.getRow() instanceof BeanRow) {
                    BeanRow beanRow = (BeanRow) rowDetails.getRow();
                    cellValue = beanRow.getCellValue(column.getName());
                } else {
                    //If there are less number of cells added to the row than there are columns,
                    //we would assume rest of the cells as nulls.
                    if (rowDetails.getRow().getCellValues().size() > cellDetails.getColumnIndex()) {
                        cellValue = rowDetails.getRow().getCellValue(cellDetails);
                    }
                }
                
                if (cellValue == null) {
                    cellValue = options.getNullString();
                }
                cellValues.add(cellValue);
            }
        }
        
        rowDetails.getRow().setCellValues(cellValues);
        
        //Go ahead and ask the call back to generate the data for such column.
        //After generating the data, go ahead and ask the callback to override if
        //applicable.
        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            
            CellDetails cellDetails = new CellDetails(rowDetails, columnIndex);
            Object cellValue = null;
            Column column = columns.get(columnIndex);
            
            if (column.isGeneratesOwnData()) {
                if (column.getCellValueGenerator() == null) {
                    throw new RuntimeException("Column " + column +  " configured as own data generator but callback is not configured.");
                }
                cellValue = column.getCellValueGenerator().generateCellValue(cellDetails);
            } else {
                cellValue = rowDetails.getRow().getCellValue(cellDetails);
            }
            cellDetails.setCellValue(cellValue);
            
            rowDetails.getRow().setCellValue(columnIndex, cellValue);
        }
    }

    /**
     * Hook which would be called before exporting any data.
     * 
     * @param table the table being exported.
     */
    public abstract void beforeTable(Table table);

    public abstract void beforeHeaderRow(Table table);

    public abstract void beforeHeaderCell(HeaderCellDetails headerCell);

    public abstract void writeHeaderCell(HeaderCellDetails headerCell);

    public abstract void afterHeaderCell(HeaderCellDetails headerCell);

    public abstract void afterHeaderRow(Table table);

    public abstract void beforeRow(RowDetails rowDetails);

    public abstract void beforeRowCell(CellDetails cellDetails);

    public abstract void writeRowCell(CellDetails cellDetails);

    public abstract void afterRowCell(CellDetails cellDetails);

    public abstract void afterRow(RowDetails rowDetails);

    public abstract void beforeFooterRow(Table table);

//    public abstract void beforeFooterCell(FooterCellDetails footerCellDetails);
//
//    public abstract void writeFooterCell(FooterCellDetails footerCellDetails);
//
//    public abstract void afterFooterCell(FooterCellDetails footerCellDetails);

    public abstract void afterFooterRow(List<Column> columns);

    public abstract void afterTable(Table table);
}
