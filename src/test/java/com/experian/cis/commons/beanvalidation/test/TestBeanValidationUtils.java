package com.experian.cis.commons.beanvalidation.test;

/*
 * @author Paul Hsu
 */
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.experian.cis.commons.beanvalidation.BeanValidationError;
import com.experian.cis.commons.beanvalidation.BeanValidationUtils;

public class TestBeanValidationUtils {

	private BeanValidationUtils beanValidationUtils;

	@Before
	public void setup() {
		beanValidationUtils = new BeanValidationUtils();
	}

	private void validate(Object test) {
		List<BeanValidationError> ll = beanValidationUtils.validateBean(test);
		for (BeanValidationError b : ll) {
			String s = String.format("%s - %s - %s - %s - %s", b.getCode(),
					b.getFieldName(), b.getDescription(), b.getType(), b.getInvalidValue());
			System.out.println(s);
		}

	}

	private TestBean createTestBean() {
		TestBean testBean = new TestBean();
		testBean.setNotNull("not null");
		testBean.setNotEmpty("not empty");
		testBean.setSize("12345");
		testBean.setAssertTrue(true);
		testBean.setMinMax(20);
		testBean.setEmail("test@test.com");
		testBean.setPast(LocalDate.of(2016, 1, 1));
		testBean.setFuture(LocalDate.of(2019, 1, 1));

		List<String> ll = new ArrayList<String>();
		ll.add("string1");
		testBean.setNotBlankList(ll);
		testBean.setNotBlank("no blank");

		testBean.setDecimalMax(new BigDecimal(99.00));
		testBean.setDecimalMin(new BigDecimal(11.00));
		testBean.setPhone("(123) 456-7890");
		testBean.setUniqueCheck("uniqueid");
		testBean.setPattern("(123)456-7890");
		testBean.setInString("startaC");
		testBean.setDateTime("2019-03-15T15:34:30.548-0500");

		testBean.setExistCheck("exist");
		testBean.setNotExistCheck("notexist");
		return testBean;
	}

	@Test
	public void notNull() {
		System.out.println("notNull");
		TestBean test = createTestBean();
		test.setNotNull(null);
		validate(test);
	}

	@Test
	public void notEmpty() {
		System.out.println("notEmpty");
		TestBean test = createTestBean();
		test.setNotEmpty(null);
		validate(test);
	}

	@Test
	public void size() {
		System.out.println("size");
		TestBean test = createTestBean();
		test.setSize(null);
		validate(test);
		test.setSize("");
		validate(test);
		test.setSize("12345678901");
		validate(test);
	}
	// @Test
	public void min() {
		System.out.println("min");
		TestBean test = createTestBean();
		test.setMinMax(15);
		validate(test);
	}

	// @Test
	public void max() {
		System.out.println("max");
		TestBean test = createTestBean();
		test.setMinMax(150);
		validate(test);
	}

	//@Test
	public void email() {
		System.out.println("email");
		TestBean test = createTestBean();
		test.setEmail("ddd");
		validate(test);
	}

	 //@Test
	public void past() {
		System.out.println("past");
		TestBean test = createTestBean();
		test.setPast(LocalDate.of(2030, 1, 1));
		validate(test);
	}

	// @Test
	public void future() {
		System.out.println("future");
		TestBean test = createTestBean();
		test.setFuture(LocalDate.of(2011, 1, 1));
		validate(test);
	}

	//@Test
	public void notBlank() {
		System.out.println("notBlank");
		TestBean test = createTestBean();
		test.setNotBlank("");
		List<String> ll1 = new ArrayList<String>();
		ll1.add("");
		test.setNotBlankList(ll1);
		validate(test);
	}

	// @Test
	public void bigDecimalMinMax() {
		System.out.println("bigDecimalMinMax");
		TestBean test = createTestBean();
		test.setDecimalMax(new BigDecimal(200.00));
		test.setDecimalMin(new BigDecimal(8.00));
		validate(test);
	}

	// @Test
	public void phone() {
		System.out.println("phone");
		TestBean test = createTestBean();
		 test.setPhone("1234567890999");
		//test.setPhone("123.456.7890");
		validate(test);
	}

	// @Test
	public void uniqueCheck() {
		System.out.println("uniqueCheck");
		TestBean test = createTestBean();
		validate(test);
		test.setUniqueCheck("notvalid");
		validate(test);
	}

	// @Test
	public void pattern() {
		System.out.println("pattern");
		TestBean test = createTestBean();
		test.setPattern("11111111");
		validate(test);
	}

	// @Test
	public void dateTime() {
		System.out.println("dateTime");
		TestBean test = createTestBean();
		test.setDateTime("2017-23-155T15:34:30.548-0500");
		validate(test);
	}

	// @Test
	public void inString() {
		System.out.println("inString");
		TestBean test = createTestBean();
		test.setInString("bad");
		validate(test);
	}

	//@Test
	public void existCheck() {
		System.out.println("existCheck");
		TestBean test = createTestBean();
		test.setExistCheck("notexist");
		validate(test);
	}
	
	//@Test
	public void notExistCheck() {
		System.out.println("notExistCheck");
		TestBean test = createTestBean();
		test.setNotExistCheck("exist");
		validate(test);
	}
	
}
