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

import java.util.ArrayList;
import java.util.List;

/**
 * Data row being exported.
 * 
 * @author Santhosh Kumar
 */
public class Row {
    
    private List<Object> cells = new ArrayList<Object>();
    private List<Row> children = null;
    
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

	public List<Row> getChildren() {
		return children;
	}

	public void setChildren(List<Row> children) {
		this.children = children;
	}
	
	public void addChild(Row child) {
		if (children == null) {
			children = new ArrayList<Row>();
		}
		
		children.add(child);
	}
}
