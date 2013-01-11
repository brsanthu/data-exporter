package com.brsanthu.dataexporter.output.html;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;
import com.brsanthu.dataexporter.model.AbstractDataExporterCallback;
import com.brsanthu.dataexporter.model.AlignType;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.DataExporterCallback;
import com.brsanthu.dataexporter.model.StringColumn;

public class HtmlExporterTest extends DataExporterTestBase {
    
    public HtmlExporterTest() {
        exporter = new HtmlExporter(sw);
    }

    @Test
    public void testFormatted() throws Exception {
        ((HtmlExporter) exporter).getHtmlExportOptions().setPrettyPrint(true);
        ((HtmlExporter) exporter).getHtmlExportOptions().setAlignCells(false);
        
        addData();
        exporter.finishExporting();
        
        System.out.println("Output of testFormatted===========================");
        System.out.println(sw.toString());
        compareText("testFormatted.txt", sw.toString());
    }

    @Test
    public void testBasic() throws Exception {
    	((HtmlExporter) exporter).getHtmlExportOptions().setAlignCells(false);
        addData();
        exporter.finishExporting();
        
        System.out.println("Output of testBasic===========================");
        System.out.println(sw.toString());
        compareText("testBasic.txt", sw.toString());
    }
    
    @Test
    public void testAlignment() throws Exception {
    	
        DataExporterCallback callback = new AbstractDataExporterCallback() {

            @Override
            public void beforeCell(CellDetails cellDetails) {
                int row = cellDetails.getRowIndex();
                int column = cellDetails.getColumnIndex();

                AlignType align = null;
                if (row == 0 && column == 1) {
                    align = AlignType.TOP_LEFT;
                } else if (row == 0 && column == 2) {
                    align = AlignType.TOP_CENTER;
                } else if (row == 0 && column == 3) {
                    align = AlignType.TOP_RIGHT;
                } else if (row == 1 && column == 1) {
                    align = AlignType.MIDDLE_LEFT;
                } else if (row == 1 && column == 2) {
                    align = AlignType.MIDDLE_CENTER;
                } else if (row == 1 && column == 3) {
                    align = AlignType.MIDDLE_RIGHT;
                } else if (row == 2 && column == 1) {
                    align = AlignType.BOTTOM_LEFT;
                } else if (row == 2 && column == 2) {
                    align = AlignType.BOTTOM_CENTER;
                } else if (row == 2 && column == 3) {
                    align = AlignType.BOTTOM_RIGHT;
                }

                cellDetails.setCellAlign(align);
            }
        };

        HtmlExporter exporter = new HtmlExporter(sw);
        exporter.getHtmlExportOptions().setPrettyPrint(true);        
        exporter.setCallback(callback);
        exporter.addColumns(new StringColumn("", 15, AlignType.MIDDLE_CENTER), new StringColumn(
                        "LEFT", 15), new StringColumn("CENTER", 15), new StringColumn("RIGHT", 15));

        String data = "This is alignment test with some reallyreallybig words";
        exporter.addRow("TOP", data, data, data);
        exporter.addRow("MIDDLE", data, data, data);
        exporter.addRow("BOTTOM", data, data, data);
        exporter.finishExporting();

        System.out.println("Output of testAlignment===========================");
        System.out.println(sw.toString());
        
        compareText("testAlignment.txt", sw.toString());
    }
}
