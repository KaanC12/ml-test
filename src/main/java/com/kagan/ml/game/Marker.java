package com.kagan.ml.game;

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
