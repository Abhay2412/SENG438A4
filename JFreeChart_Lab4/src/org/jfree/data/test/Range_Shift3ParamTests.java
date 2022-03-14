package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_Shift3ParamTests {
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
	 * This test will be used to test what happens when a range is shifted by a
	 * positive amount when allowZeroCrossing is true. We are only checking the
	 * upper bound of the range.
	 */
	@Test
	public void shiftByPositiveAllowZero() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, 158, true);
		assertEquals("The shifted value should be ", 164, testShiftedRange.getUpperBound(), .000000001d);
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * positive amount when allowZeroCrossing is false and value is less than zero.
	 * We are only checking the upper bound of the range.
	 */
	@Test
	public void shiftWithNoZeroCrossingValueLessThanZero() {
		testRange1 = new Range(-1, 6);
		Range testShiftedRange = Range.shift(testRange1, 158, false);
		assertEquals("The shifted value should be ", 164, testShiftedRange.getUpperBound(), .000000001d);
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * positive amount when allowZeroCrossing is false and value is equal zero. We
	 * are only checking the upper bound of the range.
	 */
	@Test
	public void shiftWithNoZeroCrossingValueEqualZero() {
		testRange1 = new Range(0, 6);
		Range testShiftedRange = Range.shift(testRange1, 158, false);
		assertEquals("The shifted value should be ", 164, testShiftedRange.getUpperBound(), .000000001d);
	}
	

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * negative amount where the range will now have a negative coordinate. We are
	 * only checking the upper bound of the range.
	 */
	@Test
	public void shiftByNegativeDoubleToGetNegativeValueUpperBound() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, -6.8, true);
		assertEquals("The value for the upper bound is incorrect.", -0.8, testShiftedRange.getUpperBound(),
				.000000001d);
	}

	/**
	 * This test will be used to test what happens when a range is shifted by a
	 * negative amount where the range will now have a negative coordinate. We are
	 * only checking the lower bound of the range.
	 */
	@Test
	public void shiftByNegativeDoubleToGetNegativeValueLowerBound() {
		testRange1 = new Range(2, 6);
		Range testShiftedRange = Range.shift(testRange1, -2.2, true);
		assertEquals("The value for the lower bound is incorrect.", -0.2, testShiftedRange.getLowerBound(),
				.000000001d);
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
