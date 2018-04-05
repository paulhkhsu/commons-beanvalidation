package com.experian.cis.commons.beanvalidation;
/*
 * @author Paul Hsu
 */
import java.util.HashMap;
import java.util.Map;

public class BeanValidationErrorCode {
	private static final Integer ERRORCODESTART = 1000;
	private static final Integer INCR = 100;
	private static Integer prev_code = ERRORCODESTART;
 
	private static String REQUIRED = "REQUIRED";
	private static String INVALIDFORMAT = "INVALID FORMAT";
	private static String INVALIDVALUE = "INVALID VALUE";
	private static String INVALIDLENGTH = "INVALID LENGTH";
	private static String DUPLICATE = "DUPLICATE";
	
	public static final Map<String, BeanValidationTypeCode> ERRORCODEMAP = new HashMap<String, BeanValidationTypeCode>() {
			private static final long serialVersionUID = 1L;

			{
				// start from 1100
				BeanValidationTypeCode bvt;
				bvt = new BeanValidationTypeCode(REQUIRED, String.valueOf(prev_code += INCR) );
				put("Null", bvt);
				bvt = new BeanValidationTypeCode(REQUIRED, String.valueOf(prev_code += INCR) );
				put("NotNull", bvt);
				bvt = new BeanValidationTypeCode(REQUIRED, String.valueOf(prev_code += INCR) );
				put("NotEmpty", bvt);
				bvt = new BeanValidationTypeCode(REQUIRED, String.valueOf(prev_code += INCR) );
				put("NotBlank", bvt);
				bvt = new BeanValidationTypeCode(INVALIDLENGTH, String.valueOf(prev_code += INCR) );
				put("Size", bvt);
				bvt = new BeanValidationTypeCode(INVALIDFORMAT, String.valueOf(prev_code += INCR) );
				put("Digits", bvt);
				bvt = new BeanValidationTypeCode(INVALIDFORMAT, String.valueOf(prev_code += INCR) );
				put("Email", bvt);
				bvt = new BeanValidationTypeCode(INVALIDFORMAT, String.valueOf(prev_code += INCR) );
				put("Pattern", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("AssertFalse", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("AssertTrue", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("Min", bvt);
				bvt = new BeanValidationTypeCode(INVALIDLENGTH, String.valueOf(prev_code += INCR) );
				put("Max", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("Past", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("Future", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("DecimalMin", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("DecimalMax", bvt);
				bvt = new BeanValidationTypeCode(INVALIDFORMAT, String.valueOf(prev_code += INCR) );
				put("Phone", bvt);
				bvt = new BeanValidationTypeCode(DUPLICATE, String.valueOf(prev_code += INCR) );
				put("UniqueCheck", bvt);
				bvt = new BeanValidationTypeCode(DUPLICATE, String.valueOf(prev_code += INCR) );
				put("ExistCheck", bvt);
				bvt = new BeanValidationTypeCode(DUPLICATE, String.valueOf(prev_code += INCR) );
				put("NotExistCheck", bvt);
				bvt = new BeanValidationTypeCode(INVALIDFORMAT, String.valueOf(prev_code += INCR) );
				put("DateTime", bvt);
				bvt = new BeanValidationTypeCode(INVALIDVALUE, String.valueOf(prev_code += INCR) );
				put("InString", bvt);
			}
		};
	}