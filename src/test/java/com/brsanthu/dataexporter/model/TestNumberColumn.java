package com.brsanthu.dataexporter.model;

import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

import com.brsanthu.dataexporter.output.text.TextExporter;

import static org.junit.Assert.*;

public class TestNumberColumn {
    
    @Test
    public void testNumberColumn() throws Exception {
        StringWriter sw = new StringWriter();
        
        TextExporter exporter = new TextExporter(sw);
        exporter.getOptions().setPrintHeaders(false);
        exporter.addColumns(new NumberColumn("number", 10, 10));
        exporter.addRow((float)22/7);
        exporter.finishExporting();
        assertEquals("3.1428570747", sw.toString().trim());
        
        exporter = new TextExporter(sw);
        exporter.getOptions().setPrintHeaders(false);
        exporter.addColumns(new NumberColumn("number", 10, 10));
        exporter.addRow((float)22/7);
        exporter.finishExporting();
    }
    
    @Test
    public void testNumberDecimalFormatter() throws Exception {
        StringWriter sw = new StringWriter();
        
        TextExporter exporter = new TextExporter(sw);
        exporter.getOptions().setPrintHeaders(false);

        exporter.addColumns(new NumberColumn("number", 10, NumberFormat.getNumberInstance(Locale.GERMAN)));
        exporter.addRow(1234567.234);
        exporter.finishExporting();
        assertEquals("1.234.567,234", sw.toString().trim());
	}
}
