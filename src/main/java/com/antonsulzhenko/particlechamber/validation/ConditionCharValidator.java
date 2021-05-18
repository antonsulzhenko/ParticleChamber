package com.antonsulzhenko.particlechamber.validation;

import static com.antonsulzhenko.particlechamber.model.Direction.*;

/**
 * @author Anton Sulzhenko
 */
public class ConditionCharValidator implements ConditionValidator {

    @Override
    public void validate(String conditions) {
        for (char c : conditions.toCharArray()) {
            if (c != LEFT.getDirection() && c != RIGHT.getDirection() && c != EMPTY.getDirection()) {
                throw new IllegalArgumentException("Unknown condition. Valid condition chars: 'L', 'R', '.'");
            }
        }
    }
}
