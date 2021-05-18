package com.antonsulzhenko.particlechamber;

import com.antonsulzhenko.particlechamber.model.Direction;
import com.antonsulzhenko.particlechamber.model.Particle;
import com.antonsulzhenko.particlechamber.rendering.Renderer;
import com.antonsulzhenko.particlechamber.validation.ConditionCharValidator;
import com.antonsulzhenko.particlechamber.validation.ConditionLengthValidator;
import com.antonsulzhenko.particlechamber.validation.ConditionValidator;
import com.antonsulzhenko.particlechamber.validation.ParticleSpeedValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Sulzhenko
 */
public class Chamber {
    private final String conditions;
    private final Renderer renderer;

    private final ParticleSpeedValidator particleSpeedValidator;

    public Chamber(String conditions) {
        this(conditions, List.of(new ConditionLengthValidator(), new ConditionCharValidator()),
                new ParticleSpeedValidator());
    }

    Chamber(String conditions, List<ConditionValidator> conditionValidators, ParticleSpeedValidator particleSpeedValidator) {
        validateConditions(conditions, conditionValidators);

        this.conditions = conditions;
        this.renderer = new Renderer(conditions.length());
        this.particleSpeedValidator = particleSpeedValidator;
    }

    public List<String> animate(int speed) {
        particleSpeedValidator.validate(speed);

        List<String> result = new ArrayList<>();
        List<Particle> particles = createParticles();

        String chamberStep = renderer.render(particles);
        result.add(chamberStep);
        while (!chamberStep.equals(renderer.getEmptyChamber())) {
            move(particles, speed);
            chamberStep = renderer.render(particles);
            result.add(chamberStep);
        }

        return result;
    }

    private List<Particle> createParticles() {
        List<Particle> particles = new ArrayList<>();
        int position = 0;
        for (char c : conditions.toCharArray()) {
            Direction direction = Direction.of(c);
            if (!Direction.EMPTY.equals(direction)) {
                particles.add(new Particle(position, direction));
            }
            position++;
        }
        return particles;
    }

    private void move(List<Particle> particles, int speed) {
        particles.forEach(particle -> particle.move(speed));
    }

    private void validateConditions(String conditions, List<ConditionValidator> conditionValidators) {
        conditionValidators.forEach(v -> v.validate(conditions));
    }
}
