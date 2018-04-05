package com.experian.cis.commons.beanvalidation.validator;

/*
 * @author Paul Hsu
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experian.cis.commons.beanvalidation.constraints.ExistCheck;
import com.experian.cis.commons.beanvalidation.intf.IExistValidateCheck;

public class ExistCheckConstraintValidator implements
		ConstraintValidator<ExistCheck, Object> {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ExistCheckConstraintValidator.class);
	Class<?> claz;

	@Override
	public void initialize(ExistCheck existCheck) {
		claz = existCheck.value();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext cxt) {
		boolean ret = false;
		if (claz != null) {
			Object obj;
			try {
				obj = claz.newInstance();
				if (obj instanceof IExistValidateCheck)
					ret = ((IExistValidateCheck) obj).isExist(value);
				else
					LOGGER.error(
							"'{}' must implement interface IExistValidateCheck",
							claz.toString());
			} catch (InstantiationException | IllegalAccessException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return ret;
	}

}
