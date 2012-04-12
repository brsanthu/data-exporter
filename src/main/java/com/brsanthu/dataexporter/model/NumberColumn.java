package com.brsanthu.dataexporter.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.brsanthu.dataexporter.util.Util;

/**
 * Number column which displays the formatted numbers.
 * 
 * @author Santhosh Kumar
 *
 */
public class NumberColumn extends Column {
    
	private NumberFormat formatter = null;
    private int precision = 2;
    private boolean grouping = true;
    private boolean bracketNegitive = false;
    
    public NumberColumn(String name, String title, int width, NumberFormat formatter) {
        this(name, title, width, AlignType.MIDDLE_RIGHT, formatter);
    }

    public NumberColumn(String name, String title, int width, int precision) {
        this(name, title, width, AlignType.MIDDLE_RIGHT, precision);
    }

    public NumberColumn(String name, int width, int precision) {
        this(name, width, AlignType.MIDDLE_RIGHT, precision);
    }

    public NumberColumn(String name, int width, NumberFormat formatter) {
        this(name, null, width, AlignType.MIDDLE_RIGHT, formatter);
    }

    public NumberColumn(String name, int width, AlignType align, int precision) {
        this(name, null, width, align, precision);
    }
    
    public NumberColumn(String name, String title, int width, AlignType align, int precision) {
        super(name, title, width, align);
        this.precision = precision;
    }

    public NumberColumn(String name, String title, int width, AlignType align, NumberFormat formatter) {
        super(name, title, width, align);
        this.formatter = formatter;
    }

	public int getPrecision() {
        return precision;
    }

    public NumberColumn setPrecision(int precision) {
        this.precision = precision;
        
        return this;
    }

    public boolean isGrouping() {
        return grouping;
    }

    public NumberColumn setGrouping(boolean grouping) {
        this.grouping = grouping;
        
        return this;
    }

    public boolean isBracketNegitive() {
        return bracketNegitive;
    }

    public NumberColumn setBracketNegitive(boolean bracketNegitive) {
        this.bracketNegitive = bracketNegitive;
        
        return this;
    }

    @Override
    public int getMaxRowHeight(CellDetails cellDetails) {
        return (int) Math.ceil((float) format(cellDetails.getCellValue()).length()/getWidth());
    }
    
    @Override
    public String format(CellDetails cellDetails) {
        return format(cellDetails.getCellValue());
    }
    
    public String format(Object value) {
        
        if (formatter == null) {
            String formatString = "";
	        if (isGrouping()) {
	            formatString = "#,###,###";
	        } else {
	            formatString = "0";
	        }
	        
	        if (isBracketNegitive()) {
	            formatString = formatString + ";(#)";
	        }
	        
	        if (precision > 0) {
	            formatter = new DecimalFormat(formatString +"." + Util.createString("0", precision));        
	        } else {
	            formatter = new DecimalFormat(formatString);
	        }
        }
        
        String formattedString;
        
        try {
            formattedString = formatter.format(value);
        } catch (Exception e) {
            throw new RuntimeException("Exception while formatting the value " + value + " of type " 
                + value.getClass().getName() + " as number for column " + this, e);
        }
        
        return formattedString;
    }
}
