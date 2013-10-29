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

import java.sql.Date;

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;

public class CsvExporterTest extends DataExporterTestBase {
    
    public CsvExporterTest() {
        exporter = new CsvExporter(sw);
    }
    
    @Test
    public void testBasic() throws Exception {
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap,top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
        
        System.out.println(sw.toString());
        compareText("testBasic.txt", sw.toString());
    }

    @Test
    public void testStictQuoting() throws Exception {
        ((CsvExportOptions) exporter.getOptions()).setStrictQuoting(true);
        addData();
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap\"top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.addRow(new Date(dateReference - 2397984), new Integer(1), "Lap,top", new Boolean(false), new Integer(1), new Double(799.78));
        exporter.finishExporting();
       
        System.out.println(sw.toString());
        compareText("testStictQuoting.txt", sw.toString());
    }
}
