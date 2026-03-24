package com.kagan.ml.board;

import com.kagan.ml.board.type.Type;

public class TTOBoard implements Board {
    private final Grid grid;

    public TTOBoard(String type) {
        this.grid = new Grid();
        Type boardType = Type.valueOf(type);
        int height = 2 * boardType.getHeight() + 1; 
        int width = 2 * boardType.getWidth() + 1;

        grid.setHeight(height);
        grid.setWidth(width);

        String[][] newGrid = new String[height][width];
        grid.setGrid(newGrid);
    }

    @Override
    public void setVerticals() {
        for (int i = 1; i < grid.getHeight(); i += 2) {
            for (int j = 0; j < grid.getWidth(); j += 2) {
                grid.setCell(i, j, "|");
            }
        }
    }

    @Override
    public void setHorizontals() {
        for (int i = 0; i < grid.getHeight(); i += 2) {
            for (int j = 1; j < grid.getWidth(); j += 2) {
                grid.setCell(i, j, "_");
            }
        }
    }

    @Override
    public void setSpaces() {
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (grid.getCell(i, j) == null) {
                    grid.setCell(i, j, " ");
                }
            }
        }
    }

    public Grid build() {
        return grid;
    }

    
}