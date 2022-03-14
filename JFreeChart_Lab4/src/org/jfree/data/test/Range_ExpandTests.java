package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_ExpandTests {
	private Range exampleRange; // The example range which was given to us
	private Range testRange1; // Created this range to test other functionalities of the test range.
	private Range testExpandRange; // This is the expanded range in use for the expand method.

	// -----------------------------------------------------------------------------------------
	// The following code was taken from the SENG438 Lab Document
	// -----------------------------------------------------------------------------------------
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// This calls the setUpBefore even the class exists and does nothing.
	}
	@Before
	public void setUp() throws Exception {
		// Before each test case this object of range is ready for us to use.
		exampleRange = new Range(-1, 1);
	}
	
	/**
	 * This test will simulate creating expand a null range. This test should throw
	 * an exception.
	 */
	@Test
	public void expandNull() {
		try {
			Range nullRange = null; // creating a null range
			testExpandRange = Range.expand(nullRange, 0.25, 0.5); // trying to expand the null range
			fail("This method should throw an exception!");
			// creating a failure message for if expand does not throw an
			// exception
		} catch (Exception e) {
			assertEquals("The exception thrown type is IllegalArgumentException", IllegalArgumentException.class,
					e.getClass());
			// catching the exception, asserting that an IllegalArgumentException was thrown
		}
	}

	/**
	 * This test will simulate expanding the range by 0.25 and 0.5 - asserting that
	 * the lower margin will be expanded to be 1.
	 */
	@Test
	public void expandTestLowerMarginInt() { // This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the lower bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.25, 0.5); // Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The lower margin range will be 1", 1, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (1)
	}

	/**
	 * This test will simulate expanding the range by 0.25 and 0.5 - asserting that
	 * the upper margin will be expanded to be 8.
	 */
	@Test
	public void expandTestUpperMarginInt() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.25, 0.5);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be 8", 8, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (8)
	}

	/**
	 * This test will simulate expanding the range by 1.25 and 1.5 - asserting that
	 * the upper margin will be expanded to be 12.
	 */
	@Test
	public void expandTestUpperMarginOverOne() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 1.25, 1.5);// Using the expand method to pass in the test
		// range and the margin values which are greater than 1.
		assertEquals("The upper margin range will be 12", 12, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (12)
	}

	/**
	 * This test will simulate expanding the range by -0.24 and -0.50 - asserting
	 * that the upper margin will be shrink to be 4.
	 */
	@Test
	public void expandTestUpperMarginLessOne() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, -0.24, -0.5);// Using the expand method to pass in the test
		// range and the margin values which are less than 0.
		assertEquals("The upper margin range will be 4", 4, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (4)
	}

	/**
	 * This test will simulate expanding the range by 0.33 and 0.44 - asserting that
	 * the lower margin will be expanded to be 0.68.
	 */
	@Test
	public void expandTestLowerMarginDecimal() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the lower bound as a
		// decimal.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.33, 0.44);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The lower margin range will be 0.68", 0.68, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.68)
	}

	/**
	 * This test will simulate expanding the range by 0.33 and 0.44 - asserting that
	 * the upper margin will be expanded to be 7.76.
	 */
	@Test
	public void expandTestUpperMarginDecimal() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as a
		// decimal.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.33, 0.44);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be 7.76", 7.76, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (7.76)
	}

	/**
	 * This test will simulate that if we pass in an expansion of zero in the
	 * parameters there should be an exception thrown.
	 */
	@Test
	public void expandTestWithZero() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which are all 0.
		try {
			testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
			testExpandRange = Range.expand(testRange1, 0, 0);// Using the expand method to pass in the test
			assertEquals("The new range after the expansion of zero was different than orginal.", testRange1,
					testExpandRange);
		} catch (Exception e) {
			fail("Expanding it by zero threw an exception");
		}
		// The assert checks for the exception which is being thrown.
	}

	/**
	 * This test will simulate expanding the range by 0.44 and 0.33 - asserting that
	 * the upper margin will be expanded to be -0.68.
	 */
	@Test
	public void expandTestUpperMarginNegativeRange() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as a
		// decimal.
		testRange1 = new Range(-6, -2); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.44, 0.33);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be -0.68", -0.68, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-0.68)
	}

	/**
	 * This test will simulate expanding the range by -0.29 and -0.35 - asserting
	 * that the lower margin will be expanded to be -4.84.
	 */
	@Test
	public void expandTestUpperMarginNegativeMargins() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as a
		// decimal.
		testRange1 = new Range(-6, -2); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, -0.29, -0.35);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be -4.84", -4.84, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (-4.84)
	}
	
	/**
	 * This test will be testing the expand function where the double value lower is
	 * greater than upper.
	 */
	@Test
	public void expandLowerGreaterThanUpper_Lower() {
		testRange1 = new Range(1, 2); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, -0.9, -0.9); // Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The lower margin range will be 1.5", 1.5, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.7)
	}
	@After
	public void tearDown() throws Exception {
		// Tear down function for after running the tests it does nothing.
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Do nothing once the class is over running the cases in the SUT
	}
}
