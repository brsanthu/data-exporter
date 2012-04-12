package com.brsanthu.dataexporter.output.text;

import com.brsanthu.dataexporter.ExportOptions;

public class TextExportOptions extends ExportOptions {
    private String delimiter = "\t";
    private boolean trimValues = false;
    
    public boolean isTrimValues() {
        return trimValues;
    }
    public TextExportOptions setTrimValues(boolean trimValues) {
        this.trimValues = trimValues;
        
        return this;
    }
    public String getDelimiter() {
        return delimiter;
    }
    public TextExportOptions setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }
    
}
