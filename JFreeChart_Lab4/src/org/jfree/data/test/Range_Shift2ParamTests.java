package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_Shift2ParamTests {
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
	 * This test will be used to test what happens when the first parameter is null
	 * for the upper bound. This throw a illegal argument pointer exception as null
	 * is not permitted.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shiftNullUpperBound() {
		Range testShiftedRange = Range.shift(null, 2.0);
		assertEquals("The upper bound value should be null", testShiftedRange.getUpperBound());
	}

	/**
	 * This test will be used to test what happens when the first parameter is null
	 * for the lower bound. This throw a illegal argument pointer exception as null
	 * is not permitted.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shiftNullLowerBound() {
		Range testShiftedRange = Range.shift(null, 2.0);
		assertEquals("The lower bound value should be null", testShiftedRange.getLowerBound());
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * positive amount. We are only checking the upper bound of the range.
	 */
	@Test
	public void shiftByPositiveDoubleUpperBound() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, 158.3);
		assertEquals("The shifted value should be ", 164.3, testShiftedRange.getUpperBound(), .000000001d);
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * positive amount. We are only checking the lower bound of the range.
	 */
	@Test
	public void shiftByPositiveDoubleLowerBound() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, 2.2);
		assertEquals("The shifted value should be ", 4.2, testShiftedRange.getLowerBound(), .000000001d);
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * negative amount. We are only checking the upper bound of the range.
	 */
	@Test
	public void shiftByNegativeDoubleUpperBound() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, -2.2);
		assertEquals("The shifted value should be ", 3.8, testShiftedRange.getUpperBound(), .000000001d);
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * negative amount. We are only checking the lower bound of the range.
	 */
	@Test
	public void shiftByNegativeDoubleLowerBound() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, -1.2);
		assertEquals("The shifted value should be ", 0.8, testShiftedRange.getLowerBound(), .000000001d);
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
