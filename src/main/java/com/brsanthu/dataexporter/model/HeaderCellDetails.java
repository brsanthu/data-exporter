package com.brsanthu.dataexporter.model;

public class HeaderCellDetails {
    
    private Table table = null;
    private int columnIndex = -1;
    
    public HeaderCellDetails() {
        //Do nothing
    }
    
    public HeaderCellDetails(Table table, int columnIndex) {
        super();
        this.columnIndex = columnIndex;
        this.table = table;
    }
    
    
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }
    
    public Column getColumn() {
        return getTable().getColumns().get(columnIndex);
    }

}
