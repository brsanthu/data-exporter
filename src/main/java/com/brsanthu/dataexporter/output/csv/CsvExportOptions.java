package com.brsanthu.dataexporter.output.csv;

import com.brsanthu.dataexporter.output.text.TextExportOptions;

public class CsvExportOptions extends TextExportOptions {
    private String quote = "\"";
    private boolean strictQuoting = false;
    
    public CsvExportOptions() {
        setDelimiter(",");
    }
    
    public String getQuote() {
        return quote;
    }
    public TextExportOptions setQuote(String quote) {
        this.quote = quote;
        return this;
    }
    public boolean isStrictQuoting() {
        return strictQuoting;
    }
    public TextExportOptions setStrictQuoting(boolean strictQuoting) {
        this.strictQuoting = strictQuoting;
        return this;
    }
}
