package com.antonsulzhenko.particlechamber.validation;

/**
 * @author Anton Sulzhenko
 */
public class ConditionLengthValidator implements ConditionValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 50;

    @Override
    public void validate(String conditions) {
        if (conditions == null || conditions.length() < MIN_LENGTH || conditions.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Conditions length should be in [1; 50] range");
        }
    }
}
