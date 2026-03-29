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
    private final static String HUMAN_WINNER_MESSAGE = "Human won the game.";
    private final static String AI_WINNER_MESSAGE = "Ai won the game.";
    private final static int HUMAN_COORD_BASE = 1;
    private final static int Y_INDEX = 0;
    private final static int X_INDEX = 1;


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

                int yCoord = coords[Y_INDEX];
                int xCoord = coords[X_INDEX];

                game.setHumanMove(yCoord, xCoord);
                game.togglePlayerTurn();

            } else {
                System.out.println("AI's turn please enter your move.");
                int[] coords = game.findBestMove();

                int yCoord = coords[Y_INDEX] + HUMAN_COORD_BASE;
                int xCoord = coords[X_INDEX] + HUMAN_COORD_BASE;

                game.setAIMove(yCoord, xCoord);
                game.togglePlayerTurn();
            }

            System.out.println(grid.toString());

        }

        String winner = game.getPlayerTurn() ? AI_WINNER_MESSAGE : HUMAN_WINNER_MESSAGE;

        System.out.println(winner);
    }
}