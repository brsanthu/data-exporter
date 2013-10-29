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
package com.brsanthu.dataexporter.output.tree;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

/**
 * Tree Exporter is not fully tested so things may change in subsequent versions.
 * 
 * @author kumarsa
 */
public class TreeExporter extends DataExporter {

    public TreeExporter(OutputStream out) {
        this(new TreeExportOptions(), out);
    }

    public TreeExporter(TreeExportOptions options, OutputStream out) {
        super(new TreeWriter(options, out));
    }

    public TreeExporter(Writer out) {
        this(new TreeExportOptions(), out);
    }
    public TreeExporter(TreeExportOptions options, Writer out) {
        super(new TreeWriter(options, out));
    }
    
    public TreeExporter() {
        this(System.out);
    }
    public TreeExporter(TreeExportOptions options) {
        this(options, System.out);
    }
    
    public TreeExportOptions getTreeExporterOptions() {
        return (TreeExportOptions) getOptions();
    }
}
