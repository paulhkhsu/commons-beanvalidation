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

import com.experian.cis.commons.beanvalidation.validator.NotExistCheckConstraintValidator;

@Documented
@Constraint(validatedBy = NotExistCheckConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExistCheck {
    Class<?> value();
	
	String message() default "{validate.NotExistCheck.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	 
}