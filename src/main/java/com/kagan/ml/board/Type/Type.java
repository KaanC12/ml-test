package com.kagan.ml.board.type;

public enum Type {
    THREE_BY_THREE(3, 3);

    private final int height;
    private final int width;

    Type(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
