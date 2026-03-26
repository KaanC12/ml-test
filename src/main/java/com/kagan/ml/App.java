package com.kagan.ml;

import java.util.Scanner;

import com.kagan.ml.board.Director;
import com.kagan.ml.board.TTOBoard;
import com.kagan.ml.exception.InvalidTypeError;
import com.kagan.ml.game.Game;
import com.kagan.ml.util.TypeChecker;
import com.kagan.ml.board.Grid;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the board type:");
        String boardType = sc.nextLine();

        String correctedBoardType = TypeChecker.correctTypeInput(boardType);

        if (!TypeChecker.isTypeCorrect(correctedBoardType)) {
            throw new InvalidTypeError("Invalid input please enter a valid board type.");
        }

        Director director = new Director();
        TTOBoard ttoBoard = new TTOBoard(correctedBoardType);
        ttoBoard.setHorizontals();
        ttoBoard.setVerticals();
        ttoBoard.setSpaces();
        
        Grid grid = ttoBoard.build();

        Game game = new Game(grid);

        
    }
}