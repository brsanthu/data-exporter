package com.brsanthu.dataexporter;

/**
 * Exception thrown by {@link DataExporter}
 * 
 * @author Santhosh Kumar
 */
public class DataExportException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataExportException() {
        super();
    }

    public DataExportException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataExportException(String message) {
        super(message);
    }

    public DataExportException(Throwable cause) {
        super(cause);
    }

}
