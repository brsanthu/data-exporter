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
package com.brsanthu.dataexporter.output.text;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class TextExporter extends DataExporter {

    public TextExporter(OutputStream out) {
        this(new TextExportOptions(), out);
    }

    public TextExporter(TextExportOptions options, OutputStream out) {
        super(new TextWriter(options, out));
    }

    public TextExporter(Writer out) {
        this(new TextExportOptions(), out);
    }
    
    public TextExporter(TextExportOptions textExportOptions, Writer out) {
        super(new TextWriter(textExportOptions, out));
    }
    
    public TextExporter() {
        this(System.out);
    }
    
    public TextExporter(TextExportOptions options) {
        this(options, System.out);
    }

    public TextExportOptions getTextExportOptions() {
        return (TextExportOptions) getDataWriter().getOptions();
    }
}
