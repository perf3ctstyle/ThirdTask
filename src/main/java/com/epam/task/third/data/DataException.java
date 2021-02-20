package com.epam.task.third.data;

public class DataException extends Exception {

    private final String filename;

    public DataException(final String message, final Throwable cause, final String filename) {
        super(message, cause);
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }
}
