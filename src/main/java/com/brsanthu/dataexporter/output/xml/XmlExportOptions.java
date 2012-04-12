package com.brsanthu.dataexporter.output.xml;

import com.brsanthu.dataexporter.ExportOptions;

/**
 * Various options that can be set while exporting to xml.
 * 
 * @author Santhosh Kumar
 */
public class XmlExportOptions extends ExportOptions {
    
    private boolean prettyPrint = false;
    
    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    /**
     * Indicates if xml output should be formatted with indentation and new lines.
     */
    public XmlExportOptions setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        return this;
    }
}
