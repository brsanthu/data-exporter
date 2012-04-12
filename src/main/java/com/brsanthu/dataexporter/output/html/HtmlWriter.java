package com.brsanthu.dataexporter.output.html;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang.StringEscapeUtils;

import com.brsanthu.dataexporter.AbstractDataWriter;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.HeaderCellDetails;
import com.brsanthu.dataexporter.model.RowDetails;
import com.brsanthu.dataexporter.model.Table;

public class HtmlWriter extends AbstractDataWriter {
    
    public HtmlWriter(HtmlExportOptions options) {
        super(options, System.out);
    }

    public HtmlWriter(HtmlExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public HtmlWriter(OutputStream out) {
        super(new HtmlExportOptions(), out);
    }

    public HtmlWriter(HtmlExportOptions options, Writer out) {
        super(options, out);
    }

    public HtmlWriter(Writer out) {
        super(new HtmlExportOptions(), out);
    }
    
    public HtmlExportOptions getHtmlExportOptions() {
        return (HtmlExportOptions) getOptions();
    }
    
    @Override
    public void beforeTable(Table table) {
        print("<html>");
        prettyPrint(1);
        print("<head><meta content=\"text/html;charset=UTF-8\"/></head>");
        prettyPrint(1);
        print("<body>");
        prettyPrint(2);
        print("<table border=1>");
    }
    
    @Override
    public void beforeHeaderRow(Table table) {
        prettyPrint(3);
        print("<tr>");
    }

    @Override
    public void beforeHeaderCell(HeaderCellDetails headerCell) {
        prettyPrint(4);
        print("<th>");
    }
    
    @Override
    public void writeHeaderCell(HeaderCellDetails headerCell) {
        print(headerCell.getColumn().getTitle());
    }
    
    @Override
    public void afterHeaderCell(HeaderCellDetails headerCell) {
        print("</th>");
    }
    
    @Override
    public void afterHeaderRow(Table table) {
        prettyPrint(3);
        print("</tr>");
    }

    @Override
    public void beforeRow(RowDetails rowDetails) {
        prettyPrint(3);
        print("<tr>");
    }
    
    @Override
    public void beforeRowCell(CellDetails cellDetails) {
        prettyPrint(4);
        print("<td>");
    }
    
    @Override
    public void writeRowCell(CellDetails cellDetails) {
        print(StringEscapeUtils.escapeHtml(cellDetails.getColumn().format(cellDetails)));
    }

    @Override
    public void afterRowCell(CellDetails cellDetails) {
        print("</td>");
    }
    
    @Override
    public void afterRow(RowDetails rowDetails) {
        prettyPrint(3);
        print("</tr>");
    }
    
    @Override
    public void afterTable(Table table) {
        prettyPrint(2);
        print("</table>");
        prettyPrint(1);
        print("</body>");
        prettyPrint(0);
        print("</html>");
    }
    
    private void prettyPrint(int level) {
        if (getHtmlExportOptions().isPrettyPrint()) {
            print("\n");
            for (int i = 0; i < level; i++) {
                print('\t');
            }
        }
    }
}
