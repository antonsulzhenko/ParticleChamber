package com.antonsulzhenko.particlechamber.validation;

/**
 * @author Anton Sulzhenko
 */
public class ChamberSizeValidator implements SimpleIntValidator {

    @Override
    public void validate(int chamberSize) {
        if (chamberSize < 0) {
            throw new IllegalArgumentException("Chamber size can't be less than 0");
        }
    }
}
