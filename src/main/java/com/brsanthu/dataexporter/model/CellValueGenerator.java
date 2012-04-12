package com.brsanthu.dataexporter.model;

public interface CellValueGenerator {
    /**
     * Callback is called for a cell whose column is indicated as <code>generatesOwnData</code>.
     * 
     * @param cellDetails the details of the cell
     * 
     * @return the generated cell value
     */
    public Object generateCellValue(CellDetails cellDetails);
}
