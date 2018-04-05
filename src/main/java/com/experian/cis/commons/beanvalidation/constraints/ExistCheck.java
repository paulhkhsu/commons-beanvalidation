package com.experian.cis.commons.beanvalidation.constraints;
/*
 * @author Paul Hsu
 */
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.experian.cis.commons.beanvalidation.validator.ExistCheckConstraintValidator;

@Documented
@Constraint(validatedBy = ExistCheckConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCheck {
    Class<?> value();
	
	String message() default "{validate.ExistCheck.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	 
}