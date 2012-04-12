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
