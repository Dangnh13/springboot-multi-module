package jp.co.htkk.framework.validation;

import jp.co.htkk.framework.validation.annotation.LengthMinWithOutSpace;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthMinWithOutSpaceValidator implements ConstraintValidator<LengthMinWithOutSpace, String> {
    private int min;

    public void initialize(LengthMinWithOutSpace parameters) {
        min = parameters.min();
        validateParameters();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        int length = value.trim().length();
        return length >= min;
    }

    private void validateParameters() {
        if (min < 0) {
            throw new IllegalArgumentException("The min parameter cannot be negative.");
        }

    }

}
