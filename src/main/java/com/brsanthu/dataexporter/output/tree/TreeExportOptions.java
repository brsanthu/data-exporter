package com.brsanthu.dataexporter.output.tree;

import com.brsanthu.dataexporter.ExportOptions;

public class TreeExportOptions extends ExportOptions {
    private TreeExportStyle style = TreeExportStyle.CLASSIC;
    
	public TreeExportStyle getStyle() {
		return style;
	}

	public void setStyle(TreeExportStyle style) {
		this.style = style;
	}
    
}
