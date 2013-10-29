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

import org.junit.Test;

import com.brsanthu.dataexporter.DataExporterTestBase;
import com.brsanthu.dataexporter.model.Row;

public class TreeExporterTest extends DataExporterTestBase {

    @Test
    public void testClassic() throws Exception {
        
        TreeExporter exporter = new TreeExporter(sw);

        Row level1node1 = new Row("Level 1 Node 1");
        Row level2node1 = new Row("Level 2 Node 1");
        Row level2node2 = new Row("Level 2 Node 2");
        Row level2node3 = new Row("Level 2 Node 3");
        Row level3node1 = new Row("Level 3 Node 1");
        Row level3node2 = new Row("Level 3 Node 2");
        Row level3node3 = new Row("Level 3 Node 3");
        Row level3node4 = new Row("Level 3 Node 4");
        Row level3node5 = new Row("Level 3 Node 5");
        Row level4node1 = new Row("Level 4 Node 1");
        Row level4node2 = new Row("Level 4 Node 2");
        Row level4node3 = new Row("Level 4 Node 3");
        Row level4node4 = new Row("Level 4 Node 4");
        Row level4node5 = new Row("Level 4 Node 5");
        Row level5node1 = new Row("Level 5 Node 1");
        Row level5node2 = new Row("Level 5 Node 2");
        Row level5node3 = new Row("Level 5 Node 3");
        Row level5node4 = new Row("Level 5 Node 4");
        Row level6node1 = new Row("Level 6 Node 1");
        Row level6node2 = new Row("Level 6 Node 2");
        Row level6node3 = new Row("Level 6 Node 3");
        Row level6node4 = new Row("Level 6 Node 4");
        level1node1.addChild(level2node1);
        level1node1.addChild(level2node2);
        level1node1.addChild(level2node3);
        level2node3.addChild(level3node1);
        level2node3.addChild(level3node2);
        level2node3.addChild(level3node3);
        level2node3.addChild(level3node4);
        level2node3.addChild(level3node5);
        level3node1.addChild(level5node1);
        level5node1.addChild(level6node1);
        level2node2.addChild(level4node1);
        level2node2.addChild(level4node2);
        level2node2.addChild(level4node3);
        level2node2.addChild(level4node4);
        level2node2.addChild(level4node5);
        
        exporter.getTreeExporterOptions().setStyle(TreeExportStyle.CLASSIC);
        exporter.addRows(level1node1);
        exporter.finishExporting();

        System.out.println(sw.toString());
        //compareText("testHeaderAlignment.txt", sw.toString());
    }
}
