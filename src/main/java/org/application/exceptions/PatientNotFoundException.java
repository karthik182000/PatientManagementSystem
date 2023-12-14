package org.application.exceptions;



public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
