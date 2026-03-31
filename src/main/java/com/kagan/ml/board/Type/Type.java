package com.kagan.ml.board.type;

/**
 * Represents the board types.
 * <p>Board types are:
 * <ul>
 *  <li>3x3 board is represented by {@code THREE_BY_THREE}</li>
 * </ul>
 * 
 * <p>Each board has two variables:
 * <ul>
 *  <li>y axis of the board is represented by {@code height}</li>
 *  <li>x axis of the board is represented by {@code width}</li>
 * </ul>
 */
public enum Type {
    /**
     * Bard size
     */
    THREE_BY_THREE(3, 3);

    private final int height;
    private final int width;

    Type(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Gives the y axis length.
     * 
     * @return length of y axis
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gives the x axis length.
     * 
     * @return length of x axis
     */
    public int getWidth() {
        return this.width;
    }
}
