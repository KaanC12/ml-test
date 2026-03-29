package com.kagan.ml;

import java.util.Scanner;

import com.kagan.ml.board.Director;
import com.kagan.ml.board.TTOBoard;
import com.kagan.ml.exception.InvalidTypeError;
import com.kagan.ml.game.Game;
import com.kagan.ml.util.MoveParser;
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
        director.makeTTOBoard(ttoBoard);
        
        Grid grid = ttoBoard.build();

        Game game = new Game(grid);

        while (!game.isGameOver()) {
            boolean turn = game.getPlayerTurn();

            if (turn) {
                System.out.println("Human's turn please enter your move:");
                String move = sc.nextLine();
                int[] coords = MoveParser.parseMove(move);

                int yCoord = coords[0];
                int xCoord = coords[1];

                game.setHumanMove(yCoord, xCoord);
                game.togglePlayerTurn();

            } else {
                System.out.println("AI's turn please enter your move.");
                int[] coords = game.findBestMove();

                int yCoord = coords[0] + 1;
                int xCoord = coords[1] + 1;

                game.setAIMove(yCoord, xCoord);
                game.togglePlayerTurn();
            }

            System.out.println(grid.toString());

        }

        String winner = game.getPlayerTurn() ? "AI won the game" : "Human won the game";

        System.out.println(winner);
    }
}