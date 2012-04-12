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
