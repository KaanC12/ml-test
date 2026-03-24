package com.kagan.ml.game;

public enum Marker {
    AI_MARKER("O"),
    PLAYER_MARKER("X");

    private final String marker;

    Marker(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return this.marker;
    }

}
