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
package com.brsanthu.dataexporter.output.text;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.AbstractDataWriter;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.HeaderCellDetails;
import com.brsanthu.dataexporter.model.RowDetails;

public class TextWriter extends AbstractDataWriter {
    
    public TextWriter() {
        this(System.out);
    }

    public TextWriter(TextExportOptions options) {
        super(options, System.out);
    }

    public TextWriter(TextExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public TextWriter(OutputStream out) {
        super(new TextExportOptions(), out);
    }

    public TextWriter(TextExportOptions options, Writer out) {
        super(options, out);
    }

    public TextWriter(Writer out) {
        super(new TextExportOptions(), out);
    }
    
    public TextExportOptions getTextExportOptions() {
        return (TextExportOptions) getOptions();
    }

    @Override
    public void writeHeaderCell(HeaderCellDetails headerCell) {
        writeCell(headerCell.getColumnIndex(), headerCell.getColumn().getTitle());
    }
    
    @Override
    public void beforeRow(RowDetails rowDetails) {
        println();
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
}
