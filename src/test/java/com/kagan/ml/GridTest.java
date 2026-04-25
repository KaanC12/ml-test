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

        @Test
        void isHorizontalBlock_shouldReturnTrue() {
            grid.setCell(1, 1, "X");
            grid.setCell(3, 1, "X");
            grid.setCell(5, 1, "X");

            assertTrue(grid.isHorizontalBlock("X"));
        }

        @Test
        void isDiagonalBlock_shouldReturnTrue() {
            grid.setCell(1, 1, "X");
            grid.setCell(3, 3, "X");
            grid.setCell(5, 5, "X");

            assertTrue(grid.isDiagonalBlock("X"));
        }
    }

    @Nested
    class Logic {

        @Test
        void isVerticalLogical_shouldReturnTrue() {
            grid.setMoveLogic(0, 0, "X");
            grid.setMoveLogic(1, 0, "X");
            grid.setMoveLogic(2, 0, "X");

            assertTrue(grid.isVerticalBlockLogic("X"));
        }

        @Test
        void isHorizontalLogical_shouldReturnTrue() {
            grid.setMoveLogic(0, 0, "X");
            grid.setMoveLogic(0, 1, "X");
            grid.setMoveLogic(0, 2, "X");

            assertTrue(grid.isHorizontalBlockLogic("X"));
        }

        @Test
        void isDiagonalLogical_shouldReturnTrue() {
            grid.setMoveLogic(0, 0, "X");
            grid.setMoveLogic(1, 1, "X");
            grid.setMoveLogic(2, 2, "X");

            assertTrue(grid.isDiagonalBlockLogic("X"));
        }
    }
}