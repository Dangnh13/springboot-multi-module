package jp.co.htkk.framework.validation.annotation;

import jp.co.htkk.framework.validation.LengthMinWithOutSpaceValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = LengthMinWithOutSpaceValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface LengthMinWithOutSpace {

	String name() default "";

	int min() default 1;

	String message() default "{name} must be at least {min} digits";

	Class<?>[]groups() default {};

	Class<? extends Payload>[] payload() default { };

	/**
	 * Defines several {@code @Length} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		LengthMinWithOutSpace[] value();
	}

}
