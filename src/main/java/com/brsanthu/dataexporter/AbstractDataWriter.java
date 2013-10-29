/*
 * #%L
 * data-exporter
 * %%
 * Copyright (C) 2012 - 2013 http://www.brsanthu.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
