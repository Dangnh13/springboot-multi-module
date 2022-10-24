package jp.co.htkk.framework.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.htkk.framework.validation.annotation.HalfAlphaSpace;
import org.apache.commons.lang3.StringUtils;

/**
 * Integer check
 *
 */
public class HalfAlphaSpaceValidator implements ConstraintValidator<HalfAlphaSpace, String> {

	public void initialize(HalfAlphaSpace parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		String regex = "^[a-zA-Z ]*$";// /^[a-zA-Z ]*$/

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value);

		if (m.find()) {
			return true;
		} else {
			return false;
		}

	}

	private void validateParameters() {
		// Do nothing because don't have value need initialize
	}
}
