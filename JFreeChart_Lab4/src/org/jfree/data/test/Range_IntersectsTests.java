package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_IntersectsTests {
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
	 * This test will be testing the intersects function. We will be testing a range
	 * and a set of points that should intersect with each other, where b1 is
	 * greater than the second parameter of the test Range object
	 */
	@Test
	public void intersectsRangeIsTrue_SecondParamGreater() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 1;
		double upperBound = 7;
		Range testRange2 = new Range(lowerBound, upperBound);
		boolean testBool = testRange1.intersects(testRange2); // Seeing if range (2, 6) intersects with (1, 7)
		assertTrue("The expected output should be true", testBool);
		// assertion that expected value matches the actual value (true)
	}

	/**
	 * This test will be testing the intersects function. We will be testing a range
	 * and a set of points that should not intersect with each other, where both of
	 * the test values are lower than the range object
	 */
	@Test
	public void intersectsRangeIsFalse_BothParamLess() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 0;
		double upperBound = 1;
		boolean testBool = testRange1.intersects(lowerBound, upperBound); // Seeing if range (2, 6) intersects with (0,
																			// 1)
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (false)
	}

	/**
	 * This test will be testing the intersects function. We will be testing a range
	 * and a set of points that should intersect with each other.
	 */
	@Test
	public void intersectsRangeIsTrue_BothParamInsideRange() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 3;
		double upperBound = 3;
		boolean testBool = testRange1.intersects(lowerBound, upperBound); // Seeing if range (2, 6) intersects with (3,
																			// 3)
		assertTrue("The expected output should be true", testBool);
		// assertion that expected value matches the actual value (true)
	}

	/**
	 * This test will be testing the intersects function. We will be testing a range
	 * and a set of points that should not intersect with each other.
	 */
	@Test
	public void intersectsRangeIsFalse_BothParamGreater() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 7;
		double upperBound = 10;
		boolean testBool = testRange1.intersects(lowerBound, upperBound); // Seeing if range (2, 6) intersects with (7,
																			// 10)
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (false)
	}

	/**
	 * This test will be testing the intersects function. We will be testing a range
	 * and a set of points that should not intersect with each other.
	 */
	@Test
	public void intersectsRangeIsFalse_B0LessThanUpperAndB1LessThanB0() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 5;
		double upperBound = 4;
		boolean testBool = testRange1.intersects(lowerBound, upperBound); // Seeing if range (2, 6) intersects with (5,
																			// 4)
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (false)
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
