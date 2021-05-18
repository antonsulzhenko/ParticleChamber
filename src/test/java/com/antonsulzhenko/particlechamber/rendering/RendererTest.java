package com.antonsulzhenko.particlechamber.rendering;

import com.antonsulzhenko.particlechamber.model.Direction;
import com.antonsulzhenko.particlechamber.model.Particle;
import com.antonsulzhenko.particlechamber.validation.ChamberSizeValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Anton Sulzhenko
 */
@ExtendWith(MockitoExtension.class)
class RendererTest {

    @Mock
    private ChamberSizeValidator validator;

    @Test
    void rendererConstructor_create_validatorInvokedOnce() {
        // Arrange
        int chamberSize = 3;

        //Act
        Renderer target = createTarget(3);

        //Assert
        verify(validator, times(1)).validate(chamberSize);
    }

    @Test
    void rendererConstructor_create_emptyChamberCreated() {
        // Arrange
        int chamberSize = 3;

        //Act
        Renderer target = createTarget(chamberSize);

        //Assert
        assertEquals("...", target.getEmptyChamber());
    }

    @Test
    void renderer_particlesList_outOfChamberParticlesSkipped() {
        // Arrange
        int chamberSize = 3;
        List<Particle> particles = List.of(
                new Particle(-1, Direction.LEFT),
                new Particle(0, Direction.LEFT),
                new Particle(2, Direction.LEFT),
                new Particle(3, Direction.LEFT));
        Renderer target = createTarget(chamberSize);

        //Act
        String actualResult = target.render(particles);

        //Assert
        assertEquals("X.X", actualResult);
    }

    private Renderer createTarget(int chamberSize) {
        return new Renderer(chamberSize, validator);
    }
}