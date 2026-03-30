package com.kagan.ml.util;

public final class MoveParser {
    private static final int Y_COORD = 0;
    private static final int X_COORD = 1;
    private static final String INPUT_SPLITER = ",";


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
        String[] moveParts = move.split(INPUT_SPLITER);
        int yCoord = Integer.valueOf(moveParts[Y_COORD]);
        int xCoord = Integer.valueOf(moveParts[X_COORD]);

        coords[Y_COORD] = yCoord;
        coords[X_COORD] = xCoord;

        return coords;
    }
}
