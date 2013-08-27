package com.brsanthu.dataexporter.output.tree;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class TreeExporter extends DataExporter {

    public TreeExporter(OutputStream out) {
        this(new TreeExportOptions(), out);
    }

    public TreeExporter(TreeExportOptions options, OutputStream out) {
        super(new TreeWriter(options, out));
    }

    public TreeExporter(Writer out) {
        this(new TreeExportOptions(), out);
    }
    public TreeExporter(TreeExportOptions options, Writer out) {
        super(new TreeWriter(options, out));
    }
    
    public TreeExporter() {
        this(System.out);
    }
    public TreeExporter(TreeExportOptions options) {
        this(options, System.out);
    }
    
    public TreeExportOptions getTreeExporterOptions() {
        return (TreeExportOptions) getOptions();
    }
}
