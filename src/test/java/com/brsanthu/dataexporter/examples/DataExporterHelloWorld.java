package com.brsanthu.dataexporter.examples;

import java.io.StringWriter;

import com.brsanthu.dataexporter.DataExporter;
import com.brsanthu.dataexporter.output.text.TextExporter;

public class DataExporterHelloWorld {
    
    public static void main(String[] args) {
//        DataExporter exporter = new TextExporter();
//        exporter.addColumn("Hello");
//        exporter.addRow("World!");
//        exporter.finishExporting();
        
        StringWriter sw = new StringWriter();
        
        DataExporter exporter = new TextExporter(sw);
        exporter.addColumn("Hello");
        exporter.addRow("World!");
        exporter.finishExporting();
        
        System.out.println(sw.toString());
    }
}
