package com.brsanthu.dataexporter.model;

public class CellDetails extends RowDetails {
    
    private int columnIndex = -1;
    private Object cellValue = null;
    private AlignType cellAlign = null;
    private Column column = null;
    
    public CellDetails() {
        //do nothing
    }
    
    public CellDetails (RowDetails rowDetails, int columnIndex) {
        setTable(rowDetails.getTable());
        setRow(rowDetails.getRow());
        setRowHeight(rowDetails.getRowHeight());
        setRowIndex(rowDetails.getRowIndex());
        this.columnIndex = columnIndex;
    }
    
    public AlignType getCellAlign() {
        return cellAlign;
    }

    public void setCellAlign(AlignType cellAlign) {
        this.cellAlign = cellAlign;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }
    public Object getCellValue() {
        return cellValue;
    }
    public void setCellValue(Object defaultCellValue) {
        this.cellValue = defaultCellValue;
    }
    public Column getColumn() {
        if (column == null) {
            return getTable().getColumns().get(columnIndex);
        }
        
        return column;
    }
    
    public void setColumn(Column column) {
        this.column = column;
    }
}
