package com.kagan.ml.board;

/**
 * Represents the builder pattern.
 * <p> Director is responsible for building a game board {@link TTOBoard}.
 * 
 * @author Kaan Turgut
 */
public class Director {
    /**
     * Prepares a board for tic tac toe.
     * 
     * @param ttoBoard is a type of board
     */
    public void makeTTOBoard(Board ttoBoard) {
        ttoBoard.setHorizontals();
        ttoBoard.setVerticals();
        ttoBoard.setSpaces(); 
    }
    
}
