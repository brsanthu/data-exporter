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
package com.brsanthu.dataexporter.output.xml;

import java.io.OutputStream;
import java.io.Writer;

import com.brsanthu.dataexporter.DataExporter;

/**
 * Data exporter which exports to XML format. Sample format is as follows.
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
 * &lt;table&gt;
 *         &lt;row&gt;
 *                 &lt;column name="Line No"&gt;1&lt;/column&gt;
 *                 &lt;column name="Date Purchased"&gt;2011/04/07 08:27:07 AM&lt;/column&gt;
 *                 &lt;column name="Item No"&gt;1&lt;/column&gt;
 *                 &lt;column name="Item Name"&gt;Laptop&lt;/column&gt;
 *                 &lt;column name="Shipped?"&gt;No&lt;/column&gt;
 *                 &lt;column name="Quantity"&gt;1&lt;/column&gt;
 *                 &lt;column name="Unit Price"&gt;$799.78&lt;/column&gt;
 *                 &lt;column name="Price"&gt;$799.78&lt;/column&gt;
 *         &lt;/row&gt;
 *         &lt;row&gt;
 *                 &lt;column name="Line No"&gt;2&lt;/column&gt;
 *                 &lt;column name="Date Purchased"&gt;2011/04/04 04:39:43 PM&lt;/column&gt;
 *                 &lt;column name="Item No"&gt;2&lt;/column&gt;
 *                 &lt;column name="Item Name"&gt;Mouse&lt;/column&gt;
 *                 &lt;column name="Shipped?"&gt;Yes&lt;/column&gt;
 *                 &lt;column name="Quantity"&gt;2&lt;/column&gt;
 *                 &lt;column name="Unit Price"&gt;$49.30&lt;/column&gt;
 *                 &lt;column name="Price"&gt;$98.60&lt;/column&gt;
 *         &lt;/row&gt;
 *         &lt;row&gt;
 *                 &lt;column name="Line No"&gt;3&lt;/column&gt;
 *                 &lt;column name="Date Purchased"&gt;2011/04/04 04:05:41 PM&lt;/column&gt;
 *                 &lt;column name="Item No"&gt;3&lt;/column&gt;
 *                 &lt;column name="Item Name"&gt;Keyboard&lt;/column&gt;
 *                 &lt;column name="Shipped?"&gt;No&lt;/column&gt;
 *                 &lt;column name="Quantity"&gt;5&lt;/column&gt;
 *                 &lt;column name="Unit Price"&gt;$75.00&lt;/column&gt;
 *                 &lt;column name="Price"&gt;$375.00&lt;/column&gt;
 *         &lt;/row&gt;
 * &lt;/table&gt;
 * </pre>
 * 
 * @author Santhosh Kumar
 */
public class XmlExporter extends DataExporter {

    /**
     * Creates exporter with given output stream and default {@link XmlExportOptions}
     * 
     * @param out the output stream to write the output to. Cannot be <code>null</code>
     */
    public XmlExporter(OutputStream out) {
        this(new XmlExportOptions(), out);
    }
    
    /**
     * Creates exporter with given options and output stream.
     * 
     * @param options the Xml export options. Cannot be <code>null</code>
     * @param out the output stream to write the output to. Cannot be <code>null</code>
     */
    public XmlExporter(XmlExportOptions options, OutputStream out) {
        super(new XmlWriter(options, out));
    }
    
    /**
     * Creates exporter with default {@link XmlExportOptions} and given writer.
     * 
     * @param out the writer to write the output to. Cannot be <code>null</code>
     */
    public XmlExporter(Writer out) {
        this(new XmlExportOptions(), out);
    }

    /**
     * Creates exporter with given options and given writer.
     * 
     * @param options the xml export options. Cannot be <code>null</code>
     * @param out the writer to write the output to. Cannot be <code>null</code>
     */
    public XmlExporter(XmlExportOptions options, Writer out) {
        super(new XmlWriter(options, out));
    }
    
    /**
     * Creates exporter with default {@link XmlExportOptions} and <code>System.out</code> output stream.
     */
    public XmlExporter() {
        this(System.out);
    }
    
    /**
     * Creates exporter with given options and <code>System.out</code> output stream.
     * 
     * @param options the options to use for exporting. Cannot be <code>null</code>.
     */
    public XmlExporter(XmlExportOptions options) {
        this(options, System.out);
    }
    
    /**
     * Returns the currently active xml export options.
     * 
     * @return the xml export options.
     */
    public XmlExportOptions getXmlExportOptions() {
        return (XmlExportOptions) getOptions();
    }
}
