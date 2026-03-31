package com.kagan.ml.board;

import com.kagan.ml.board.type.Type;
/**
 * Represents the tic tac toe board.
 * 
 * <p>Responsible for visualizing grid.
 * 
 * <ul>
 *  <li>{@code setVerticle()} sets horizontal edges of the board.</li>
 *  <li>{@code setHorizontals()} sets horizontal edges of the board.</li>
 *  <li>{@code setSpaces()} sets the empy spaces as " ".</li>
 * </ul>
 */
public class TTOBoard implements Board {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "_";
    private static final String EMPTY_CELL = " ";

    private final Grid grid;

    public TTOBoard(String type) {
        this.grid = new Grid();
        Type boardType = Type.valueOf(type);
        int height = visualizeData(boardType.getHeight());
        int width = visualizeData(boardType.getHeight());

        grid.setHeight(height);
        grid.setWidth(width);

        String[][] newGrid = new String[height][width];
        String[][] moveTable = new String[boardType.getHeight()][boardType.getWidth()];
        grid.setMoveTable(moveTable);
        grid.setGrid(newGrid);
    }

    // Makes the input suitable for visualization. 
    private int visualizeData(int input) {
        return 2 * input + 1;
    }

    /**
     * Builds vertical lines "|".
     */
    @Override
    public void setVerticals() {
        for (int i = 1; i < grid.getHeight(); i += 2) {
            for (int j = 0; j < grid.getWidth(); j += 2) {
                grid.setCell(i, j, VERTICAL);
            }
        }
    }

    /**
     * Builds horizontal lines "_".
     */
    @Override
    public void setHorizontals() {
        for (int i = 0; i < grid.getHeight(); i += 2) {
            for (int j = 1; j < grid.getWidth(); j += 2) {
                grid.setCell(i, j, HORIZONTAL);
            }
        }
    }

    /**
     * Builds spaces for player marker.
     */
    @Override
    public void setSpaces() {
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (grid.getCell(i, j) == null) {
                    grid.setCell(i, j, EMPTY_CELL);
                }
            }
        }
    }

    /**
     * Returns the grid.
     * 
     * @return grid as an object
     */
    public Grid build() {
        return grid;
    }

    
}