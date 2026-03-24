package com.kagan.ml.game;

import com.kagan.ml.board.Grid;
import com.kagan.ml.board.type.Type;

public class Game {
    private final Grid grid;
    private int playerScore;
    private int aiScore;
    private boolean playerTurn; // true: Human && false: AI
    private int verticleParser; 

    public Game(Grid grid) {
        this.grid = grid;
        this.playerScore = 0;
        this.aiScore = 0;
        this.playerTurn = true;
        int verticleParser = Type.THREE
    }

    private boolean isVerticalBlock() {
        String marker;
        if (playerTurn) {
            marker = Marker.PLAYER_MARKER.getMarker();
        } else {
            marker = Marker.AI_MARKER.getMarker();
        }

        boolean isVerticalBlock = false;

        for (int i = 1; i < grid.getHeight() - 6; i += 2)
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