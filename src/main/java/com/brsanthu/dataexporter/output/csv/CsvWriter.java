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

import org.apache.commons.lang3.StringUtils;

import com.brsanthu.dataexporter.output.text.TextWriter;

public class CsvWriter extends TextWriter {

    public CsvWriter(CsvExportOptions options) {
        super(options, System.out);
    }

    public CsvWriter(CsvExportOptions options, OutputStream out) {
        super(options, out);
    }
    
    public CsvWriter(OutputStream out) {
        super(new CsvExportOptions(), out);
    }

    public CsvWriter(CsvExportOptions options, Writer out) {
        super(options, out);
    }

    public CsvWriter(Writer out) {
        super(new CsvExportOptions(), out);
    }

    @Override
    public void writeCell(int i, String cellValue) {
        
        //Writing csv file as per http://tools.ietf.org/html/rfc4180
        String delimiter = getCsvExportOptions().getDelimiter();
        if (i != 0) {
            print(delimiter);
        }
        
        //If there is a quote or delimiter character in the string, then replace with two quotes.
        if (getCsvExportOptions().isStrictQuoting() || cellValue.indexOf(getCsvExportOptions().getQuote()) >= 0 
                        || cellValue.indexOf(delimiter) >= 0
                        || cellValue.indexOf("\n") >= 0) {
            String quote = getCsvExportOptions().getQuote();
            cellValue = StringUtils.replace(cellValue, quote, quote+quote);
            cellValue = quote + cellValue + quote;
        }
        
        print(cellValue);
    }
    
    public CsvExportOptions getCsvExportOptions() {
        return (CsvExportOptions) getOptions();
    }

}
