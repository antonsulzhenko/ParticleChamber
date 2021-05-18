package com.antonsulzhenko.particlechamber.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Anton Sulzhenko
 */
class ParticleTest {

    @Test
    void move_rightDirection_positionIncrease() {
        // Arrange
        Particle target = createTarget(0, Direction.RIGHT);

        // Act
        target.move(1);

        //Assert
        int newPosition = target.getPosition();
        assertEquals(1, newPosition);
    }

    @Test
    void move_leftDirection_positionDecrease() {
        // Arrange
        Particle target = createTarget(0, Direction.LEFT);

        // Act
        target.move(1);

        //Assert
        int newPosition = target.getPosition();
        assertEquals(-1, newPosition);
    }

    @Test
    void move_emptyDirection_positionIsTheSame() {
        // Arrange
        Particle target = createTarget(0, Direction.EMPTY);

        // Act
        target.move(1);

        //Assert
        int newPosition = target.getPosition();
        assertEquals(0, newPosition);
    }

    private Particle createTarget(int position, Direction direction) {
        return new Particle(position, direction);
    }
}