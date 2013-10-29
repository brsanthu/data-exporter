/*
 * #%L
 * data-exporter
 * %%
 * Copyright (C) 2012 - 2013 http://www.brsanthu.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
