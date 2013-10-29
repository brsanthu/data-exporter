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
 * Defines set of call back methods which DataExporter would call giving a hook for clients
 * to override some values or do other calculations.
 * 
 * @author Santhosh Kumar
 */
public interface DataExporterCallback {
    
    /**
     * Callback method which would be called just before a row is exported. Implementation can change the
     * values of the row.
     * 
     * @param rowDetails the details of the row being exported.
     */
    public void beforeRow(RowDetails rowDetails);
    
    /**
     * Callback method which would be called just after a row is exported. Changing the values of the row details 
     * 
     * @param rowDetails the details of the row being exported.
     */
    public void afterRow(RowDetails rowDetails);
    
    /**
     * Callback method would be called just before a cell is printed. Implementation can change
     * the cell value and/or the cell alignment in the cell details if it is required to be overwritten.
     * <p>
     * Note that column object referenced through cell details is the same column object used
     * for all other rows and hence modifying would impact all other rows as well.
     * 
     * @param cellDetails the details of a cell being exported.
     */
    public void beforeCell(CellDetails cellDetails);
    
    /**
     * Callback method which would be called just after a cell is printed. Changing the cell values won't
     * have any impact on the exporting.
     * 
     * @param cellDetails the details of a cell being exported.
     */
    public void afterCell(CellDetails cellDetails);
}
