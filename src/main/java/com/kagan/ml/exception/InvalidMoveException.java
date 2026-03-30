package com.kagan.ml.exception;

/**
 * Thrown when a move is invalid in the game.
 */
public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String message) {
        super(message);
    }
    
}
