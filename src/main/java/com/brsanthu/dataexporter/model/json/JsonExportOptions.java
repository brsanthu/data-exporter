package com.brsanthu.dataexporter.model.json;

import com.brsanthu.dataexporter.ExportOptions;

public class JsonExportOptions extends ExportOptions {
    private boolean prettyPrint = false;
    private boolean doubleEscape = false;
    
    public boolean isDoubleEscape() {
        return doubleEscape;
    }

    public JsonExportOptions setDoubleEscape(boolean doubleEscape) {
        this.doubleEscape = doubleEscape;
        
        return this;
    }

    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    /**
     * Indicates if json output should be formatted with indentation and new lines.
     */
    public JsonExportOptions setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        return this;
    }
}
