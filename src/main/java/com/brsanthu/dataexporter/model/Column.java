package com.brsanthu.dataexporter.model;

import java.util.List;

import com.brsanthu.dataexporter.TextAligner;

/**
 * Base class for all other columns. This abstract class also provides some common functionality
 * which subclasses can make use of.
 * 
 * @author Santhosh Kumar
 */
public abstract class Column {
    public static TextAligner aligner = new TextAligner();
    
    private CellValueGenerator cellValueGenerator = null;
    private String title = null;
    private String name = null;
    private int width = 0;
    private AlignType align = null;
    private boolean generatesOwnData = false;

    public Column(String name) {
        this(name, name.length());
    }

    public Column(String name, int width) {
        this(name, null, width, AlignType.MIDDLE_LEFT);
    }

    public Column(String name, int width, AlignType align) {
        this(name, null, width, align);
    }

    public Column(String name, String title, int width, AlignType align) {
        super();
        
        this.title = title==null?name:title;
        this.name = name;
        this.width = width;
        this.align = align;
    }
    
    public CellValueGenerator getCellValueGenerator() {
        return cellValueGenerator;
    }

    public Column setCellValueGenerator(CellValueGenerator generator) {
        this.cellValueGenerator = generator;
        
        return this;
    }

    public boolean isGeneratesOwnData() {
        return generatesOwnData;
    }

    public Column setGeneratesOwnData(boolean generatesOwnData) {
        this.generatesOwnData = generatesOwnData;
        
        return this;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public AlignType getAlign() {
        return align;
    }

    public void setAlign(AlignType align) {
        this.align = align;
    }
    
    /**
     * Aligns the given <code>cellData</code> using the details given in <code>cellDetails</code>
     * and alignment override value returned by the call back (if there is one).
     * <p>
     * This method is usually called by the specific column implementation after they have formatted
     * the string.
     * 
     * @param cellDetails the object containing the details about this cell
     * @param cellData the string which should be aligned
     * 
     * @return the <code>ArrayList</code> containing the Strings split and aligned as per <code>cellDetails</code>
     */
    public List<String> align(CellDetails cellDetails, String cellData) {
        
        AlignType alignOverride = cellDetails.getCellAlign();
        
        if (alignOverride == null) {
            alignOverride = cellDetails.getColumn().getAlign();
        }
        
        return align(cellDetails.getColumn().getWidth(), cellDetails.getRowHeight(), alignOverride, cellData);
    }
    
    public static List<String> align(int width, int height, AlignType align, String value) {
        return aligner.align(width, height, align, value);
    }
    
    /**
     * Method calculates the approximate row height based on the given <code>data</code> length
     * and this column's width. It is only a approximation because once the data is split and aligned
     * some times it could have been rendered in less height than what is returned in this method.
     * 
     * @param cellData the formatted string which would get displayed in the cell.
     * 
     * @return the approximation height that is required to display this cellData in this column
     */
    public int getMaxRowHeight(String cellData) {
        return getMaxRowHeight(getWidth(), cellData);
    }
    
    public static int getMaxRowHeight(int width, String value) {
        if (width <= 0) {
            width = 1;
        }
        
        return (int) Math.ceil((float) value.length()/width);
    }
    
    /**
     * Implementation should calculate the maximum row height they would be needed to render
     * the <code>defaultCellValue</code> given in <code>cellDetails</code> parameter.
     * 
     * @param cellDetails the object containing the details about the cell
     * 
     * @return the positive integer specifying the minimum row height this cell needs to render
     *      the cell value.
     */
    public abstract int getMaxRowHeight(CellDetails cellDetails);
    
    /**
     * Implementation should format the cell value object as appropriate into a string, align
     * the string vertically/horizontally to fit with in the column width and row height. Allowed column 
     * width is specified via <code>cellDetails.getColumn().getWidth()</code>. Allowed row height
     * is provided via <code>cellDetails.getRowHeight()</code>
     * 
     * @param cellDetails
     * 
     * @return List of Strings to be rendered for this column. List should have exactly 
     *  <code>cellDetails.getRowHeight()</code> strings and each of size <code>cellDetails.getColumn().getWidth()</code>
     */
    public abstract String format(CellDetails cellDetails);
}
