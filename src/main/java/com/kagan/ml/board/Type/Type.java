package com.kagan.ml.board.type;

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
