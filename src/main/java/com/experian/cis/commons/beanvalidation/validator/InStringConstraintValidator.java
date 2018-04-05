package com.experian.cis.commons.beanvalidation.validator;

/*
 * @author Paul Hsu
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experian.cis.commons.beanvalidation.constraints.InString;

public class InStringConstraintValidator implements
		ConstraintValidator<InString, String> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(InStringConstraintValidator.class);
	String values;
	boolean casesensitive;

	@Override
	public void initialize(InString inString) {
		values = inString.values();
		casesensitive = inString.casesensitive();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext cxt) {
		boolean ret = false;
		LOGGER.debug("Validate '{}' against '{}'", value, values);
		List<String> myList = new ArrayList<String>(Arrays.asList(values
				.split(",")));
		if (casesensitive)
			ret = myList.stream().anyMatch(str -> str.trim().equals(value));
		else
			ret = myList.stream().anyMatch(str -> str.trim().equalsIgnoreCase(value));
		return ret;
	}
}
