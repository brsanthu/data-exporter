package com.brsanthu.dataexporter.output.json;

import java.sql.Date;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;
import com.brsanthu.dataexporter.model.json.JsonExporter;

public class JsonExporterTest extends DataExporterTestBase {
    
    public JsonExporterTest() {
        exporter = new JsonExporter(sw);
    }
    
    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testBasic.txt", sw.toString());
    }
    
    @Test
    public void testFormatted() throws Exception {
        ((JsonExporter) exporter).getJsonExportOptions().setPrettyPrint(true);
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testFormatted.txt", sw.toString());
    }
    @Test
    public void testFormattedDoubleEscape() throws Exception {
        ((JsonExporter) exporter).getJsonExportOptions().setPrettyPrint(true).setDoubleEscape(true);
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testFormattedDoubleEscape.txt", sw.toString());
    }
}
