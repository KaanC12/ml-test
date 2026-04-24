package com.kagan.ml;

import com.kagan.ml.board.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private Grid grid;
    
    @BeforeEach
    void setUp(){
        grid = new Grid();
        grid.setHeight(7);
        grid.setWidth(7);
        
        String[][] visualGrid = {
            {" "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "}
        };

        String[][] moveTable = new String[3][3];

        grid.setGrid(visualGrid);
        grid.setMoveTable(moveTable);
    }

    @Nested
    class Cell {

        @Test
        void setCell_shouldUpdateVisualGrid() {
            grid.setCell(1, 1, "X");

            assertEquals("X", grid.getCell(1, 1));
        }
        
        @Test
        void isVerticalBlock_shouldReturnTrue() {
            grid.setCell(1, 1, "X");
            grid.setCell(1, 3, "X");
            grid.setCell(1, 5, "X");

            assertTrue(grid.isVerticalBlock("X"));
        }
    }
}