package com.experian.cis.commons.beanvalidation.test;

/*
 * @author Paul Hsu
 */
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.experian.cis.commons.beanvalidation.constraints.DateTime;
import com.experian.cis.commons.beanvalidation.constraints.ExistCheck;
import com.experian.cis.commons.beanvalidation.constraints.InString;
import com.experian.cis.commons.beanvalidation.constraints.NotExistCheck;
import com.experian.cis.commons.beanvalidation.constraints.Phone;
import com.experian.cis.commons.beanvalidation.constraints.UniqueCheck;

import lombok.Data;

@Data
public class TestBean {

	static final String mestype = "startAC,stopAC,startCharge,stopCharge,chargeTimer,vehicleStatus,general,recall,scheduleAC";
	@NotNull
	private String notNull;
	@NotEmpty
	private String notEmpty;
	//@Size(min = 5, max = 10)
	@Size(max = 10)
	private String size;
	@AssertTrue
	private boolean assertTrue;
	@AssertFalse
	private boolean assertFalse;
	@Min(value = 18)
	@Max(value = 100)
	private int minMax;
	@Email
	private String email;
	@Past
	private LocalDate past;
	@Future
	private LocalDate future;
	@DecimalMax("100.00")
	private BigDecimal decimalMax;
	@DecimalMin("10.00")
	private BigDecimal decimalMin;
	@NotBlank
	private String notBlank;

	private List<@NotBlank String> notBlankList;

	@Pattern(regexp = "^\\(\\d{3}\\)\\d{3}-\\d{4}")
	private String pattern;

	//////////////////////////////////////////////
	@Phone(format = "(###) ###-####")
	// @Phone(format = "(###)###-####")
	// @Phone(format = "###-###-####")
	// @Phone(format = "###-#######")
	// @Phone(format = "### ### ####")
	// @Phone(format = "###.###.####")
	private String phone;

	// UniqueCheckTest.class need to implement IUniqueValidateCheck
	@UniqueCheck(UniqueCheckTest.class)
	private String uniqueCheck;
	
	@DateTime(format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private String dateTime;

	@InString(values=mestype, casesensitive=false)
	private String inString;
	
	// ExistCheckTest.class need to implement IExistValidateCheck
	@ExistCheck(ExistCheckTest.class)
	private String existCheck;

	// NotExistCheckTest.class need to implement IExistValidateCheck
	@NotExistCheck(NotExistCheckTest.class)
	private String notExistCheck;

}
