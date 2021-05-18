package com.antonsulzhenko.particlechamber.validation;

/**
 * @author Anton Sulzhenko
 */
public class ParticleSpeedValidator implements SimpleIntValidator{
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 10;

    public void validate(int speed) {
        if (speed < MIN_SPEED || speed > MAX_SPEED) {
            throw new IllegalArgumentException("Speed should be in [1; 10] range");
        }
    }
}
