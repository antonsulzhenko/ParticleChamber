package com.antonsulzhenko.particlechamber.model;

/**
 * @author Anton Sulzhenko
 */
public class Particle {
    private final Direction direction;
    private int position;

    public Particle(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move(int speed) {
        switch (direction) {
            case LEFT -> this.position -= speed;
            case RIGHT -> this.position += speed;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
