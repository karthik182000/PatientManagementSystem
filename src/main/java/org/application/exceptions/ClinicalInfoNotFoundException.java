package org.application.exceptions;
public class ClinicalInfoNotFoundException extends RuntimeException {
    public ClinicalInfoNotFoundException(String message) {
        super(message);
    }
}
