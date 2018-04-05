package com.experian.cis.commons.beanvalidation.validator;

/*
 * @author Paul Hsu
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experian.cis.commons.beanvalidation.constraints.DateTime;

public class DateTimeConstraintValidator implements
		ConstraintValidator<DateTime, String> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DateTimeConstraintValidator.class);
	String format;

	@Override
	public void initialize(DateTime dateTime) {
		format = dateTime.format();
	}

	@Override
	public boolean isValid(String dt, ConstraintValidatorContext cxt) {
		LOGGER.debug("Validate '{}' against '{}'", dt, format);
		return dateFormatCheck(dt, format);
	}

	private boolean dateFormatCheck(String value, String format) {
		if (StringUtils.isEmpty(value))
			return false;
		SimpleDateFormat smft = new SimpleDateFormat(format);
		smft.setLenient(false);
		try {
			Date dt = smft.parse(value);
			LOGGER.debug(dt.toString());
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

}
