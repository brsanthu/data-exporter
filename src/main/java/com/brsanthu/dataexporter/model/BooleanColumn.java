package com.brsanthu.dataexporter.model;

/**
 * Column which converts the boolean string into boolean strings as per configured format.
 * 
 * @author Santhosh Kumar
 */
public class BooleanColumn extends Column {
    
    private Format format = Format.YES_NO;
    
    public static enum Format {
        YES_NO,
        TRUE_FALSE,
        ONE_ZERO
    }
    
    /**
     * Constructor with default Yes/No formatting.
     * 
     * @param name
     * @param width
     */
    public BooleanColumn(String name, int width) {
        this(name, null, width, AlignType.MIDDLE_LEFT, Format.YES_NO);
    }
    public BooleanColumn(String name, String title, int width) {
        this(name, title, width, AlignType.MIDDLE_LEFT, Format.YES_NO);
    }
    
    public BooleanColumn(String name, int width, AlignType align) {
        this(name, null, width, align, Format.YES_NO);
    }
    public BooleanColumn(String name, String title, int width, AlignType align, Format format) {
        super(name, title, width, align);
        this.format = format;
    }
    
    private String getBooleanString(boolean booleanValue) {
        switch (format) {
            case ONE_ZERO:
                return booleanValue?"1":"0";
            case TRUE_FALSE:
                return booleanValue?"True":"False";
            case YES_NO:
                return booleanValue?"Yes":"No";
            default:
                return booleanValue?"Yes":"No";
        }
    }
    
    @Override
    public int getMaxRowHeight(CellDetails cellDetails) {
        return getMaxRowHeight(getBooleanString(new Boolean(cellDetails.getCellValue().toString())));
    }

    @Override
    public String format(CellDetails cellDetails) {
        return getBooleanString(new Boolean(cellDetails.getCellValue().toString()));
    }
}
