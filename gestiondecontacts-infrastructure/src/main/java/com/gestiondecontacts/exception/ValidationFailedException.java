package com.gestiondecontacts.exception;

public class ValidationFailedException extends RuntimeException {
    
    private static final String PREFIX = String.format("[%s]", ValidationFailedException.class.getSimpleName());
    
    public static ValidationFailedException from(String message) {
        return new ValidationFailedException(message);
    }
    
    private ValidationFailedException(String message) {
        super(String.format("%s %s", PREFIX, message));
    }
    
}
