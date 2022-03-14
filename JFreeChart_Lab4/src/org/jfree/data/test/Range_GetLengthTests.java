package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_GetLengthTests {
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
	 * This test will be used to test the length of a range when it should be zero.
	 */
	@Test
	public void testGetLengthZero() {
		Range tempRange = new Range(1, 1); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 0.0 and it is " + length, 0.0, length, .000000001d);
		// assertion that expected value matches the actual value (0.0)
	}

	/**
	 * This test will be used to test the length of an extremely large positive
	 * range
	 */
	@Test
	public void testGetLengthLargePositive() {
		Range tempRange = new Range(2, 200000000); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 199,999,998 and it is " + length, 199999998.0, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of an extremely large negative
	 * range
	 */
	@Test
	public void testGetLengthLargeNegative() {
		Range tempRange = new Range(-200000000, -2); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 199,999,998 and it is " + length, 199999998.0, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of a range composed of two decimal
	 * numbers
	 */
	@Test
	public void testGetLengthRangeIsDecimal() {
		Range tempRange = new Range(-200.03, 200.50); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 400.53 and it is " + length, 400.53, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of a range composed of no decimals
	 */
	@Test
	public void testGetLengthRangeIsNonDecimal() {
		Range tempRange = new Range(-30, 35); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 65 and it is " + length, 65, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of a range composed of a decimal
	 * and an integer
	 */
	@Test
	public void testGetLengthRangeMixedDecimal() {
		Range tempRange = new Range(-200.03, 200); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 400.03 and it is " + length, 400.03, length, .000000001d);
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
