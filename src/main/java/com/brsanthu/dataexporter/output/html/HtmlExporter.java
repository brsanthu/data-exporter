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
package com.brsanthu.dataexporter.output.html;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class HtmlExporter extends DataExporter {
    
    public HtmlExporter(OutputStream out) {
        this(new HtmlExportOptions(), out);
    }

    public HtmlExporter(HtmlExportOptions options, OutputStream out) {
        super(new HtmlWriter(options, out));
    }

    public HtmlExporter(Writer out) {
        this(new HtmlExportOptions(), out);
    }
    public HtmlExporter(HtmlExportOptions options, Writer out) {
        super(new HtmlWriter(options, out));
    }
    
    public HtmlExporter() {
        this(System.out);
    }
    public HtmlExporter(HtmlExportOptions options) {
        this(options, System.out);
    }
    
    public HtmlExportOptions getHtmlExportOptions() {
        return (HtmlExportOptions) getOptions();
    }
}
