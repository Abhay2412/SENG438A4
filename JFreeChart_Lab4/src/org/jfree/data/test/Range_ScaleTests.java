package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_ScaleTests {
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
	 * This test will simulate scaling a range with a negative factor. This test
	 * should throw an exception.
	 */
	@Test
	public void scaleNegativeFactor() {
		try {
			testRange1 = new Range(0, 6);
			Range testScale = Range.scale(testRange1, -1);
			fail("This method should throw an exception!");
			// creating a failure message for if scale does not throw an
			// exception
		} catch (Exception e) {
			assertEquals("The exception thrown type is IllegalArgumentException", IllegalArgumentException.class,
					e.getClass());
			// catching the exception, asserting that an IllegalArgumentException was thrown
		}
	}

	/**
	 * This test will be used to test what happens when a range is scaled by a
	 * positive factor with positive range. We are only checking the upper bound of
	 * the range.
	 */
	@Test
	public void scalePositiveRangePositiveFactor() {
		testRange1 = new Range(0, 6);
		Range testScale = Range.scale(testRange1, 2);
		assertEquals("The shifted value should be ", 12, testScale.getUpperBound(), .000000001d);
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
