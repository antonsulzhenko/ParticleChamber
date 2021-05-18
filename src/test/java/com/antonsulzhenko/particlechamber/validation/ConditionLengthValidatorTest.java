package com.antonsulzhenko.particlechamber.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Anton Sulzhenko
 */
class ConditionLengthValidatorTest {

    @Test
    void validate_conditionsLessThanMin_exceptionThrown() {
        // Arrange
        String conditions = "";
        ConditionLengthValidator target = createTarget();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> target.validate(conditions));
    }

    @Test
    void validate_conditionsGreaterThanMax_exceptionThrown() {
        // Arrange
        String conditions = "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"; // 51 char
        ConditionLengthValidator target = createTarget();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> target.validate(conditions));
    }

    private ConditionLengthValidator createTarget() {
        return new ConditionLengthValidator();
    }
}