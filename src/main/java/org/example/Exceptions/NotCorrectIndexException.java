package org.example.Exceptions;

public class NotCorrectIndexException extends RuntimeException {
    public NotCorrectIndexException() {
    }

    public NotCorrectIndexException(String message) {
        super(message);
    }

    public NotCorrectIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectIndexException(Throwable cause) {
        super(cause);
    }

    public NotCorrectIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
