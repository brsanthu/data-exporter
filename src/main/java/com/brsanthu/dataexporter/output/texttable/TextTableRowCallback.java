package com.brsanthu.dataexporter.output.texttable;

import com.brsanthu.dataexporter.model.DataExporterCallback;
import com.brsanthu.dataexporter.model.RowDetails;

public interface TextTableRowCallback extends DataExporterCallback {
    public abstract int getMinRowHeight(RowDetails rowDetails, int defaultMaxRowHeight);
    public abstract boolean isDisplayRowBorder(RowDetails rowDetails, boolean defaultDisplayRowBorder);
    public abstract String getLeftDivider(RowDetails rowDetails, String defaultDivider);
    public abstract String getRightDivider(RowDetails rowDetails, String defaultDivider);
}
