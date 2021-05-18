package com.antonsulzhenko.particlechamber;

import com.antonsulzhenko.particlechamber.validation.ConditionCharValidator;
import com.antonsulzhenko.particlechamber.validation.ConditionLengthValidator;
import com.antonsulzhenko.particlechamber.validation.ParticleSpeedValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Anton Sulzhenko
 */
@ExtendWith(MockitoExtension.class)
class ChamberTest {

    private static final List<String> SCENARIO_0_EXPECTED_RESULT = List.of("..X....", "....X..", "......X", ".......");
    private static final List<String> SCENARIO_1_EXPECTED_RESULT = List.of("XX..XXX", ".X.XX..", "X.....X", ".......");
    private static final List<String> SCENARIO_2_EXPECTED_RESULT = List.of("XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", ".........");
    private static final List<String> SCENARIO_3_EXPECTED_RESULT = List.of("XXXXXXXXXX", "..........");
    private static final List<String> SCENARIO_4_EXPECTED_RESULT = List.of("...");
    private static final List<String> SCENARIO_5_EXPECTED_RESULT = List.of("XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.",
            ".X.XX.X.X..XX.XX.XX", "X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.",
            "..X....XX..XX..XX.X", ".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X",
            "....X..X...XX...X..", "...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...",
            "X..X...........XX..", "..X.............XX.", ".X...............XX", "X.................X", "...................");

    @Mock
    private ConditionCharValidator conditionCharValidator;

    @Mock
    private ConditionLengthValidator conditionLengthValidator;

    @Mock
    private ParticleSpeedValidator particleSpeedValidator;

    @Test
    void chamberConstructor_create_validationInvoked() {
        // Arrange
        String conditions = "LLR";

        // Act
        createTarget(conditions);

        // Assert
        verify(conditionCharValidator, times(1)).validate(conditions);
        verify(conditionLengthValidator, times(1)).validate(conditions);
    }

    @Test
    void animate_any_speedValidationInvoked() {
        // Arrange
        String conditions = "LLR";
        int speed = 1;
        Chamber chamber = createTarget(conditions);

        // Act
        chamber.animate(speed);

        // Assert
        verify(particleSpeedValidator, times(1)).validate(speed);
    }

    @Test
    void animate_scenario0_expectedScenario0Animation() {
        // Arrange
        String conditions = "..R....";
        int speed = 2;
        Chamber chamber = createTarget(conditions);

        // Act
        List<String> animations = chamber.animate(speed);

        // Assert
        assertLinesMatch(SCENARIO_0_EXPECTED_RESULT, animations);
    }

    @Test
    void animate_scenario1_expectedScenario1Animation() {
        // Arrange
        String conditions = "RR..LRL";
        int speed = 3;
        Chamber chamber = createTarget(conditions);

        // Act
        List<String> animations = chamber.animate(speed);

        // Assert
        assertLinesMatch(SCENARIO_1_EXPECTED_RESULT, animations);
    }

    @Test
    void animate_scenario2_expectedScenario2Animation() {
        // Arrange
        String conditions = "LRLR.LRLR";
        int speed = 2;
        Chamber chamber = createTarget(conditions);

        // Act
        List<String> animations = chamber.animate(speed);

        // Assert
        assertLinesMatch(SCENARIO_2_EXPECTED_RESULT, animations);
    }

    @Test
    void animate_scenario3_expectedScenario3Animation() {
        // Arrange
        String conditions = "RLRLRLRLRL";
        int speed = 10;
        Chamber chamber = createTarget(conditions);

        // Act
        List<String> animations = chamber.animate(speed);

        // Assert
        assertLinesMatch(SCENARIO_3_EXPECTED_RESULT, animations);
    }

    @Test
    void animate_scenario4_expectedScenario4Animation() {
        // Arrange
        String conditions = "...";
        int speed = 1;
        Chamber chamber = createTarget(conditions);

        // Act
        List<String> animations = chamber.animate(speed);

        // Assert
        assertLinesMatch(SCENARIO_4_EXPECTED_RESULT, animations);
    }
    @Test
    void animate_scenario5_expectedScenario5Animation() {
        // Arrange
        String conditions = "LRRL.LR.LRR.R.LRRL.";
        int speed = 1;
        Chamber chamber = createTarget(conditions);

        // Act
        List<String> animations = chamber.animate(speed);

        // Assert
        assertLinesMatch(SCENARIO_5_EXPECTED_RESULT, animations);
    }

    private Chamber createTarget(String conditions) {
        return new Chamber(conditions,
                List.of(conditionLengthValidator, conditionCharValidator),
                particleSpeedValidator);
    }
}