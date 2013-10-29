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
package com.brsanthu.dataexporter.output.wiki;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class WikiExporter extends DataExporter {

    public WikiExporter(OutputStream out) {
        this(new WikiExportOptions(), out);
    }

    public WikiExporter(WikiExportOptions options, OutputStream out) {
        super(new WikiWriter(options, out));
    }

    public WikiExporter(Writer out) {
        this(new WikiExportOptions(), out);
    }
    
    public WikiExporter(WikiExportOptions textExportOptions, Writer out) {
        super(new WikiWriter(textExportOptions, out));
    }
    
    public WikiExporter() {
        this(System.out);
    }
    
    public WikiExporter(WikiExportOptions options) {
        this(options, System.out);
    }

    public WikiExportOptions getTextExportOptions() {
        return (WikiExportOptions) getDataWriter().getOptions();
    }
}
