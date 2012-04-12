package com.brsanthu.dataexporter.model;



/**
 * Column which outputs the current row number, starting from 1.
 * 
 * @author Santhosh Kumar
 */
public class LineNumberColumn extends NumberColumn {
    
    public LineNumberColumn(String name, int width) {
        this(name, null, width);
    }

    public LineNumberColumn(String name, String title, int width) {
        super(name, title, width, 0);
        setGeneratesOwnData(true);
        setCellValueGenerator(new CellValueGenerator() {
            @Override
            public Object generateCellValue(CellDetails cellDetails) {
                return new Integer(cellDetails.getRowIndex() + 1);
            }
        });
    }
}
