package com.kagan.ml.util;

public final class MoveParser {
    private MoveParser() { }

    /**
     * Converts string move intput into integer array
     * 
     * @param move is coordinates as string
     * @return an integer array where:
     *          [0] = y coordinate (row)
     *          [1] = x coordinate (column)
     */
    public static int[] parseMove(String move) {
        int[] coords = new int[2];
        String[] moveParts = move.split(",");
        int yCoord = Integer.valueOf(moveParts[0]);
        int xCoord = Integer.valueOf(moveParts[1]);

        coords[0] = yCoord;
        coords[1] = xCoord;

        return coords;
    }
}
