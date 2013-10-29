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
package com.brsanthu.dataexporter.output.csv;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

public class CsvExporter extends DataExporter {
    public CsvExporter(OutputStream out) {
        this(new CsvExportOptions(), out);
    }

    public CsvExporter(CsvExportOptions options, OutputStream out) {
        super(new CsvWriter(options, out));
    }

    public CsvExporter(Writer out) {
        this(new CsvExportOptions(), out);
    }
    public CsvExporter(CsvExportOptions csvExportOptions, Writer out) {
        super(new CsvWriter(csvExportOptions, out));
    }
    
    public CsvExporter() {
        this(System.out);
    }
    public CsvExporter(CsvExportOptions options) {
        this(options, System.out);
    }

    public CsvExportOptions getCsvExportOptions() {
        return (CsvExportOptions) getDataWriter().getOptions();
    }

}
