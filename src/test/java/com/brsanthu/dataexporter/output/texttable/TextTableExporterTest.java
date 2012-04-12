package com.brsanthu.dataexporter.output.texttable;

import java.lang.reflect.Field;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;
import com.brsanthu.dataexporter.model.AbstractDataExporterCallback;
import com.brsanthu.dataexporter.model.AlignType;
import com.brsanthu.dataexporter.model.CellDetails;
import com.brsanthu.dataexporter.model.DataExporterCallback;
import com.brsanthu.dataexporter.model.StringColumn;

public class TextTableExporterTest extends DataExporterTestBase {

    public TextTableExporterTest() {
        exporter = new TextTableExporter(sw);
    }

    @Test
    public void testDefaultFormat() throws Exception {
        addData();
        exporter.finishExporting();

        System.out.println(sw.toString());
        compareText("testDefaultFormat.txt", sw.toString());
    }

    @Test
    public void testBeanRows() throws Exception {
        addDataBeans();
        exporter.finishExporting();

        System.out.println(sw.toString());
    }

    @Test
    public void testRepeatHeaders() throws Exception {
        ((TextTableExportOptions) exporter.getOptions()).setRepeatHeadersAfterRows(2);
        addData();
        exporter.finishExporting();

        System.out.println(sw.toString());
        compareText("testRepeatHeaders.txt", sw.toString());
    }

    @Test
    public void testMinRows() throws Exception {
        ((TextTableExportOptions) exporter.getOptions()).setMinRowHeight(3);
        addData();
        exporter.finishExporting();

        System.out.println(sw.toString());
        compareText("testMinRows.txt", sw.toString());
    }

    @Test
    public void testHeaderAlignment() throws Exception {
        ((TextTableExportOptions) exporter.getOptions()).setHeaderAlignment(AlignType.MIDDLE_LEFT);
        addData();
        exporter.finishExporting();

        System.out.println(sw.toString());
        compareText("testHeaderAlignment.txt", sw.toString());
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

        TextTableExporter exporter = new TextTableExporter(sw);
        exporter.setCallback(callback);
        exporter.addColumns(new StringColumn("", 15, AlignType.MIDDLE_CENTER), new StringColumn(
                        "LEFT", 15), new StringColumn("CENTER", 15), new StringColumn("RIGHT", 15));
        exporter.getTextTableExportOptions().setMinRowHeight(8);

        String data = "This is alignment test with some reallyreallybig words";
        exporter.addRow("TOP", data, data, data);
        exporter.addRow("MIDDLE", data, data, data);
        exporter.addRow("BOTTOM", data, data, data);
        exporter.finishExporting();

        System.out.println(sw.toString());
        
        compareText("testAlignment.txt", sw.toString());
    }
    
    @Test
    public void testPrintStyles() throws Exception {
        Field[] fields = TextTableExportStyle.class.getFields();
        for (Field field : fields) {
            if (field.getType().getName().equals(TextTableExportStyle.class.getName())) {

                System.out.println("");
                System.out.println("<h2>" + field.getName() + "</h2><pre>");
                exporter = new TextTableExporter();
                exporter.getOptions().setEscapeHtml(true);
                ((TextTableExportOptions) exporter.getOptions()).setStyle((TextTableExportStyle) field.get(null));
                setup();
                addData();
                exporter.finishExporting();
                System.out.println("</pre>");
            }
        }
    }
    
}
