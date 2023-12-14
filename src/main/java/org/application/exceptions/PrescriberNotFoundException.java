package org.application.exceptions;

public class PrescriberNotFoundException extends RuntimeException {
    public PrescriberNotFoundException(String message) {
        super(message);
    }
}

