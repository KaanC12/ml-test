package com.kagan.ml.game;

import com.kagan.ml.board.Grid;
import com.kagan.ml.exception.InvalidMoveException;

public class Game {
    private final static int AI_CODE_BASE = 1;
    private final static int MIN_COORD = 1;
    private final static int MAX_COORD = 1;
    private final static int Y_COORD = 0;
    private final static int X_COORD = 1;
    private final static String INVALID_MOVE_MESSAGE = "Move is invalid";

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
        String ai = Marker.AI_MARKER.getMarker();
        String human = Marker.PLAYER_MARKER.getMarker();

        return grid.isDiagonalBlock(ai) ||
                grid.isHorizontalBlock(ai) ||
                grid.isVerticalBlock(ai) ||

                grid.isDiagonalBlock(human) ||
                grid.isHorizontalBlock(human) ||
                grid.isVerticalBlock(human);
    }

    // Checks whether the cell is empty.
    private boolean isCellAvailable(int y, int x) {
        String[][] logic = grid.getMoveTable();
        return logic[y - AI_CODE_BASE][x - AI_CODE_BASE] == null;
    }

    // Checks whetehr the move is valid.
    private boolean isMoveEligible(int y, int x) {
        return y >= MIN_COORD && y <= MAX_COORD && x >= MIN_COORD && x <= MAX_COORD;
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
        grid.setMoveLogic(y - AI_CODE_BASE, x - AI_CODE_BASE, marker);
        grid.setCell(formatVisualization(y - AI_CODE_BASE), formatVisualization(x - AI_CODE_BASE), marker);
    }

    // Makes the coordinate approproate for visualization.
    private int formatVisualization(int coord) { return 2 * coord + 1; }

    /**
     * Makes the move on the board for AI
     * 
     * @param y axis coordinate of the board
     * @param x axis coordinate of the board
     */
    public void setAIMove(int y, int x) {
        if (!isMoveEligible(y, x)) {
            throw new InvalidMoveException(INVALID_MOVE_MESSAGE);
        }

        if (!isCellAvailable(y, x)) {
            throw new InvalidMoveException(INVALID_MOVE_MESSAGE);
        }

        String marker = Marker.AI_MARKER.getMarker();
        grid.setMoveLogic(y - AI_CODE_BASE, x - AI_CODE_BASE, marker);
        grid.setCell(formatVisualization(y - AI_CODE_BASE), formatVisualization(x - AI_CODE_BASE), marker);
    }

    /**
     * Evalueates the numerical value of the move.
     * 
     * @return evaluation of the move
     */
    public int evaluate() {
        String ai = Marker.AI_MARKER.getMarker();
        String human = Marker.PLAYER_MARKER.getMarker();

        int skor;

        if (
            grid.isDiagonalBlockLogic(ai) ||
            grid.isHorizontalBlockLogic(ai) ||
            grid.isVerticalBlockLogic(ai)
        ) {
            skor = 1;
        } else if (
            grid.isDiagonalBlockLogic(human) ||
            grid.isHorizontalBlockLogic(human) ||
            grid.isVerticalBlockLogic(human)
        ) {
            skor = -1;
        } else {
            skor = 0;
        }

        return skor;
    }
    
    
    private int minimax(boolean isHumanTurn) {
        int score = evaluate();

        if (score == 1 || score == -1) return score;

        if (grid.getAvailableMoves().isEmpty()) return 0;

        if (!isHumanTurn) {
            int best = Integer.MIN_VALUE;

            for (int[] move : grid.getAvailableMoves()) {
                int y = move[Y_COORD];
                int x = move[X_COORD];

                grid.setMoveLogic(y, x, Marker.AI_MARKER.getMarker());

                int value = minimax(true);

                grid.undo(y, x);

                best = Math.max(best, value);
            }

            return best;

        } else {
            int best = Integer.MAX_VALUE;

            for (int[] move : grid.getAvailableMoves()) {
                int y = move[Y_COORD];
                int x = move[X_COORD];

                grid.setMoveLogic(y, x, Marker.PLAYER_MARKER.getMarker());

                int value = minimax(false);

                grid.undo(y, x);

                best = Math.min(best, value);
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
            int y = move[Y_COORD];
            int x = move[X_COORD];

            grid.setMoveLogic(y, x, Marker.AI_MARKER.getMarker());

            int score = minimax(true); 

            grid.undo(y, x);

            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }

        return bestMove;
    }
}