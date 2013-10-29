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
package com.brsanthu.dataexporter.output.xml;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang3.StringEscapeUtils;

import com.brsanthu.dataexporter.AbstractDataWriter;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;

/**
 * Writer which writes in xml format. Users wouldn't typically use this class directly
 * but use this via {@link XmlExporter}.
 * 
 * @author Santhosh Kumar
 */
public class XmlWriter extends AbstractDataWriter {

    public XmlWriter(XmlExportOptions options) {
        super(options, System.out);
    }

    public XmlWriter(XmlExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public XmlWriter(OutputStream out) {
        super(new XmlExportOptions(), out);
    }

    public XmlWriter(XmlExportOptions options, Writer out) {
        super(options, out);
    }

    public XmlWriter(Writer out) {
        super(new XmlExportOptions(), out);
    }
    
    public XmlExportOptions getXmlExportOptions() {
        return (XmlExportOptions) getOptions();
    }
    
    @Override
    public void beforeTable(Table table) {
        print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        prettyPrint(0);
        print("<table>");
    }
    
    @Override
    public void beforeRow(RowDetails rowDetails) {
        prettyPrint(1);
        print("<row>");
    }
    
    @Override
    public void writeRowCell(CellDetails cellDetails) {
        prettyPrint(2);
        String title = cellDetails.getColumn().getTitle();
        String title2 = cellDetails.getColumn().getTitle2();
        String title3 = cellDetails.getColumn().getTitle3();
        String name = title + (!"".equals(title2) ? " " + title2 : "") + (!"".equals(title3) ? " " + title3 : "");
        String cellValue = StringEscapeUtils.escapeXml(cellDetails.getColumn().format(cellDetails));
        String nil = cellDetails.getColumn().isNillable() && "".equals(cellValue) ? " xsi:nil=\"true\"" : "";
        print("<column name=\"" + name + "\"" + nil + ">" + cellValue + "</column>");
    }
    
    @Override
    public void afterRow(RowDetails rowDetails) {
        prettyPrint(1);
        print("</row>");
    }
    
    @Override
    public void afterTable(Table table) {
        prettyPrint(0);
        print("</table>");
    }

    private void prettyPrint(int level) {
        if (getXmlExportOptions().isPrettyPrint()) {
            print("\n");
            for (int i = 0; i < level; i++) {
                print('\t');
            }
        }
    }
}
