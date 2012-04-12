package com.brsanthu.dataexporter.model;



/**
 * String column which displays the given string. Default alignment is middle left.
 * 
 * @author Santhosh Kumar
 */
public class StringColumn extends Column {

    public StringColumn(String name) {
        super(name);
    }

    public StringColumn(String name, int width) {
        this(name, width, AlignType.MIDDLE_LEFT);
    }

    public StringColumn(String name, String title, int width) {
        this(name, title, width, AlignType.MIDDLE_LEFT);
    }

    public StringColumn(String name, int width, AlignType align) {
        super(name, width, align);
    }

    public StringColumn(String name, String title, int width, AlignType align) {
        super(name, title, width, align);
    }
    
    @Override
    public int getMaxRowHeight(CellDetails cellDetails) {
        if (cellDetails.getCellValue() == null) {
            return 1;
        }
        
        return getMaxRowHeight( cellDetails.getCellValue().toString());
    }
    
    @Override
    public String format(CellDetails cellDetails) {
        if (cellDetails.getCellValue() == null) {
            return "";
        }
        
        return cellDetails.getCellValue().toString();
    }
}
