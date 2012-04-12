package com.brsanthu.dataexporter.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date column, which formats the given date as per given formating string. Format string is
 * same as documented in {@link SimpleDateFormat}
 * 
 * @author Santhosh Kumar
 */
public class DateColumn extends Column {
    
    private String dateFormat = null;
    private SimpleDateFormat df = null;
    
    public DateColumn(String name, int width, String dateFormat) {
        this(name, null, width, AlignType.MIDDLE_LEFT, dateFormat);
    }

    public DateColumn(String name, String title, int width, String dateFormat) {
        this(name, title, width, AlignType.MIDDLE_LEFT, dateFormat);
    }

    public DateColumn(String name, String title, int width, AlignType align, String dateFormat) {
        super(name, title, width, align);
        this.dateFormat = dateFormat;
        
        df = new SimpleDateFormat(dateFormat);
    }
    
    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    @Override
    public int getMaxRowHeight(CellDetails cellDetails) {
        Object cellValue = cellDetails.getCellValue();
        
        if (cellValue instanceof Date) {
            return (int) Math.ceil((float) df.format(cellValue).length()/getWidth());   
        }
        
        throw new IllegalArgumentException("Expected Date instance but it is " 
            + cellValue.getClass().getName() + " instance with value " + cellValue);
    }

    @Override
    public String format(CellDetails cellDetails) {
        return df.format((Date) cellDetails.getCellValue());
    }
}
