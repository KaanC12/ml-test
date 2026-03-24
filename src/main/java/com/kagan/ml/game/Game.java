package com.kagan.ml.game;

import com.kagan.ml.board.Grid;

public class Game {
    private final Grid grid;
    private int playerScore;
    private int aiScore;
    private boolean playerTurn;

    public Game(Grid grid) {
        this.grid = grid;
        this.playerScore = 0;
        this.aiScore = 0;
        this.playerTurn = false;
    }

    private boolean isBlock(int startY, int stopY, int changeY, int startX, int stopX, int changeX) {
        boolean isSet = false;
        for (int i = startY; i < stopY; i += changeY) {
            for (int j = startX; j < stopX; j += changeX) {
                grid
            }
        }
    }

    private boolean isGameFinished() {
        boolean isGameFinished = false;
        for (int i = 1; i < grid.getHeight() - 6; i += 2) {
            for (int j = 0; j < grid.getWidth() - 6; j += 2) {
                if (grid[])
            }
        } 
    }

    public void minimaxAlgo() {

    }


}