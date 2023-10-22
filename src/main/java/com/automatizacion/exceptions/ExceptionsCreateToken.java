package com.automatizacion.exceptions;

public class ExceptionsCreateToken extends RuntimeException {

    public ExceptionsCreateToken() {
        super();
    }

    public ExceptionsCreateToken(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExceptionsCreateToken(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionsCreateToken(String message) {
        super(message);
    }

    public ExceptionsCreateToken(Throwable cause) {
        super(cause);
    }
}