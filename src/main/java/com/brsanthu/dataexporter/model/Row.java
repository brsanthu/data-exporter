package com.brsanthu.dataexporter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data row being exported.
 * 
 * @author Santhosh Kumar
 */
public class Row {
    
    private List<Object> cells = new ArrayList<Object>();
    
    public Row() {
        //Default Constructor
    }
    
    public Row(Object... rowValues) {
        add(rowValues);
    }
    
    public Row(List<? extends Object> rowValues) {
        if (rowValues == null) {
            throw new IllegalArgumentException("Parameter rowValues cannot be null");
        }

        for (Object object : rowValues) {
            add(object);
        }
    }
    
    public Row add(Object... rowValues) {
        if (rowValues == null) {
            throw new IllegalArgumentException("Parameter rowValues cannot be null");
        }

        for (Object value : rowValues) {
            cells.add(value);
        }
        
        return this;
    }

    public Object getCellValue(CellDetails cellDetails) {
        return cells.get(cellDetails.getColumnIndex());
    }

    public Object getCellValue(int index) {
        return cells.get(index);
    }

    public void setCellValue(int index, Object value) {
        cells.set(index, value);
    }
    
    public void addCellValue(Object value) {
        cells.add(value);
    }
    
    public void clearCellValues() {
        cells = new ArrayList<Object>();
    }
    
    public void setCellValues(List<Object> cells) {
        this.cells = cells;
    }
    
    public List<Object> getCellValues() {
        return cells;
    }
}
