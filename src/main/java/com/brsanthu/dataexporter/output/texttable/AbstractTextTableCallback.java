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

import com.brsanthu.dataexporter.model.AbstractDataExporterCallback;
import com.brsanthu.dataexporter.model.RowDetails;

public class AbstractTextTableCallback extends AbstractDataExporterCallback implements TextTableRowCallback {

    @Override
    public int getMinRowHeight(RowDetails rowDetails, int defaultMaxRowHeight) {
        return 0;
    }

    @Override
    public boolean isDisplayRowBorder(RowDetails rowDetails, boolean defaultDisplayRowBorder) {
        return false;
    }

    @Override
    public String getLeftDivider(RowDetails rowDetails, String defaultDivider) {
        return null;
    }

    @Override
    public String getRightDivider(RowDetails rowDetails, String defaultDivider) {
        return null;
    }
}
