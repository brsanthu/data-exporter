package com.brsanthu.dataexporter.output.html;

import com.brsanthu.dataexporter.ExportOptions;

public class HtmlExportOptions extends ExportOptions {
    
    private boolean prettyPrint = false;
    private boolean alignCells = true;
    
    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    public HtmlExportOptions setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        return this;
    }

	public boolean isAlignCells() {
		return alignCells;
	}

	public void setAlignCells(boolean alignCells) {
		this.alignCells = alignCells;
	}
    
}
