package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_MinAndMaxTests {
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
	 * This test will be testing the min function through the use of the
	 * combineIgnoringNaN function. We will be testing the second parameter to min
	 * and max as a NaN value
	 */
	@Test
	public void minAndMaxD2_NaN() {
		double NaNParam1 = Math.sqrt(-1); // creating a not-a-number to be used as parameters
		double NaNParam2 = Math.sqrt(-2);
		testRange1 = new Range(1, 4); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, new Range(NaNParam1, NaNParam2)); // will make a call to both
																								// min and max with d2
																								// as a NaN value
		assertEquals("The return value should be 4", returnRange.getUpperBound(), 4, .000000001d);
		// assertion that expected value matches the actual value of 4
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
