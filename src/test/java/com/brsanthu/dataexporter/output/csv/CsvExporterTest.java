package com.brsanthu.dataexporter.output.csv;

import java.sql.Date;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;

public class CsvExporterTest extends DataExporterTestBase {
    
    public CsvExporterTest() {
        exporter = new CsvExporter(sw);
    }
    
    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap,top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testBasic.txt", sw.toString());
    }

    @Test
    public void testStictQuoting() throws Exception {
        ((CsvExportOptions) exporter.getOptions()).setStrictQuoting(true);
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap,top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
       
        System.out.println(sw.toString());
        compareText("testStictQuoting.txt", sw.toString());
    }
}
