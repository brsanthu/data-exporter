package com.brsanthu.dataexporter.output.texttable;

import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.brsanthu.dataexporter.AbstractDataWriter;
import com.brsanthu.dataexporter.model.AlignType;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.Column;
import com.brsanthu.dataexporter.model.DataExporterCallback;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;

import static com.brsanthu.dataexporter.util.Util.*;

public class TextTableWriter extends AbstractDataWriter {
    
    private List<Column> columns;
    
    public TextTableWriter(TextTableExportOptions options) {
        this(options, System.out);
    }

    public TextTableWriter(OutputStream out) {
        this(new TextTableExportOptions(), out);
    }

    public TextTableWriter(Writer out) {
        this(new TextTableExportOptions(), out);
    }
    
    public TextTableWriter(TextTableExportOptions options, OutputStream out) {
        super(options, out);
    }

    public TextTableWriter(TextTableExportOptions options, Writer out) {
        super(options, out);
    }
    
    public TextTableExportOptions getTextTableExportOptions() {
        return (TextTableExportOptions) getOptions();
    }
    
    @Override
    public void writeHeader(Table table) {
        columns = table.getColumns();
        
        TextTableExportOptions options = getTextTableExportOptions();
        
        if (options.isPrintHeaders()) {
            //Render the top border
            printTopBorder();
            
            //Format header into multiple lines and render with dividers and separators.
            printHeaderCells(formatHeaderCells());
        }
        
        //Render the top border
        printTopDownBorder();
    }
    
    @Override
    public void writeRow(RowDetails rowDetails) {
        
        //If repeat header after rows is specified, and if that condition
        //is come, print the headers.
        if (getTextTableExportOptions().getRepeatHeadersAfterRows() > 0) {
            if (rowDetails.getRowIndex() != 0 && rowDetails.getRowIndex() % getTextTableExportOptions().getRepeatHeadersAfterRows() == 0) {
                printBottomBorder();
                println();
                writeHeader(rowDetails.getTable());
            }
        }
        
        //Generate all row data as required.
        generateRowData(rowDetails);
        
        DataExporterCallback callback = rowDetails.getTable().getCallback();
        if (callback != null) {
            callback.beforeRow(rowDetails);
        }

        //Format the row into cells
        List<List<String>> rowCells = formatRowCells(rowDetails);
        
        //Render left row divider
        printLine(getStyle().getCenterLeftDivider(), getStyle().getCenterLeftRightDivider(), 
            getStyle().getCenterCenterDivider(), getStyle().getCenterRightLeftDivider(), 
            getStyle().getCenterRightDivider(), rowCells);
        
        if (callback != null) {
            callback.afterRow(rowDetails);
        }
    }
    
    
    @Override
    public void afterTable(Table table) {
        //Render the final border
        printBottomBorder();
    }
    
    public List<List<String>> formatRowCells(RowDetails rowDetails) {
        
        DataExporterCallback callback = rowDetails.getTable().getCallback();

        int maxRowHeight = Math.max(getTextTableExportOptions().getMinRowHeight(), getMaxRowHeight(rowDetails));
        
        List<List<String>> rowLines = new ArrayList<List<String>>();
        for (int j = 0; j < maxRowHeight; j++) {
            rowLines.add(new ArrayList<String>());
        }

        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            Column column = columns.get(columnIndex);
            
            CellDetails cellDetails = new CellDetails(rowDetails, columnIndex);
            cellDetails.setRowHeight(maxRowHeight);
            cellDetails.setCellValue(rowDetails.getRow().getCellValue(cellDetails));
            cellDetails.setCellAlign(cellDetails.getColumn().getAlign());
            
            if (callback != null) {
                callback.beforeCell(cellDetails);
            }

            List<String> cells = column.align(cellDetails, column.format(cellDetails));
            for (int j = 0; j < maxRowHeight; j++) {
                rowLines.get(j).add(cells.get(j));
            }

            if (callback != null) {
                callback.afterCell(cellDetails);
            }
        }
        
        return rowLines;
    }

    public int getMaxRowHeight(RowDetails rowDetails) {
        int height = 1;
        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            CellDetails cellDetails = new CellDetails(rowDetails, columnIndex);
            Column column = columns.get(columnIndex);
            
            Object cellValue = null;
            if (column.isGeneratesOwnData()) {
                cellValue = column.getCellValueGenerator().generateCellValue(cellDetails);
            } else {
                cellValue = rowDetails.getRow().getCellValue(cellDetails);
            }
            cellDetails.setCellValue(cellValue);
            
            height = Math.max(height, column.getMaxRowHeight(cellDetails));
        }
        
        return height;
    }
    
    protected void printTopBorder() {
        printLine(getStyle().getTopLeftIntersection(), getStyle().getTopRightIntersection(), 
            getStyle().getTopCenterIntersection(), getStyle().getTopRightLeftIntersection(), 
            getStyle().getTopRightIntersection(), getStyle().getTopBorder());
    }
    
    public void printTopDownBorder() {
        printLine(getStyle().getTopDownLeftIntersection(), getStyle().getTopDownRightIntersection(), 
            getStyle().getTopDownCenterIntersection(), getStyle().getTopDownRightLeftIntersection(), 
            getStyle().getTopDownRightIntersection(), getStyle().getTopDownBorder());
    }

    public void printBottomBorder() {
        printLine(getStyle().getBottomLeftIntersection(), getStyle().getBottomRightIntersection(), 
            getStyle().getBottomCenterIntersection(), getStyle().getBottomRightLeftIntersection(), 
            getStyle().getBottomRightIntersection(), getStyle().getBottomBorder());
    }

    public void printHeaderCells(List<List<String>> headerLines) {
        printLine(getStyle().getTopLeftDivider(), getStyle().getTopRightDivider(), getStyle().getTopCenterDivider(), 
            getStyle().getTopRightLeftDivider(), getStyle().getTopRightDivider(), headerLines);
    }

    public void printLine(String left, String leftRight, String center, 
                    String rightLeft, String right, List<List<String>> cells) {
        for (List<String> rowLine : cells) {
            printLine(left, leftRight, center, rightLeft, right, rowLine, null);
        }
    }

    public void printLine(String left, String leftRight, String center, 
                    String rightLeft, String right, String border) {
        printLine(left, leftRight, center, rightLeft, right, null, border);
    }

    public void printLine(String left, String leftRight, String center, 
                    String rightLeft, String right, List<String> cellValues, String defaultValue) {
        
        if ("".equalsIgnoreCase(defaultValue)) {
            defaultValue = " ";
        }
        
        StringBuilder sb = new StringBuilder();
        
        //Render left intersection
        sb.append(left);
        
        for (int i = 0; i < columns.size(); i++) {
            //Render the first column width using border char
            sb.append(cellValues!=null?cellValues.get(i):createString(defaultValue, columns.get(i).getWidth()));
            
            if (i == columns.size() - 1) {
                //Last column so print the right intersection
                sb.append(right);
                
            } else if (i == 0) {
                //If there are two columns, print the left right column and then right column
                sb.append(leftRight);

            } else if (i == columns.size() - 2) {
                //If there are three columns, print the left right column and then right column
                sb.append(rightLeft);
                
            } else {
                sb.append(center);
            }
        }

        //If trimmed buffer is empty, just skip the line.
        if (sb.toString().trim().length() != 0) {
            print(sb.toString());
            println();
        }
    }
    
    public List<List<String>> formatHeaderCells() {
        
        int maxHeaderHeight = 0;
        for (Column column : columns) {
            maxHeaderHeight = Math.max(maxHeaderHeight, Column.getMaxRowHeight(column.getWidth(), column.getTitle()));
        }

        //Init the header lines array which would store the formatted/aligned strings
        List<List<String>> headerLines = new ArrayList<List<String>>();
        for (int j = 0; j < maxHeaderHeight; j++) {
            headerLines.add(new ArrayList<String>());
        }
        
        for (int i = 0; i < columns.size(); i++) {
            
            Column column = columns.get(i);
            AlignType align = getTextTableExportOptions().getHeaderAlignment();
            if (align == null) {
                align = column.getAlign();
            }

            List<String> cells = Column.align(column.getWidth(), maxHeaderHeight, align, column.getTitle());
            for (int j = 0; j < maxHeaderHeight; j++) {
                headerLines.get(j).add(cells.get(j));
            }
        }
        
        return headerLines;
    }
    
    protected TextTableExportStyle getStyle() {
        return getTextTableExportOptions().getStyle();
    }
    
}
