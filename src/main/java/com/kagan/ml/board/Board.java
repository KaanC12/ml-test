package com.kagan.ml.board;

public interface Board {
    /**
     * Set spaces on the board.
     */
    void setSpaces();

    /**
     * Set "_" for horizontals.
     */
    void setHorizontals();

    /**
     * Set "|" for verticals.
     */
    void setVerticals();
}


