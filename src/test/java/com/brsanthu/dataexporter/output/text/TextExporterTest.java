package com.brsanthu.dataexporter.output.text;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;

public class TextExporterTest extends DataExporterTestBase {
    
    public TextExporterTest() {
        exporter = new TextExporter(sw);
    }
    
    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.finishExporting();
        
        System.out.println(sw);
        compareText("testBasic.txt", sw.toString());
    }
}
