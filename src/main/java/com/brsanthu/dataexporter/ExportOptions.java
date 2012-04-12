package com.brsanthu.dataexporter;

import com.brsanthu.dataexporter.util.Util;

/**
 * Base options applicable for all exporters.
 * 
 * @author Santhosh Kumar
 */
public class ExportOptions {
    
    private LineSeparatorType lineSeparator = LineSeparatorType.NATIVE;
    private boolean printHeaders = true;
    private boolean escapeHtml = false;
    private String nullString = "";
    
    public String getNullString() {
        return nullString;
    }
    
    /**
     * The string to be used for exporting if any of the row cells values are <code>null</code>.
     * Default is empty string.
     * 
     * @param nullString the string to be used if any of the cells are null. Cannot be <code>null</code>.
     * @return the this instance of export options for method chaining.
     */
    public ExportOptions setNullString(String nullString) {
        Util.checkForNotNull(nullString, "nullString");
        
        this.nullString = nullString;
        
        return this;
    }

    public boolean isEscapeHtml() {
        return escapeHtml;
    }
    
    /**
     * If set, all html unsafe characters are escaped. This is most useful if you are going to
     * show the exported data in an html. Default is <code>false</code>
     * 
     * @param escapeHtml
     * @return the this instance of export options for method chaining.
     */
    public ExportOptions setEscapeHtml(boolean escapeHtml) {
        this.escapeHtml = escapeHtml;
        
        return this;
    }

    public boolean isPrintHeaders() {
        return printHeaders;
    }

    /**
     * Enables or disables displaying the headers
     * 
     * @param printHeaders boolean to enable/disable the headers.
     * @return the this instance of export options for method chaining.
     */
    public ExportOptions setPrintHeaders(boolean printHeaders) {
        this.printHeaders = printHeaders;
        return this;
    }

    public LineSeparatorType getLineSeparator() {
        return lineSeparator;
    }

    public void setLineSeparator(LineSeparatorType lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
    
    public String getLineSeparatorString() {
        switch(lineSeparator) {
            case UNIX:
                return "\n";
                
            case WINDOWS:
                return "\r\n";
                
            default:
                String separator = System.getProperty("line.separator");
                if (separator == null) {
                    separator = "\r\n";
                }
                return separator;
        }
    }
    
}
