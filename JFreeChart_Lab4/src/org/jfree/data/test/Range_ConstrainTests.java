package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_ConstrainTests {
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
	 * This test will be testing the constrain function. We will be testing a value
	 * within the range.
	 */
	@Test
	public void constrainWithinRange() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double returnVal = testRange1.constrain(4); // Seeing if range (2, 6) has a constrained value with 4
		assertEquals("The value returned should be 4", 4, returnVal, .000000001d);
		// assertion that expected value matches the actual value (4)
	}

	/**
	 * This test will be testing the constrain function. We will be testing a value
	 * greater than the upper range.
	 */
	@Test
	public void constrainOutsideUpperRange() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double returnVal = testRange1.constrain(10); // Seeing if range (2, 6) has a constrained value with 10
		assertEquals("The value returned should be 6", 6, returnVal, .000000001d);
		// assertion that expected value matches the actual value (6)
	}

	/**
	 * This test will be testing the constrain function. We will be testing a value
	 * greater than the lower range.
	 */
	@Test
	public void constrainOutsideLowerRange() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double returnVal = testRange1.constrain(1); // Seeing if range (2, 6) has a constrained value with 1
		assertEquals("The value returned should be 2", 2, returnVal, .000000001d);
		// assertion that expected value matches the actual value (2)
	}

	/**
	 * This test will be testing the constrain function. We will be testing a value
	 * greater than the lower range.
	 */
	@Test
	public void constrainOutsideLowerRangeEqual() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double returnVal = testRange1.constrain(2); // Seeing if range (2, 6) has a constrained value with 2
		assertEquals("The value returned should be 2", 2, returnVal, .000000001d);
		// assertion that expected value matches the actual value (2)
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
