package com.brsanthu.dataexporter;

import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.Column;
import com.brsanthu.dataexporter.model.HeaderCellDetails;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;

/**
 * Empty implementation of {@link DataWriter}. All other data writers must extend this instead
 * of DataWriter to keep it backward compatible.
 * 
 * @author Santhosh Kumar
 */
public class AbstractDataWriter extends DataWriter {

    public AbstractDataWriter(ExportOptions options, OutputStream out) {
        super(options, out);
    }

    public AbstractDataWriter(ExportOptions options, Writer out) {
        super(options, out);
    }

    @Override
    public void beforeTable(Table table) {
        //do nothing
        
    }

    @Override
    public void beforeHeaderRow(Table table) {
        //do nothing
        
    }

    @Override
    public void beforeHeaderCell(HeaderCellDetails headerCell) {
        //do nothing
        
    }

    @Override
    public void writeHeaderCell(HeaderCellDetails headerCell) {
        //do nothing
        
    }

    @Override
    public void afterHeaderCell(HeaderCellDetails headerCell) {
        //do nothing
        
    }

    @Override
    public void afterHeaderRow(Table table) {
        //do nothing
        
    }

    @Override
    public void beforeRow(RowDetails rowDetails) {
        //do nothing
        
    }

    @Override
    public void beforeRowCell(CellDetails cellDetails) {
        //do nothing
        
    }

    @Override
    public void writeRowCell(CellDetails cellDetails) {
        //do nothing
        
    }

    @Override
    public void afterRowCell(CellDetails cellDetails) {
        //do nothing
        
    }

    @Override
    public void afterRow(RowDetails rowDetails) {
        //do nothing
        
    }

    @Override
    public void beforeFooterRow(Table table) {
        //do nothing
        
    }

//    @Override
//    public void beforeFooterCell(FooterCellDetails footerCellDetails) {
//        //do nothing
//        
//    }
//
//    @Override
//    public void writeFooterCell(FooterCellDetails footerCellDetails) {
//        //do nothing
//        
//    }
//
//    @Override
//    public void afterFooterCell(FooterCellDetails footerCellDetails) {
//        //do nothing
//        
//    }

    @Override
    public void afterFooterRow(List<Column> columns) {
        //do nothing
        
    }

    @Override
    public void afterTable(Table table) {
        //do nothing
        
    }

}
