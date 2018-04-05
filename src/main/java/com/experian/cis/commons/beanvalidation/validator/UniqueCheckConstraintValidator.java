package com.experian.cis.commons.beanvalidation.validator;
/*
 * @author Paul Hsu
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.experian.cis.commons.beanvalidation.constraints.UniqueCheck;
import com.experian.cis.commons.beanvalidation.intf.IUniqueValidateCheck;

public class UniqueCheckConstraintValidator implements ConstraintValidator<UniqueCheck, Object> {
	private static final Logger LOGGER = LoggerFactory.getLogger(UniqueCheckConstraintValidator.class);
	Class<?> claz;

	@Override
	public void initialize(UniqueCheck uniqueCheck) { 
		claz = uniqueCheck.value();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext cxt) {
		boolean ret = false;
		if(claz != null) {
			Object obj;
			try {
				LOGGER.debug("New {} ", claz.toString());
				obj = claz.newInstance();
				if(obj instanceof IUniqueValidateCheck)
					ret = ((IUniqueValidateCheck) obj).isUnique(value);
				else
					LOGGER.error("'{}' must implement interface IUniqueValidateCheck", claz.toString());
			} catch (InstantiationException | IllegalAccessException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return ret;
	}

}
