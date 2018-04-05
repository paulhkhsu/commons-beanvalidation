package com.experian.cis.commons.beanvalidation.validator;

/*
 * @author Paul Hsu
 */
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experian.cis.commons.beanvalidation.constraints.Phone;

public class PhoneConstraintValidator implements
		ConstraintValidator<Phone, String> {
	private static final Logger LOGGER = LoggerFactory.getLogger(PhoneConstraintValidator.class);

	private static Map<String, String> DATE_FORMAT_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;

		{
			put("(###) ###-####","^\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
			put("(###)###-####", "^\\(\\d{3}\\)\\d{3}-\\d{4}");
			put("###-###-####",  "^[1-9]\\d{2}-\\d{3}-\\d{4}");
			put("###-#######",   "^[1-9]\\d{2}-\\d{3}\\d{4}");
			put("### ### ####",  "^[1-9]\\d{2}\\s\\d{3}\\s\\d{4}");
			put("###.###.####",  "^[1-9]\\d{2}\\.\\d{3}\\.\\d{4}");
		}
	};

	String format;

	@Override
	public void initialize(Phone phone) {
		format = phone.format();
	}

	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
		if (phoneField == null) {
			return false;
		}
		LOGGER.debug("Validate '{}' against '{}'", phoneField, format);
		String expr = (String) DATE_FORMAT_MAP.get(format);
		if (StringUtils.isEmpty(expr))
			return false;

		return phoneField.matches(expr);
	}

}
