package com.kagan.ml.game;

import com.kagan.ml.board.Grid;

public class Game {
    private final Grid grid;
    private int playerScore;
    private int aiScore;
    private boolean playerTurn; // true: Human && false: AI

    public Game(Grid grid) {
        this.grid = grid;
        this.playerScore = 0;
        this.aiScore = 0;
        this.playerTurn = true;

    }

    // Checks whether the game is finished. 
    private boolean isGameFinished(String marker) {
        return grid.isDiagonalBlock(marker) || grid.isHorizontalBlock(marker) || grid.isDiagonalBlock(marker);
    }

    // Checks whether the move is valid.
    private boolean isCellAvailable(int y, int x) {
        return grid.getCell(y, x).equals(" ");
    }
    
    /**
     * Puts the human move on the board.
     * 
     * @param y is the value of y axis.
     * @param x is the value of x axis.
     */
    public void setHumanMove(int y, int x) {
        String marker = Marker.PLAYER_MARKER.getMarker();
        if (isGameFinished(marker)) {
            System.out.println("Game is already finished.");
            return;
        }

        if (!isCellAvailable(y, x)) {
            System.out.println("Move is not valid.");
        }

        grid.setMoveLogic(y, x, marker);
        grid.setCell(y, x, marker);
    }
}