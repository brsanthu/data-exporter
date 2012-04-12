package com.brsanthu.dataexporter.output.wiki;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;

public class WikiExporterTest extends DataExporterTestBase {
    
    public WikiExporterTest() {
        exporter = new WikiExporter(sw);
    }
    
    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.finishExporting();
        
        System.out.println(sw);
        compareText("testBasic.txt", sw.toString());
    }
}
