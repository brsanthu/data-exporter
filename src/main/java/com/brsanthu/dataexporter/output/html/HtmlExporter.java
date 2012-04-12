package com.brsanthu.dataexporter.output.html;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class HtmlExporter extends DataExporter {
    
    public HtmlExporter(OutputStream out) {
        this(new HtmlExportOptions(), out);
    }

    public HtmlExporter(HtmlExportOptions options, OutputStream out) {
        super(new HtmlWriter(options, out));
    }

    public HtmlExporter(Writer out) {
        this(new HtmlExportOptions(), out);
    }
    public HtmlExporter(HtmlExportOptions options, Writer out) {
        super(new HtmlWriter(options, out));
    }
    
    public HtmlExporter() {
        this(System.out);
    }
    public HtmlExporter(HtmlExportOptions options) {
        this(options, System.out);
    }
    
    public HtmlExportOptions getHtmlExportOptions() {
        return (HtmlExportOptions) getOptions();
    }
}
