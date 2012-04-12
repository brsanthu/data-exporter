package com.brsanthu.dataexporter.model;

import java.util.Date;

/**
 * Column which generates the current date time.
 * 
 * @author Santhosh Kumar
 */
public class CurrentDateTimeColumn extends DateColumn {

    public CurrentDateTimeColumn(String name, int width, AlignType align, String dateFormat) {
        super(name, null, width, align, dateFormat);
        setUpColumn();
    }

    public CurrentDateTimeColumn(String name, int width, String dateFormat) {
        super(name, width, dateFormat);
        setUpColumn();
    }
    
    private void setUpColumn() {
        setGeneratesOwnData(true);
        setCellValueGenerator(new CellValueGenerator() {
            @Override
            public Object generateCellValue(CellDetails cellDetails) {
                return new Date();
            }
        });
    }
}
