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
package com.brsanthu.dataexporter.output.wiki;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.AbstractDataWriter;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.HeaderCellDetails;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;

/**
 * Wiki write which writes the output in wiki format. Sample output is as follows.
 * 
 * <pre>
 * ||Line No||Date Purchased||Item No||Item Name||Shipped?||Quantity||Unit Price||Price||
 * ||1||2011/04/07 08:48:39 AM||1||Laptop||No||1||$799.78||$799.78||
 * ||2||2011/04/04 05:01:15 PM||2||Mouse||Yes||2||$49.30||$98.60||
 * ||3||2011/04/04 04:27:13 PM||3||Keyboard||No||5||$75.00||$375.00||
 * </pre>
 * 
 * @author Santhosh Kumar
 */
public class WikiWriter extends AbstractDataWriter {
    
    public WikiWriter() {
        this(System.out);
    }

    public WikiWriter(WikiExportOptions options) {
        super(options, System.out);
    }

    public WikiWriter(WikiExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public WikiWriter(OutputStream out) {
        super(new WikiExportOptions(), out);
    }

    public WikiWriter(WikiExportOptions options, Writer out) {
        super(options, out);
    }

    public WikiWriter(Writer out) {
        super(new WikiExportOptions(), out);
    }
    
    public WikiExportOptions getTextExportOptions() {
        return (WikiExportOptions) getOptions();
    }

    @Override
    public void beforeHeaderRow(Table table) {
        println();
        print(getTextExportOptions().getDelimiter());
    }
    
    @Override
    public void writeHeaderCell(HeaderCellDetails headerCell) {
        writeCell(headerCell.getColumnIndex(), headerCell.getColumn().getTitle());
    }
    
    @Override
    public void afterHeaderRow(Table table) {
        print(getTextExportOptions().getDelimiter());
    }
    
    @Override
    public void beforeRow(RowDetails rowDetails) {
        println();
        print(getTextExportOptions().getDelimiter());
    }
    
    @Override
    public void writeRowCell(CellDetails cellDetails) {
        Object cellValue = cellDetails.getCellValue();
        writeCell(cellDetails.getColumnIndex(), cellValue==null?"":cellDetails.getColumn().format(cellDetails));
    }
    
    public void writeCell(int i, String cellValue) {
        String delimiter = getTextExportOptions().getDelimiter();
        if (i != 0) {
            print(delimiter);
        }
        
        print(cellValue);
    }
    
    @Override
    public void afterRow(RowDetails rowDetails) {
        print(getTextExportOptions().getDelimiter());
    }
}
