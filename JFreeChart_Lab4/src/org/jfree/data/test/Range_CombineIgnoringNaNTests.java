package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Range_CombineIgnoringNaNTests {
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
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a null range1 and a not null, non-NaN range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1Null_Range2NotNull() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(null, testRange1); // combine a null range1 and not null range2
		assertEquals("The returned object should be Range(2,6)", returnRange, testRange1);
		// assertion that expected value matches the actual value Range(2,6)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a null range1 and a not null, NaN range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1Null_Range2NaN() {
		double NaNParam = Math.sqrt(-1); // creating a not-a-number to be used as parameters
		testRange1 = new Range(NaNParam, NaNParam); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(null, testRange1); // combine a null range1 and not null, NaN range2
		assertNull("The return value should be null", returnRange);
		// assertion that expected value matches the actual value (null)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a null range1 and a null range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1Null_Range2Null() {
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(null, null); // combine a null range1 and null range2
		assertNull("The return value should be null", returnRange);
		// assertion that expected value matches the actual value (null)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a null, NaN range1 and a null range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1NaN_Range2Null() {
		double NaNParam = Math.sqrt(-1); // creating a not-a-number to be used as parameters
		testRange1 = new Range(NaNParam, NaNParam); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, null); // combine a not null, NaN range1 and null range2
		assertNull("The return value should be null", returnRange);
		// assertion that expected value matches the actual value (null)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a non-null, non-NaN range1 and a null range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1NotNull_Range2Null() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, null); // combine a not null range1 and null range2
		assertEquals("The return value should be Range(2,6)", returnRange, testRange1);
		// assertion that expected value matches the actual Range(2,6)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a non-null, non-NaN range1 and a non-null, non-NaN range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1NotNull_Range2NotNull_NoNaN() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		Range testRange2 = new Range(4, 7);
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, testRange2); // combine a not null, NaN range1 null range2
		assertEquals("The return value should be Range(2,7)", returnRange, new Range(2, 7));
		// assertion that expected value matches the actual Range(2,7)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a non-null, NaN range1 and a non-null, NaN range2.
	 */
	@Test
	public void combineIgnoringNaN_Range1NotNull_Range2NotNull_AllNaN() {
		double NaNParam1 = Math.sqrt(-1); // creating a not-a-number to be used as parameters
		double NaNParam2 = Math.sqrt(-2);
		testRange1 = new Range(NaNParam1, NaNParam2); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, testRange1); // combine a not null, NaN range1 null range2
		assertNull("The return value should be null", returnRange);
		// assertion that expected value matches the actual value (null)
	}

	/**
	 * This test will be testing the combineIgnoringNaN function. We will be testing
	 * a minimum NaN value, meaning that the lower parameter for range1 and range2
	 * is NaN.
	 */
	@Test
	public void combineIgnoringNaN_NaNMinRange() {
		double NaNParam1 = Math.sqrt(-1); // creating a not-a-number to be used as parameters
		double NaNParam2 = Math.sqrt(-2);
		testRange1 = new Range(NaNParam1, NaNParam2); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, new Range(NaNParam1, 4)); // combine a not null, NaN range1
																						// null range2
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
