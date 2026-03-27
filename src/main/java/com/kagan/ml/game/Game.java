package com.kagan.ml.game;

import com.kagan.ml.board.Grid;
import com.kagan.ml.exception.InvalidMoveException;

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

    /**
     * Shows whose turn.
     * 
     * @return if {@code true} human plays, if {@code false} AI plays 
     */
    public boolean getPlayerTurn() { return playerTurn; }

    /**
     * Shifts the player's turn.
     * 
     */
    public void togglePlayerTurn() {playerTurn = !playerTurn; }

    /**
     * Checks whether the game is over.
     * 
     * @return {@code true} if game is over {@code false} game is not over yet.
     */ 
    public boolean isGameOver() {
        String marker;
        if (playerTurn) {
            marker = Marker.PLAYER_MARKER.getMarker();
        } else {
            marker = Marker.AI_MARKER.getMarker();
        }

        return grid.isDiagonalBlock(marker) ||
                grid.isHorizontalBlock(marker) ||
                grid.isVerticalBlock(marker);
    }

    // Checks whether the cell is empty.
    private boolean isCellAvailable(int y, int x) {
        String[][] logic = grid.getMoveTable();
        return logic[y][x] == null;
    }

    // Checks whetehr the move is valid.
    private boolean isMoveEligible(int y, int x) {
        return y >= 1 && y <= 3 && x >= 1 && x <= 3;
    }
    
    /**
     * Puts the human move on the board.
     * 
     * @param y is the value of y axis.
     * @param x is the value of x axis.
     */
    public void setHumanMove(int y, int x) {
        if (!isMoveEligible(y, x)) {
            throw new InvalidMoveException("Move is invalid");
        }

        if (!isCellAvailable(y, x)) {
            throw new InvalidMoveException("Move is invalid");
        }

        String marker = Marker.PLAYER_MARKER.getMarker();
        grid.setMoveLogic(y - 1, x - 1, marker);
        grid.setCell(y - 1, x - 1, marker);
    }

    /**
     * Evalueates the numerical value of the move.
     * 
     * @return evaluation of the move
     */
    public int evaluate() {
        String aiMarker = Marker.AI_MARKER.getMarker();
        String humanMarker = Marker.PLAYER_MARKER.getMarker();

        int skor;

        if (
            grid.isDiagonalBlock(aiMarker) ||
            grid.isHorizontalBlock(aiMarker) ||
            grid.isVerticalBlock(aiMarker)
        ) {
            skor = 1;
        } else if (
            grid.isDiagonalBlock(humanMarker) ||
            grid.isHorizontalBlock(humanMarker) ||
            grid.isVerticalBlock(humanMarker)
        ) {
            skor = -1;
        } else {
            skor = 0;
        }

        return skor;
    }
    
    /**
     * Minimax algorithm for the game.
     * 
     * @param turn if {@code true} human plays if {@code false} AI plays
     * @return move value
     */
    public int minimax(boolean turn) {
        if (isGameOver()) {
            return evaluate();
        }

        if (turn) {
            int best = Integer.MIN_VALUE;

            for (int[] move : grid.getAvailableMoves()) {
                int y = move[0];
                int x = move[1];

                grid.setCell(y, x, Marker.AI_MARKER.getMarker());

                int score = minimax(false);

                grid.undo(y, x);

                best = Math.max(best, score);
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;

            for (int[] move : grid.getAvailableMoves()) {
                int y = move[0];
                int x = move[1];

                grid.setCell(y, x, Marker.PLAYER_MARKER.getMarker());

                int score = minimax(true);

                grid.undo(y, x);

                best = Math.min(best, score);
            }

            return best;
        }
    }

    /**
     * Finds the best move. 
     * 
     * @return the coordinates of the move 
     */
    public int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int[] move : grid.getAvailableMoves()) {
            int y = move[0];
            int x = move[1];

            grid.setCell(y, x, Marker.AI_MARKER.getMarker());

            int score = minimax(playerTurn);

            grid.undo(y, x);

            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }

        return bestMove;
    }
}