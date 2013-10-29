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
package com.brsanthu.dataexporter.model.json;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;

import com.brsanthu.dataexporter.AbstractDataWriter;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;
import com.brsanthu.dataexporter.output.xml.XmlExporter;

/**
 * Writer which writes in xml format. Users wouldn't typically use this class directly
 * but use this via {@link XmlExporter}.
 * 
 * @author Santhosh Kumar
 */
public class JsonWriter extends AbstractDataWriter {

    public JsonWriter(JsonExportOptions options) {
        super(options, System.out);
    }

    public JsonWriter(JsonExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public JsonWriter(OutputStream out) {
        super(new JsonExportOptions(), out);
    }

    public JsonWriter(JsonExportOptions options, Writer out) {
        super(options, out);
    }

    public JsonWriter(Writer out) {
        super(new JsonExportOptions(), out);
    }
    
    public JsonExportOptions getJsonExportOptions() {
        return (JsonExportOptions) getOptions();
    }
    
    @Override
    public void beforeTable(Table table) {
        print("{");
        prettyPrint(1);
        print("\"table\": {");
    }
    
    @Override
    public void beforeRow(RowDetails rowDetails) {
        
        if (rowDetails.getRowIndex() != 0) {
            print(", ");
        }
        prettyPrint(2);
        print("\"row\": {");
    }
    
    @Override
    public void writeRowCell(CellDetails cellDetails) {
        prettyPrint(3);
        print("\"" + cellDetails.getColumn().getName() + "\":");
        
        Object cellValue = cellDetails.getCellValue();
        String cellValueString = cellValue.toString();
        
        if (cellValue instanceof Number || cellValue instanceof Boolean) {
            print(cellValueString);
        } else {
            
            if (cellValueString.contains("\"")) {

                String replaceWith = null;
                if (getJsonExportOptions().isDoubleEscape()) {
                    replaceWith = "\\\\\"";
                } else {
                    replaceWith = "\\\"";
                }
                
                cellValueString = StringUtils.replace(cellValueString, "\"", replaceWith);
            }
            print("\"" + cellValueString + "\"");
        }
        
        if (cellDetails.getColumnIndex() != cellDetails.getTable().getColumns().size() - 1) {
            print(",");
        }
    }
    
    @Override
    public void afterRow(RowDetails rowDetails) {
        prettyPrint(2);
        print("}");
    }
    
    @Override
    public void afterTable(Table table) {
        prettyPrint(1);
        print("}");
        
        prettyPrint(0);
        print("}");
    }

    private void prettyPrint(int level) {
        if (getJsonExportOptions().isPrettyPrint()) {
            print("\n");
            for (int i = 0; i < level; i++) {
                print('\t');
            }
        }
    }
}
