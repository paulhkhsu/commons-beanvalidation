package com.experian.cis.commons.beanvalidation;
/*
 * @author Paul Hsu
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BeanValidationError {
	private String code;
	private String description;
	private String fieldName;
	private String type;
	private String invalidValue;
}
