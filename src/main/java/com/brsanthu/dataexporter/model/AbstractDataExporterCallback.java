package com.brsanthu.dataexporter.model;

public class AbstractDataExporterCallback implements DataExporterCallback {

    @Override
    public void beforeRow(RowDetails rowDetails) {
        //no implementation
    }

    @Override
    public void afterRow(RowDetails rowDetails) {
        //no implementation
    }

    @Override
    public void beforeCell(CellDetails cellDetails) {
        //no implementation
    }

    @Override
    public void afterCell(CellDetails cellDetails) {
        //no implementation
    }
}
