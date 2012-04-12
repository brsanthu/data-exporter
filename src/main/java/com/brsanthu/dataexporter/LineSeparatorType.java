package com.brsanthu.dataexporter;

public enum LineSeparatorType {
    
    NATIVE("Native"),
    WINDOWS ("Windows"),
    UNIX ("Unix");
    
    private String label = null;

    private LineSeparatorType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
