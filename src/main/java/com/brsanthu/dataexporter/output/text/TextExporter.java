package com.brsanthu.dataexporter.output.text;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class TextExporter extends DataExporter {

    public TextExporter(OutputStream out) {
        this(new TextExportOptions(), out);
    }

    public TextExporter(TextExportOptions options, OutputStream out) {
        super(new TextWriter(options, out));
    }

    public TextExporter(Writer out) {
        this(new TextExportOptions(), out);
    }
    
    public TextExporter(TextExportOptions textExportOptions, Writer out) {
        super(new TextWriter(textExportOptions, out));
    }
    
    public TextExporter() {
        this(System.out);
    }
    
    public TextExporter(TextExportOptions options) {
        this(options, System.out);
    }

    public TextExportOptions getTextExportOptions() {
        return (TextExportOptions) getDataWriter().getOptions();
    }
}
