package jp.co.htkk.framework.validation;

import jp.co.htkk.framework.validation.annotation.AllowValues;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class AllowValuesValidator implements ConstraintValidator<AllowValues, String> {

    private List<String> acceptedValues;

    @Override
    public void initialize(AllowValues annotation) {
        if (annotation.values() != null && annotation.values().length > 0) {
            acceptedValues = Arrays.asList(annotation.values());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) return true;
        return acceptedValues.contains(value);
    }
}
