package com.experian.cis.commons.beanvalidation;
/*
 * @author Paul Hsu
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BeanValidationTypeCode {
	private String type;
	private String code;

}
