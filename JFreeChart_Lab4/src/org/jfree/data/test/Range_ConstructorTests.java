package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Range_ConstructorTests {
	private Range testRange1; // Created this range to test other functionalities of the test range.
	// The following code was taken from the SENG438 Lab Document
	// -----------------------------------------------------------------------------------------
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// This calls the setUpBefore even the class exists and does nothing.
	}
	
	/**
	 * This test will try to create a Range object where the lower bound is greater
	 * than the upper bound
	 */
	@Test(expected = IllegalArgumentException.class)
	public void constructorLowerBoundGreater() {
		testRange1 = new Range(6, 2);
		assertEquals("The lower bound value should be null", testRange1);
		// the test should throw an IllegalArgumentException because the lower bound
		// should be on the left hand side of the argument.
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
