package org.application.exceptions;

public class InsuranceNotFoundException extends RuntimeException {
    public InsuranceNotFoundException(String message) {
        super(message);
    }
}
