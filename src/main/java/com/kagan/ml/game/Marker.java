package com.kagan.ml.game;

/**
 * Represents the markers used by players in the game.
 * <p> There are two types of player in the game:
 * <ul>
 *  <li>Human is represented by {@code X}</li>
 *  <li>AI is represented by {@code O}</li>
 * </ul>
 * 
 * @author Kaan Turgut
 */
public enum Marker {
    /**
     * Marker for AI.
     */
    AI_MARKER("O"),

    /**
     * Marker for human.
     */
    PLAYER_MARKER("X");

    private final String marker;

    Marker(String marker) {
        this.marker = marker;
    }

    /**
     * Human plays with X and AI plays with O.
     * 
     * @return type of marker
     */
    public String getMarker() {
        return this.marker;
    }

}
