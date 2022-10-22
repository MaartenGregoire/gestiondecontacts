package com.gestiondecontacts.exception;

public class EntityNotFoundException extends RuntimeException {
    
    private static final String PREFIX = String.format("[%s]", EntityNotFoundException.class.getSimpleName());
    
    public static EntityNotFoundException from(String message) {
        return new EntityNotFoundException(message);
    }
    
    private EntityNotFoundException(String message) {
        super(String.format("%s %s", PREFIX, message));
    }
    
}
