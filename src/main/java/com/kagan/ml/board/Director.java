package com.kagan.ml.board;

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
