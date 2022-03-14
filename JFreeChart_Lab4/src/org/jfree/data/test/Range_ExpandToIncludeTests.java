package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_ExpandToIncludeTests {
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
	 * This test will simulate creating expandToInclude with a null range. This test
	 * should result in a lower range of the included value (1).
	 */
	@Test
	public void expandToIncludeNullLower() {
		Range nullRange = null; // creating a null range
		Range newRange = Range.expandToInclude(nullRange, 1);
		// trying to expand the null range to include 1
		assertEquals("The lower value will be 1", 1, newRange.getLowerBound(), .000000001d);
		// assertion that expected lower bound matches 1
	}

	/**
	 * This test will simulate creating expandToInclude with a null range. This test
	 * should result in a upper range of the included value (1).
	 */
	@Test
	public void expandToIncludeNullUpper() {
		Range nullRange = null; // creating a null range
		Range newRange = Range.expandToInclude(nullRange, 1);
		// trying to expand the null range to include 1
		assertEquals("The upper value will be 1", 1, newRange.getUpperBound(), .000000001d);
		// assertion that expected upper bound matches 1
	}

	/**
	 * This test will simulate expanding a range of 4 and 6 to include the value 5 -
	 * asserting that the upper margin will remain the same and be 6.
	 */
	@Test
	public void expandToInlcudeInsideRangeUpper() { // This test is for testing the expanding the range
		// which will include 5 in the range and making sure the upper value bound is
		// still the same.
		Range tempRange = Range.expandToInclude(new Range(4, 6), 5); // This is creating the test range for this test.
		assertEquals("The upper value will be 6", 6, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (6)
	}

	/**
	 * This test will simulate expanding a range of 4 and 6 to include the value 5 -
	 * asserting that the lower margin will remain the same and be 4.
	 */
	@Test
	public void expandToInlcudeInsideRangeLower() {// This test is for testing the expanding the range
		// which will include 5 in the range and making sure the lower value bound is
		// still the same.
		Range tempRange = Range.expandToInclude(new Range(4, 6), 5);// This is creating the test range for this test.
		assertEquals("The upper value will be 4", 4, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (4)
	}

	/**
	 * This test will simulate expanding a range of 0.4 and 5.7 to include the value
	 * 11.2 - asserting that the upper margin will expand to be 11.2.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeUpper() { // This test is for testing the expanding the range
		// which will include 5.7 in the range and making sure the upper value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(0.4, 5.7), 11.2);// This is creating the test range for this
																			// test.
		assertEquals("The upper value will be 11.2", 11.2, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (11.2)
	}

	/**
	 * This test will simulate expanding a range of 0.4 and 5.7 to include the value
	 * 7 - asserting that the lower margin will remain the same of 0.4.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeLower() { // This test is for testing the expanding the range
		// which will include 5.7 in the range and making sure the lower bound remains
		// the same.
		Range tempRange = Range.expandToInclude(new Range(0.4, 5.7), 11.2);// This is creating the test range for this
																			// test.
		assertEquals("The lower value should remain the same and be 0.4", 0.4, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.4)
	}

	/**
	 * This test will simulate expanding a range of 1.6 and 2.6 to include the value
	 * 0.5 - asserting that the upper margin will remain the same of 2.6.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeUpper() {// This test is for testing the expanding the range
		// which will include 0.5 in the range and making sure the upper bound will
		// remain the same.
		Range tempRange = Range.expandToInclude(new Range(1.6, 2.6), 0.5);// This is creating the test range for this
																			// test.
		assertEquals("The lower value will be 2.6", 2.6, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (2.6)
	}

	/**
	 * This test will simulate expanding a range of 1.6 and 2.6 to include the value
	 * 0.5 - asserting that the upper margin will expand to be 0.5.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeLower() {// This test is for testing the expanding the range
		// which will include 0.5 in the range and making sure the lower value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(1.6, 2.6), 0.5);// This is creating the test range for this
																			// test.
		assertEquals("The lower value will be 0.5", 0.5, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.5)
	}

	/**
	 * This test will simulate expanding a range of -4.4 and -6.4 to include the
	 * value -5.4 - asserting that the upper margin will remain the same and be
	 * -4.4.
	 */
	@Test
	public void expandToInlcudeInsideRangeUpperNegative() { // This test is for testing the expanding the range
		// which will include -5 in the range and making sure the upper value bound
		// remains the same.
		Range tempRange = Range.expandToInclude(new Range(-6.4, -4.4), -5.4); // This is creating the test range for
																				// this test.
		assertEquals("The upper value will be -4.4", -4.4, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-4.4)
	}

	/**
	 * This test will simulate expanding a range of -4 and -6 to include the value
	 * -5 - asserting that the lower margin will remain the same and be -6.
	 */
	@Test
	public void expandToInlcudeInsideRangeLowerNegative() {// This test is for testing the expanding the range
		// which will include -5 in the range and making sure the lower value bound
		// remains the same.
		Range tempRange = Range.expandToInclude(new Range(-6, -4), -5);// This is creating the test range for this test.
		assertEquals("The lower value will be -6", -6, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (-4)
	}

	/**
	 * This test will simulate expanding a range of -0.4 and -5.7 to include the
	 * value 11.2 - asserting that the upper margin will remain the same of -0.4.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeUpperNegative() { // This test is for testing the expanding the range
		// which will include -5.7 in the range and making sure the upper bound remains
		// the same.
		Range tempRange = Range.expandToInclude(new Range(-5.7, -0.4), -11.2);// Creating the test range for this test.
		assertEquals("The upper value will be -0.4", -0.4, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-0.4)
	}

	/**
	 * This test will simulate expanding a range of -0.4 and -5.7 to include the
	 * value 7 - asserting that the lower margin will expand to be -11.2.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeLowerNegative() { // This test is for testing the expanding the range
		// which will include -5.7 in the range and making sure the lower value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(-5.7, -0.4), -11.2);// Creating the test range for this test.
		assertEquals("The lower value should remain the same and be -11.2", -11.2, tempRange.getLowerBound(),
				.000000001d);
		// assertion that expected value matches the actual value (-11.2)
	}

	/**
	 * This test will simulate expanding a range of -1.6 and -2.6 to include the
	 * value 0.5 - asserting that the upper margin will remain the same of -2.6.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeLowerNegative() {// This test is for testing the expanding the range
		// which will include -0.5 in the range and making sure the lower bound will
		// remain the same.
		Range tempRange = Range.expandToInclude(new Range(-2.6, -1.6), -0.5);// This is creating the test range for this
																				// test.
		assertEquals("The lower value will be -2.6", -2.6, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (-2.6)
	}

	/**
	 * This test will simulate expanding a range of -1.6 and -2.6 to include the
	 * value 0.5 - asserting that the upper margin will expand to be -0.5.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeUpperNegative() {// This test is for testing the expanding the range
		// which will include -0.5 in the range and making sure the upper value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(-2.6, -1.6), -0.5);// This is creating the test range for this
																				// test.
		assertEquals("The lower value will be -0.5", -0.5, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-0.5)
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
