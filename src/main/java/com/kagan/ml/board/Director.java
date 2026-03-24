package com.kagan.ml.board;

public class Director {
    public void makeTTOBoard(Board ttoBoard) {
        ttoBoard.setHorizontals();
        ttoBoard.setVerticals();
        ttoBoard.setSpaces(); 
    }
    
}
