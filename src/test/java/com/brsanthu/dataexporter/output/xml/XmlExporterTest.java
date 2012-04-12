package com.brsanthu.dataexporter.output.xml;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;

public class XmlExporterTest extends DataExporterTestBase {
    
    public XmlExporterTest() {
        exporter = new XmlExporter(sw);
    }
    
    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testBasic.txt", sw.toString());
    }

    @Test
    public void testFormatted() throws Exception {
        ((XmlExportOptions)exporter.getOptions()).setPrettyPrint(true);
        addData();
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testFormatted.txt", sw.toString());
    }
}
