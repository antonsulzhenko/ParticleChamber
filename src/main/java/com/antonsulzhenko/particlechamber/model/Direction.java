package com.antonsulzhenko.particlechamber.model;

/**
 * @author Anton Sulzhenko
 */
public enum Direction {
    LEFT('L'),
    RIGHT('R'),
    EMPTY('.');

    private final char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return this.direction;
    }

    public static Direction of(char c) {
        for (Direction direction : values()) {
            if (direction.getDirection() == c) {
                return direction;
            }
        }
        throw new UnsupportedOperationException("Unknown Direction: " + c);
    }
}
