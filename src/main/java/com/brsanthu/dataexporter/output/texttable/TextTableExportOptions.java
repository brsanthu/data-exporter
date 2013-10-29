/*
 * #%L
 * data-exporter
 * %%
 * Copyright (C) 2012 - 2013 http://www.brsanthu.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.brsanthu.dataexporter.output.texttable;

import com.brsanthu.dataexporter.ExportOptions;
import com.brsanthu.dataexporter.model.AlignType;
import com.brsanthu.dataexporter.util.Util;

/**
 * List of options to customize the displayed text table. See the setters for more information
 * about each option. All the setters returns the same instance back to facilitate the 
 * method chaining.
 * 
 * @author Santhosh Kumar
 */
public class TextTableExportOptions extends ExportOptions {

    private AlignType headerAlignment = AlignType.MIDDLE_CENTER;
    private int repeatHeadersAfterRows = 0;
    private int minRowHeight = 0;
    private TextTableExportStyle style = TextTableExportStyle.CLASSIC;
    
    public AlignType getHeaderAlignment() {
        return headerAlignment;
    }
    
    /**
     * Sets the text alignment for header cells. Default alignment is {@link AlignType#MIDDLE_CENTER}
     * 
     * @param headerAlignment the header alignment to use. Cannot be <code>null</code>.
     */
    public TextTableExportOptions setHeaderAlignment(AlignType headerAlignment) {
        Util.checkForNotNull(headerAlignment, "headerAlignment");
        
        this.headerAlignment = headerAlignment;
        return this;
    }

    public TextTableExportStyle getStyle() {
        return style;
    }
    
    /**
     * Sets the style to be used while exporting the text table.
     * 
     * @param style the text table style. Cannot be <code>null</code>.
     */
    public TextTableExportOptions setStyle(TextTableExportStyle style) {
        Util.checkForNotNull(style, "style");
        
        this.style = style;
        return this;
    }

    public int getRepeatHeadersAfterRows() {
        return repeatHeadersAfterRows;
    }
    
    /**
     * Indicates to repeat the headers after <code>repeatHeadersAfterRows</code> data rows.
     * 
     * Value must be greater than zero. If value is less than or equal to zero, it is considered
     * as no-repeat.
     * 
     * @param repeatHeadersAfterRows
     */
    public TextTableExportOptions setRepeatHeadersAfterRows(int repeatHeadersAfterRows) {
        this.repeatHeadersAfterRows = repeatHeadersAfterRows;
        return this;
    }

    public int getMinRowHeight() {
        return minRowHeight;
    }

    /**
     * Minimum row height to be used while formatting the data rows. This height is not applicable
     * for header row.
     * 
     * If the value is &lt;=0, this option is ignored.
     * 
     * @param minRowHeight
     */
    public TextTableExportOptions setMinRowHeight(int minRowHeight) {
        this.minRowHeight = minRowHeight;
        return this;
    }
}
