package com.gestiondecontacts.util;

import com.gestiondecontacts.exception.ValidationFailedException;

public class Validator {
    public static void validate(Object o, String fieldName) {
        if (o == null) {
            throw ValidationFailedException.from(String.format("%s is mandatory.", fieldName));
        }
    }
    
}
