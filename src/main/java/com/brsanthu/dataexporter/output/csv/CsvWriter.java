package com.brsanthu.dataexporter.output.csv;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;

import com.brsanthu.dataexporter.output.text.TextWriter;

public class CsvWriter extends TextWriter {

    public CsvWriter(CsvExportOptions options) {
        super(options, System.out);
    }

    public CsvWriter(CsvExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public CsvWriter(OutputStream out) {
        super(new CsvExportOptions(), out);
    }

    public CsvWriter(CsvExportOptions options, Writer out) {
        super(options, out);
    }

    public CsvWriter(Writer out) {
        super(new CsvExportOptions(), out);
    }

    @Override
    public void writeCell(int i, String cellValue) {
        
        //Writing csv file as per http://tools.ietf.org/html/rfc4180
        String delimiter = getCsvExportOptions().getDelimiter();
        if (i != 0) {
            print(delimiter);
        }
        
        //If there is a quote or delimiter character in the string, then replace with two quotes.
        if (getCsvExportOptions().isStrictQuoting() || cellValue.indexOf(getCsvExportOptions().getQuote()) >= 0 
                        || cellValue.indexOf(delimiter) >= 0
                        || cellValue.indexOf("\n") >= 0) {
            String quote = getCsvExportOptions().getQuote();
            cellValue = StringUtils.replace(cellValue, quote, quote+quote);
            cellValue = quote + cellValue + quote;
        }
        
        print(cellValue);
    }
    
    public CsvExportOptions getCsvExportOptions() {
        return (CsvExportOptions) getOptions();
    }

}
