package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_CombineTests {
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
	 * This test will be used to test what happens when the first parameter entered
	 * is null. The second value (the other range) should be returned.
	 */
	@Test
	public void combineFirstParameterNullUpperBound() {
		Range tempRange = Range.combine(null, new Range(4, 8)); // combine our null range with a given range of (4, 8)
		double upperBound = tempRange.getUpperBound(); // get our new upper bound for the combined range
		assertEquals("The combined upper bound should be 8.0 and it is " + upperBound, 8.0, upperBound, .000000001d);
		// assertion that expected value matches the actual value (8.0)
	}

	/**
	 * This test will be used to test what happens when the first parameter entered
	 * is null. The second value (the other range) should be returned.
	 */
	@Test
	public void combineFirstParameterNullLowerBound() {
		Range tempRange = Range.combine(null, new Range(4, 8)); // combine our null range with a given range of (4, 8)
		double lowerBound = tempRange.getLowerBound(); // get our new lower bound for the combined range
		assertEquals("The combined lower bound should be 4.0 and it is " + lowerBound, 4.0, lowerBound, .000000001d);
		// assertion that expected value matches the actual value (4.0)
	}

	/**
	 * This test will be used to test what happens when the second parameter entered
	 * is null. The first value (the other range) should be returned.
	 */
	@Test
	public void combineSecondParameterNullUpperBound() {
		Range tempRange = Range.combine(new Range(-8, -2), null); // combine our null range with a given range of (-8,
																	// -2)
		double upperBound = tempRange.getUpperBound(); // get our new upper bound for the combined range
		assertEquals("The combined upper bound should be -2.0 and it is " + upperBound, -2.0, upperBound, .000000001d);
		// assertion that expected value matches the actual value (-2.0)
	}

	/**
	 * This test will be used to test what happens when the second parameter entered
	 * is null. The first value (the other range) should be returned.
	 */
	@Test
	public void combineSecondParameterNullLowerBound() {
		Range tempRange = Range.combine(null, new Range(-8, -2)); // combine our null range with a given range of (-8,
																	// -2)
		double lowerBound = tempRange.getLowerBound(); // get our new lower bound for the combined range
		assertEquals("The combined lower bound should be -8.0 and it is " + lowerBound, -8.0, lowerBound, .000000001d);
		// assertion that expected value matches the actual value (-8.0)
	}

	/**
	 * This test will be used to test what happens when both parameters are null.
	 * The return value should be null and thus throw a null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void combineBothParametersNullUpperBound() {
		Range tempRange = Range.combine(null, null); // combine our null range with a given range of (null, null)
		double upperBound = tempRange.getUpperBound(); // get our new upper bound for the combined range
		assertNull("The combined upper bound should be null", upperBound);
		// assertion that expected value matches the actual value (null)
	}

	/**
	 * This test will be used to test what happens when both parameters are null.
	 * The return value should be null and thus throw a null pointer exception
	 */
	@Test(expected = NullPointerException.class)
	public void combineBothParametersNullLowerBound() {
		Range tempRange = Range.combine(null, null); // combine our null range with a given range of (null, null)
		double lowerBound = tempRange.getLowerBound(); // get our new lower bound for the combined range
		assertNull("The combined lower bound should be null", lowerBound);
		// assertion that expected value matches the actual value (null)
	}

	/**
	 * This test will be used to test what happens when no parameters are null. A
	 * new range should be created from the combination of the two input ranges.
	 */
	@Test
	public void combineNoParametersNullUpperBound() {
		Range tempRange = Range.combine(new Range(1, 10), new Range(-8, -2)); // combine two ranges of (1, 10) and (-8,
																				// -2)
		double upperBound = tempRange.getUpperBound(); // get our new upper bound for the combined range
		assertEquals("The combined upper bound should be 10.0 and it is " + upperBound, 10.0, upperBound, .000000001d);
		// assertion that expected value matches the actual value (10.0)
	}

	/**
	 * This test will be used to test what happens when no parameters are null. A
	 * new range should be created from the combination of the two input ranges.
	 */
	@Test
	public void combineNoParametersNullLowerBound() {
		Range tempRange = Range.combine(new Range(1, 10), new Range(-8, -2)); // combine two ranges of (1, 10) and (-8,
																				// -2)
		double lowerBound = tempRange.getLowerBound(); // get our new lower bound for the combined range
		assertEquals("The combined lower bound should be -8.0 and it is " + lowerBound, -8.0, lowerBound, .000000001d);
		// assertion that expected value matches the actual value (-8.0)
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
