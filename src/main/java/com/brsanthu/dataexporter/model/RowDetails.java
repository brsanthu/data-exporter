package com.brsanthu.dataexporter.model;

/**
 * Bean contains the details of row being written like row index, actual row
 * and height of the row.
 * 
 * @author Santhosh Kumar
 */
public class RowDetails {

    private Table table = null;
    private int rowIndex = 0;
    private Row row = null;
    private int rowHeight = 1;
    
    public RowDetails() {
        //do nothing
    }
    
    public RowDetails(Table table, int rowIndex, Row row) {
        super();
        this.table = table;
        this.rowIndex = rowIndex;
        this.row = row;
    }
    
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getRowHeight() {
        return rowHeight;
    }
    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }
    public int getRowIndex() {
        return rowIndex;
    }
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    public Row getRow() {
        return row;
    }
    public void setRow(Row row) {
        this.row = row;
    }
}
