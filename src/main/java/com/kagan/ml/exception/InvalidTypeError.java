package com.kagan.ml.exception;
/**
 * Thrown when given type is wrong. 
 * 
 * @author Kaan Turgut
 */
public class InvalidTypeError extends RuntimeException {
    public InvalidTypeError(String message) {
        super(message);
    }
    
}
