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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date column, which formats the given date as per given formating string. Format string is
 * same as documented in {@link SimpleDateFormat}
 * 
 * @author Santhosh Kumar
 */
public class DateColumn extends Column {
    
    private String dateFormat = null;
    private SimpleDateFormat df = null;
    
    public DateColumn(String name, int width, String dateFormat) {
        this(name, null, width, AlignType.MIDDLE_LEFT, dateFormat);
    }

    public DateColumn(String name, String title, int width, String dateFormat) {
        this(name, title, width, AlignType.MIDDLE_LEFT, dateFormat);
    }

    public DateColumn(String name, String title, int width, AlignType align, String dateFormat) {
        super(name, title, width, align);
        this.dateFormat = dateFormat;
        
        df = new SimpleDateFormat(dateFormat);
    }
    
    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    @Override
    public int getMaxRowHeight(CellDetails cellDetails) {
        Object cellValue = cellDetails.getCellValue();
        
        if (cellValue instanceof Date) {
            return (int) Math.ceil((float) df.format(cellValue).length()/getWidth());   
        }
        
        throw new IllegalArgumentException("Expected Date instance but it is " 
            + cellValue.getClass().getName() + " instance with value " + cellValue);
    }

    @Override
    public String format(CellDetails cellDetails) {
        return df.format((Date) cellDetails.getCellValue());
    }
}
