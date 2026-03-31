package com.kagan.ml.board;

/**
 * Represents what a board can do.
 * 
 * A board must perform three functions:
 * <ul>
 *  <li>Horizontal edges are represented by {@code _}</li>
 *  <li>Vertical edges are represented by {@code |}</li>
 *  <li>Cell spaces are represented by {@code " "}</li>
 * </ul>
 * 
 * @author Kaan Turgut
 */
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


