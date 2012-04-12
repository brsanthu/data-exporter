package com.brsanthu.dataexporter.output.csv;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class CsvExporter extends DataExporter {
    public CsvExporter(OutputStream out) {
        this(new CsvExportOptions(), out);
    }

    public CsvExporter(CsvExportOptions options, OutputStream out) {
        super(new CsvWriter(options, out));
    }

    public CsvExporter(Writer out) {
        this(new CsvExportOptions(), out);
    }
    public CsvExporter(CsvExportOptions csvExportOptions, Writer out) {
        super(new CsvWriter(csvExportOptions, out));
    }
    
    public CsvExporter() {
        this(System.out);
    }
    public CsvExporter(CsvExportOptions options) {
        this(options, System.out);
    }

    public CsvExportOptions getCsvExportOptions() {
        return (CsvExportOptions) getDataWriter().getOptions();
    }

}
