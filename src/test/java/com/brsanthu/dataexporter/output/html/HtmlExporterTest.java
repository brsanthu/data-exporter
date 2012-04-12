package com.brsanthu.dataexporter.output.html;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;

public class HtmlExporterTest extends DataExporterTestBase {
    
    public HtmlExporterTest() {
        exporter = new HtmlExporter(sw);
    }

    @Test
    public void testFormatted() throws Exception {
        ((HtmlExporter) exporter).getHtmlExportOptions().setPrettyPrint(true);

        addData();
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testFormatted.txt", sw.toString());
    }

    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testBasic.txt", sw.toString());
    }
}
