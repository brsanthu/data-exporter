package com.brsanthu.dataexporter.model.json;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class JsonExporter extends DataExporter {

    public JsonExporter(OutputStream out) {
        this(new JsonExportOptions(), out);
    }

    public JsonExporter(JsonExportOptions options, OutputStream out) {
        super(new JsonWriter(options, out));
    }

    public JsonExporter(Writer out) {
        this(new JsonExportOptions(), out);
    }
    
    public JsonExporter(JsonExportOptions textExportOptions, Writer out) {
        super(new JsonWriter(textExportOptions, out));
    }
    
    public JsonExporter() {
        this(System.out);
    }
    
    public JsonExporter(JsonExportOptions options) {
        this(options, System.out);
    }

    public JsonExportOptions getJsonExportOptions() {
        return (JsonExportOptions) getDataWriter().getOptions();
    }
}
