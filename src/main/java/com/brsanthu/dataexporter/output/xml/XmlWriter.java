package com.brsanthu.dataexporter.output.xml;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang.StringEscapeUtils;

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
        print("<column name=\"" + cellDetails.getColumn().getTitle() + "\">" + 
            StringEscapeUtils.escapeXml(cellDetails.getColumn().format(cellDetails)) +"</column>");
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
