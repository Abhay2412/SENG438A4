package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_ContainsTests {
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
	 * This test will be testing the contains function. We will be using a value
	 * within the range for this test.
	 */
	@Test
	public void containsValueWithinRange() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		boolean testBool = testRange1.contains(3); // Seeing if range (2, 6) contains the value 3
		assertTrue("The expected output should be true", testBool);
		// assertion that expected value matches the actual value (true)
	}

	/**
	 * This test will be testing the contains function. We will be using a value
	 * outside the lower range for this test.
	 */
	@Test
	public void containsValueOutsideRangeLower() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		boolean testBool = testRange1.contains(0); // Seeing if range (2, 6) contains the value 0
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (false)
	}

	/**
	 * This test will be testing the contains function. We will be using a value
	 * outside the upper range for this test.
	 */
	@Test
	public void containsValueOutsideRangeHigher() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		boolean testBool = testRange1.contains(8); // Seeing if range (2, 6) contains the value 8
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
