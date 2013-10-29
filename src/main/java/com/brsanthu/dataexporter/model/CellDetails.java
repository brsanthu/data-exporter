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

public class CellDetails extends RowDetails {
    
    private int columnIndex = -1;
    private Object cellValue = null;
    private AlignType cellAlign = null;
    private Column column = null;
    
    public CellDetails() {
        //do nothing
    }
    
    public CellDetails (RowDetails rowDetails, int columnIndex) {
        this.columnIndex = columnIndex;
        setTable(rowDetails.getTable());
        setRow(rowDetails.getRow());
        setRowHeight(rowDetails.getRowHeight());
        setRowIndex(rowDetails.getRowIndex());
    }
    
    public AlignType getCellAlign() {
    	if (cellAlign == null) {
    		cellAlign = getColumn().getAlign();
    	}
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
