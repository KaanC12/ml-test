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
