package com.brsanthu.dataexporter.output.wiki;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class WikiExporter extends DataExporter {

    public WikiExporter(OutputStream out) {
        this(new WikiExportOptions(), out);
    }

    public WikiExporter(WikiExportOptions options, OutputStream out) {
        super(new WikiWriter(options, out));
    }

    public WikiExporter(Writer out) {
        this(new WikiExportOptions(), out);
    }
    
    public WikiExporter(WikiExportOptions textExportOptions, Writer out) {
        super(new WikiWriter(textExportOptions, out));
    }
    
    public WikiExporter() {
        this(System.out);
    }
    
    public WikiExporter(WikiExportOptions options) {
        this(options, System.out);
    }

    public WikiExportOptions getTextExportOptions() {
        return (WikiExportOptions) getDataWriter().getOptions();
    }
}
