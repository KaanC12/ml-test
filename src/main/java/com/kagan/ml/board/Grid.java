package com.kagan.ml.board;

public class Grid {
    private String[][] grid;
    private int height;
    private int width;

    public void setGrid(String[][] grid) { this.grid = grid; }
    
    // Height operations
    public int getHeight() { return this.height; }
    public void setHeight(int height) { this.height = height; }
    
    // Width operations
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    
    // Cell operations
    public String getCell(int height, int width) { return grid[height][width]; }
    public void setCell(int height, int width, String obj) { grid[height][width] = obj; }

    // Game Control
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
