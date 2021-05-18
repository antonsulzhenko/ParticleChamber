package com.antonsulzhenko.particlechamber.model;

/**
 * @author Anton Sulzhenko
 */
public enum Location {
    OCCUPIED('X'),
    UNOCCUPIED('.');

    private final char location;

    Location(char location) {
        this.location = location;
    }

    public char getLocation() {
        return this.location;
    }
}
