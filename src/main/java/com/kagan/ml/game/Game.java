package com.kagan.ml.game;

import com.kagan.ml.board.Grid;
import com.kagan.ml.board.type.Type;

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

    private boolean isGameFinished(String marker) {
        return grid.isDiagonalBlock(marker) || grid.isHorizontalBlock(marker) || grid.isDiagonalBlock(marker);
    }

    public void minimaxAlgo() {

    }
}