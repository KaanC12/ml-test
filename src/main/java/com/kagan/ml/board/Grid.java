package com.kagan.ml.board;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private String[][] grid;
    private String[][] moveTable;
    private int height;
    private int width;

    /**
     * Changes the grid.
     * 
     * @param grid is the new grid
     */
    public void setGrid(String[][] grid) { this.grid = grid; }

    /**
     * Move table demonstrates the logic.
     * 
     * @param moveTable is a 3x3 string array
     */
    public void setMoveTable(String[][] moveTable) { this.moveTable= moveTable; }

    /**
     * Gives the move table.
     * 
     * @return move table
     */
    public String[][] getMoveTable() { return this.moveTable; }

    /**
     * Sets the logic.
     * 
     * @param height is y axis coordinate 
     * @param width is x axis coordinate
     * @param obj is marker
     */
    public void setMoveLogic(int height, int width, String obj) {
        moveTable[height][width] = obj;
    }
    
    /**
     * Gives the length of the y axis.
     * 
     * @return length of y axis
     */
    public int getHeight() { return this.height; }

    /**
     * Sets the new height to old one.
     * 
     * @param height is the input
     */
    public void setHeight(int height) { this.height = height; }
    
    /**
     * Gives the length of the x axis.
     * 
     * @return length of x axis
     */
    public int getWidth() { return width; }

    /**
     * Sets the new width to old one.
     * 
     * @param width is the input
     */
    public void setWidth(int width) { this.width = width; }
    
    /**
     * Gives the object on the cell.
     * 
     * @param height is the input for y axis
     * @param width is the input for x axis
     * @return player's marker
     */
    public String getCell(int height, int width) { return grid[height][width]; }

    /**
     * Marks the cell
     * 
     * @param height is the input for y axis
     * @param width is the input for x axis
     * @param obj is the marker of player
     */
    public void setCell(int height, int width, String obj) { grid[height][width] = obj; }

    /**
     * Checks whether ther is any vertical block
     * 
     * @param marker of player
     * @return {@code true} if there is a vertical block
     */
    public boolean isVerticalBlock(String marker) {
        boolean isVerticalBlock = false;

        for (int i = 1; i < width; i += 2) {
            if (
                grid[i][1].equals(marker) &&
                grid[i][3].equals(marker) &&
                grid[i][5].equals(marker)
            ) {
                isVerticalBlock = true;
            }
        }

        return isVerticalBlock;
    }

    /**
     * Checks whether there is any horizontal block.
     * 
     * @param marker of player
     * @return {@code true} if there is a horizontal block
     */
    public boolean isHorizontalBlock(String marker) {
        boolean isHorizontalBlock = false;

        for (int i = 1; i < height; i += 2) {
            if (
                grid[1][i].equals(marker) &&
                grid[3][i].equals(marker) &&
                grid[5][i].equals(marker)
            ) {
                isHorizontalBlock = true;
            }
        }

        return isHorizontalBlock;
    }

    /**
     * Checks whether there is a horizontal block.
     * 
     * @param marker of player
     * @return {@code true} if there is a diagonal block
     */
    public boolean isDiagonalBlock(String marker) {
        boolean isDiagonalBlock = false;

        if (
            grid[1][1].equals(marker) &&
            grid[3][3].equals(marker) &&
            grid[5][5].equals(marker)
        ) {
            isDiagonalBlock = true;
        }

        if (
            grid[1][5].equals(marker) &&
            grid[3][3].equals(marker) &&
            grid[5][1].equals(marker)
        ) {
            isDiagonalBlock = true;
        }
        return isDiagonalBlock;
    }

    /**
     * Returns a list of available moves. 
     * 
     * @return available move list
     */
    public List<int[]> getAvailableMoves() {
        List<int[]> availableMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (moveTable[i][j] == null) {
                    availableMoves.add(new int[]{i, j});
                }
            }
        }

        return availableMoves;
    }
    
    /**
     * Removes the last move. 
     * 
     * @param y coordinate of the board
     * @param x coordinate of the board
     */
    public void undo(int y, int x) {
        moveTable[y][x] = null;
        grid[2 * ( y + 1) - 1][2 * (x + 1) - 1] = " ";
    }

    /**
     * Converts 2D array into String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
