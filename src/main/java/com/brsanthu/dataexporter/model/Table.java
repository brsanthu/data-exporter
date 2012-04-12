package com.brsanthu.dataexporter.model;

import java.util.ArrayList;
import java.util.List;


public class Table {
    
    private DataExporterCallback callback = null;
    private List<Column> columns = new ArrayList<Column>();    
    
    public DataExporterCallback getCallback() {
        return callback;
    }
    public void setCallback(DataExporterCallback callback) {
        this.callback = callback;
    }
    public List<Column> getColumns() {
        return columns;
    }
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
    public void addColumn(Column column) {
        columns.add(column);
    }
}
