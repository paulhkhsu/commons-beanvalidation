package com.experian.cis.commons.beanvalidation;

/*
 * @author Paul Hsu
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanValidationUtils {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BeanValidationUtils.class);

	private Validator validator;

	public BeanValidationUtils() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public List<BeanValidationError> validateBean(Object o) {
		List<BeanValidationError> result = new ArrayList<BeanValidationError>();
		Set<ConstraintViolation<Object>> violations = validator.validate(o);
		for (ConstraintViolation<Object> violation : violations) {
			BeanValidationTypeCode bdt = getErrorCode(violation.getMessageTemplate());

			String tempStr = (violation.getInvalidValue() == null) ? "null" : violation.getInvalidValue().toString();
			BeanValidationError bve = new BeanValidationError(bdt.getCode(),
					violation.getMessage(), violation.getPropertyPath()
							.toString(), bdt.getType(), tempStr);
			result.add(bve);
		}
		return result;
	}

	private BeanValidationTypeCode getErrorCode(String errorTemplate) {

		BeanValidationTypeCode bdt = new BeanValidationTypeCode("n/a", "n/a");
		
		if (StringUtils.isEmpty(errorTemplate))
			return bdt;

		String s1 = errorTemplate.replace("{", "");
		String s2 = s1.replace("}", "");
		String[] splits = s2.split("\\.");
		for (int i = 0; i < splits.length; i++) {

			String sp = splits[i];
			bdt = BeanValidationErrorCode.ERRORCODEMAP.get(sp);
			if (bdt != null) {
				break;
			}
		}

		
		return bdt;

	}
}
