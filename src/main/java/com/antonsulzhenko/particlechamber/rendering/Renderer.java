package com.antonsulzhenko.particlechamber.rendering;

import com.antonsulzhenko.particlechamber.model.Particle;
import com.antonsulzhenko.particlechamber.validation.ChamberSizeValidator;

import java.util.List;

import static com.antonsulzhenko.particlechamber.model.Location.OCCUPIED;
import static com.antonsulzhenko.particlechamber.model.Location.UNOCCUPIED;

/**
 * @author Anton Sulzhenko
 */
public class Renderer {
    private final int chamberSize;
    private final String emptyChamber;

    public Renderer(int chamberSize) {
        this(chamberSize, new ChamberSizeValidator());
    }

    Renderer(int chamberSize, ChamberSizeValidator validator) {
        validator.validate(chamberSize);

        this.chamberSize = chamberSize;
        this.emptyChamber = initEmptyChamber(chamberSize);
    }

    public String render(List<Particle> particles) {
        StringBuilder sb = new StringBuilder(emptyChamber);
        for (Particle particle : particles) {
            if (isOutOfChamber(particle)) {
                continue;
            }
            sb.setCharAt(particle.getPosition(), OCCUPIED.getLocation());
        }
        return sb.toString();
    }

    public String getEmptyChamber() {
        return this.emptyChamber;
    }

    private String initEmptyChamber(int chamberSize) {
        return String.valueOf(UNOCCUPIED.getLocation()).repeat(chamberSize);
    }

    private boolean isOutOfChamber(Particle particle) {
        return particle.getPosition() < 0 || particle.getPosition() > chamberSize - 1;
    }
}
