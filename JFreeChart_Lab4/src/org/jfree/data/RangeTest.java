package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

/**
 * 
 * @author Group 21 (Lauraine Baffot, Alexis Hamrak, Abhay Khosla, Rachel
 *         Renegado). Class in which is for testing the methods of the Range
 *         Class Using boundaries and edge cases to create the following test
 *         cases for each method.
 *
 */
public class RangeTest {
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

	@Test
	public void centralValueShouldBeZero() {
		// This is testing the centralValue function which checks what the value between
		// the range is.
		assertEquals("The central value of -1 and 1 should be 0", 0, exampleRange.getCentralValue(), .000000001d);
		// assertion that expected value matches the actual value (0)
	}
	// -----------------------------------------------------------------------------------------
	// End of Lab Document Code
	// -----------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------
	// Code created by Abhay and Rachel
	// -----------------------------------------------------------------------------------------
	/* Abhay codes and Rachel Reviews */
	// ------------- expand(Range range, double lowerMargin, double upperMargin)
	// Tests -----------

	/**
	 * This test will simulate creating expand a null range. This test should throw
	 * an exception.
	 */
	@Test
	public void expandNull() {
		try {
			Range nullRange = null; // creating a null range
			testExpandRange = Range.expand(nullRange, 0.25, 0.5); // trying to expand the null range
			fail("This method should throw an exception!");
			// creating a failure message for if expand does not throw an
			// exception
		} catch (Exception e) {
			assertEquals("The exception thrown type is IllegalArgumentException", IllegalArgumentException.class,
					e.getClass());
			// catching the exception, asserting that an IllegalArgumentException was thrown
		}
	}

	/**
	 * This test will simulate expanding the range by 0.25 and 0.5 - asserting that
	 * the lower margin will be expanded to be 1.
	 */
	@Test
	public void expandTestLowerMarginInt() { // This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the lower bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.25, 0.5); // Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The lower margin range will be 1", 1, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (1)
	}

	/**
	 * This test will simulate expanding the range by 0.25 and 0.5 - asserting that
	 * the upper margin will be expanded to be 8.
	 */
	@Test
	public void expandTestUpperMarginInt() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.25, 0.5);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be 8", 8, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (8)
	}

	/**
	 * This test will simulate expanding the range by 1.25 and 1.5 - asserting that
	 * the upper margin will be expanded to be 12.
	 */
	@Test
	public void expandTestUpperMarginOverOne() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 1.25, 1.5);// Using the expand method to pass in the test
		// range and the margin values which are greater than 1.
		assertEquals("The upper margin range will be 12", 12, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (12)
	}

	/**
	 * This test will simulate expanding the range by -0.24 and -0.50 - asserting
	 * that the upper margin will be shrink to be 4.
	 */
	@Test
	public void expandTestUpperMarginLessOne() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as an
		// integer.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, -0.24, -0.5);// Using the expand method to pass in the test
		// range and the margin values which are less than 0.
		assertEquals("The upper margin range will be 4", 4, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (4)
	}

	/**
	 * This test will simulate expanding the range by 0.33 and 0.44 - asserting that
	 * the lower margin will be expanded to be 0.68.
	 */
	@Test
	public void expandTestLowerMarginDecimal() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the lower bound as a
		// decimal.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.33, 0.44);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The lower margin range will be 0.68", 0.68, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.68)
	}

	/**
	 * This test will simulate expanding the range by 0.33 and 0.44 - asserting that
	 * the upper margin will be expanded to be 7.76.
	 */
	@Test
	public void expandTestUpperMarginDecimal() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as a
		// decimal.
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.33, 0.44);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be 7.76", 7.76, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (7.76)
	}

	/**
	 * This test will simulate that if we pass in an expansion of zero in the
	 * parameters there should be an exception thrown.
	 */
	@Test
	public void expandTestWithZero() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which are all 0.
		try {
			testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
			testExpandRange = Range.expand(testRange1, 0, 0);// Using the expand method to pass in the test
			assertEquals("The new range after the expansion of zero was different than orginal.", testRange1,
					testExpandRange);
		} catch (Exception e) {
			fail("Expanding it by zero threw an exception");
		}
		// The assert checks for the exception which is being thrown.
	}

	/**
	 * This test will simulate expanding the range by 0.44 and 0.33 - asserting that
	 * the upper margin will be expanded to be -0.68.
	 */
	@Test
	public void expandTestUpperMarginNegativeRange() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as a
		// decimal.
		testRange1 = new Range(-6, -2); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, 0.44, 0.33);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be -0.68", -0.68, testExpandRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-0.68)
	}

	/**
	 * This test will simulate expanding the range by -0.29 and -0.35 - asserting
	 * that the lower margin will be expanded to be -4.84.
	 */
	@Test
	public void expandTestUpperMarginNegativeMargins() {// This is created the see if the range will change or not.
		// Using the margin value in percentages which will return the upper bound as a
		// decimal.
		testRange1 = new Range(-6, -2); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, -0.29, -0.35);// Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The upper margin range will be -4.84", -4.84, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (-4.84)
	}

	/* Rachel codes and Abhay Reviews */
	// ------------- expandToInclude(Range range, double value) Tests -----------

	/**
	 * This test will simulate creating expandToInclude with a null range. This test
	 * should result in a lower range of the included value (1).
	 */
	@Test
	public void expandToIncludeNullLower() {
		Range nullRange = null; // creating a null range
		Range newRange = Range.expandToInclude(nullRange, 1);
		// trying to expand the null range to include 1
		assertEquals("The lower value will be 1", 1, newRange.getLowerBound(), .000000001d);
		// assertion that expected lower bound matches 1
	}

	/**
	 * This test will simulate creating expandToInclude with a null range. This test
	 * should result in a upper range of the included value (1).
	 */
	@Test
	public void expandToIncludeNullUpper() {
		Range nullRange = null; // creating a null range
		Range newRange = Range.expandToInclude(nullRange, 1);
		// trying to expand the null range to include 1
		assertEquals("The upper value will be 1", 1, newRange.getUpperBound(), .000000001d);
		// assertion that expected upper bound matches 1
	}

	/**
	 * This test will simulate expanding a range of 4 and 6 to include the value 5 -
	 * asserting that the upper margin will remain the same and be 6.
	 */
	@Test
	public void expandToInlcudeInsideRangeUpper() { // This test is for testing the expanding the range
		// which will include 5 in the range and making sure the upper value bound is
		// still the same.
		Range tempRange = Range.expandToInclude(new Range(4, 6), 5); // This is creating the test range for this test.
		assertEquals("The upper value will be 6", 6, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (6)
	}

	/**
	 * This test will simulate expanding a range of 4 and 6 to include the value 5 -
	 * asserting that the lower margin will remain the same and be 4.
	 */
	@Test
	public void expandToInlcudeInsideRangeLower() {// This test is for testing the expanding the range
		// which will include 5 in the range and making sure the lower value bound is
		// still the same.
		Range tempRange = Range.expandToInclude(new Range(4, 6), 5);// This is creating the test range for this test.
		assertEquals("The upper value will be 4", 4, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (4)
	}

	/**
	 * This test will simulate expanding a range of 0.4 and 5.7 to include the value
	 * 11.2 - asserting that the upper margin will expand to be 11.2.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeUpper() { // This test is for testing the expanding the range
		// which will include 5.7 in the range and making sure the upper value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(0.4, 5.7), 11.2);// This is creating the test range for this
																			// test.
		assertEquals("The upper value will be 11.2", 11.2, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (11.2)
	}

	/**
	 * This test will simulate expanding a range of 0.4 and 5.7 to include the value
	 * 7 - asserting that the lower margin will remain the same of 0.4.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeLower() { // This test is for testing the expanding the range
		// which will include 5.7 in the range and making sure the lower bound remains
		// the same.
		Range tempRange = Range.expandToInclude(new Range(0.4, 5.7), 11.2);// This is creating the test range for this
																			// test.
		assertEquals("The lower value should remain the same and be 0.4", 0.4, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.4)
	}

	/**
	 * This test will simulate expanding a range of 1.6 and 2.6 to include the value
	 * 0.5 - asserting that the upper margin will remain the same of 2.6.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeUpper() {// This test is for testing the expanding the range
		// which will include 0.5 in the range and making sure the upper bound will
		// remain the same.
		Range tempRange = Range.expandToInclude(new Range(1.6, 2.6), 0.5);// This is creating the test range for this
																			// test.
		assertEquals("The lower value will be 2.6", 2.6, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (2.6)
	}

	/**
	 * This test will simulate expanding a range of 1.6 and 2.6 to include the value
	 * 0.5 - asserting that the upper margin will expand to be 0.5.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeLower() {// This test is for testing the expanding the range
		// which will include 0.5 in the range and making sure the lower value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(1.6, 2.6), 0.5);// This is creating the test range for this
																			// test.
		assertEquals("The lower value will be 0.5", 0.5, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.5)
	}

	/**
	 * This test will simulate expanding a range of -4.4 and -6.4 to include the
	 * value -5.4 - asserting that the upper margin will remain the same and be
	 * -4.4.
	 */
	@Test
	public void expandToInlcudeInsideRangeUpperNegative() { // This test is for testing the expanding the range
		// which will include -5 in the range and making sure the upper value bound
		// remains the same.
		Range tempRange = Range.expandToInclude(new Range(-6.4, -4.4), -5.4); // This is creating the test range for
																				// this test.
		assertEquals("The upper value will be -4.4", -4.4, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-4.4)
	}

	/**
	 * This test will simulate expanding a range of -4 and -6 to include the value
	 * -5 - asserting that the lower margin will remain the same and be -6.
	 */
	@Test
	public void expandToInlcudeInsideRangeLowerNegative() {// This test is for testing the expanding the range
		// which will include -5 in the range and making sure the lower value bound
		// remains the same.
		Range tempRange = Range.expandToInclude(new Range(-6, -4), -5);// This is creating the test range for this test.
		assertEquals("The lower value will be -6", -6, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (-4)
	}

	/**
	 * This test will simulate expanding a range of -0.4 and -5.7 to include the
	 * value 11.2 - asserting that the upper margin will remain the same of -0.4.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeUpperNegative() { // This test is for testing the expanding the range
		// which will include -5.7 in the range and making sure the upper bound remains
		// the same.
		Range tempRange = Range.expandToInclude(new Range(-5.7, -0.4), -11.2);// Creating the test range for this test.
		assertEquals("The upper value will be -0.4", -0.4, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-0.4)
	}

	/**
	 * This test will simulate expanding a range of -0.4 and -5.7 to include the
	 * value 7 - asserting that the lower margin will expand to be -11.2.
	 */
	@Test
	public void expandToInlcudeOutsideUpperRangeLowerNegative() { // This test is for testing the expanding the range
		// which will include -5.7 in the range and making sure the lower value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(-5.7, -0.4), -11.2);// Creating the test range for this test.
		assertEquals("The lower value should remain the same and be -11.2", -11.2, tempRange.getLowerBound(),
				.000000001d);
		// assertion that expected value matches the actual value (-11.2)
	}

	/**
	 * This test will simulate expanding a range of -1.6 and -2.6 to include the
	 * value 0.5 - asserting that the upper margin will remain the same of -2.6.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeLowerNegative() {// This test is for testing the expanding the range
		// which will include -0.5 in the range and making sure the lower bound will
		// remain the same.
		Range tempRange = Range.expandToInclude(new Range(-2.6, -1.6), -0.5);// This is creating the test range for this
																				// test.
		assertEquals("The lower value will be -2.6", -2.6, tempRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (-2.6)
	}

	/**
	 * This test will simulate expanding a range of -1.6 and -2.6 to include the
	 * value 0.5 - asserting that the upper margin will expand to be -0.5.
	 */
	@Test
	public void expandToInlcudeOutsideLowerRangeUpperNegative() {// This test is for testing the expanding the range
		// which will include -0.5 in the range and making sure the upper value bound
		// reflects the updated range.
		Range tempRange = Range.expandToInclude(new Range(-2.6, -1.6), -0.5);// This is creating the test range for this
																				// test.
		assertEquals("The lower value will be -0.5", -0.5, tempRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value (-0.5)
	}
	// -----------------------------------------------------------------------------------------
	// End of code by Abhay and Rachel
	// -----------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------
	// Code written by Alexis and Lauraine
	// -----------------------------------------------------------------------------------------
	/* Alexis codes and Lauraine reviews */

	// ------------- combine(Range range1, Range range2) Tests ---------------------

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

	// ------------- getLength() Tests ---------------------

	/**
	 * This test will be used to test the length of a range when it should be zero.
	 */
	@Test
	public void testGetLengthZero() {
		Range tempRange = new Range(1, 1); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 0.0 and it is " + length, 0.0, length, .000000001d);
		// assertion that expected value matches the actual value (0.0)
	}

	/**
	 * This test will be used to test the length of an extremely large positive
	 * range
	 */
	@Test
	public void testGetLengthLargePositive() {
		Range tempRange = new Range(2, 200000000); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 199,999,998 and it is " + length, 199999998.0, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of an extremely large negative
	 * range
	 */
	@Test
	public void testGetLengthLargeNegative() {
		Range tempRange = new Range(-200000000, -2); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 199,999,998 and it is " + length, 199999998.0, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of a range composed of two decimal
	 * numbers
	 */
	@Test
	public void testGetLengthRangeIsDecimal() {
		Range tempRange = new Range(-200.03, 200.50); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 400.53 and it is " + length, 400.53, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of a range composed of no decimals
	 */
	@Test
	public void testGetLengthRangeIsNonDecimal() {
		Range tempRange = new Range(-30, 35); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 65 and it is " + length, 65, length, .000000001d);
		// assertion that expected value matches the actual value
	}

	/**
	 * This test will be used to test the length of a range composed of a decimal
	 * and an integer
	 */
	@Test
	public void testGetLengthRangeMixedDecimal() {
		Range tempRange = new Range(-200.03, 200); // create a new Range object
		double length = tempRange.getLength(); // calculate the length of the range
		assertEquals("The length should be 400.03 and it is " + length, 400.03, length, .000000001d);
	}

	/* Lauraine codes and Alexis reviews */

	// ------------- shift(Range base, double delta) Tests ---------------------

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
	// -----------------------------------------------------------------------------------------
	// End of code by Alexis and Lauraine
	// -----------------------------------------------------------------------------------------

	// ---------------------START OF LAB 3 CODE----------------------

	// -----------------------------------------------------------------------------------------
	// Code written by Alexis and Rachel
	// -----------------------------------------------------------------------------------------

	// ------ tests for Range constructor------
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

	// ------ tests for contains------
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

	// ------ tests for intersects------
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

	// ------ tests for constrain------
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

	// ------ tests for combineIgnoringNaN------

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

	// ------ tests for min and max------
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

	// ------ tests for expand------
	/**
	 * This test will be testing the expand function where the double value lower is
	 * greater than upper.
	 */
	@Test
	public void expandLowerGreaterThanUpper_Lower() {
		testRange1 = new Range(1, 2); // This is creating the range for testing purposes.
		testExpandRange = Range.expand(testRange1, -0.9, -0.9); // Using the expand method to pass in the test
		// range and the margin values
		assertEquals("The lower margin range will be 1.5", 1.5, testExpandRange.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value (0.7)
	}

	// -------- Range shift(Range base, double delta,boolean allowZeroCrossing)
	// Tests ----------
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

	// -------- scale(Range base, double factor) Tests ----------
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

	// -----------------------------------------------------------------------------------------
	// End of code by Alexis and Rachel
	// -----------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------
	// Start of Lab 4
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	// Start of Lauraine and Alexis Mutation Code
	// -----------------------------------------------------------------------------------------

	// ------------- tests for getCentralValue() --------------------
	@Test
	public void getCentralValuePositive() {
		testRange1 = new Range(4, 8);
		assertEquals("The central value is wrong.", 6, testRange1.getCentralValue(), .000000001d);
	}

	// ---------------- tests for contains(double value) ----------------
	@Test
	public void containsValueOnLowerBound() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		boolean testBool = testRange1.contains(2); // Seeing if range (2, 6) contains the value 2
		assertTrue("The expected output should be true", testBool);
		// assertion that expected value matches the actual value (true)
	}

	@Test
	public void containsValueOnUpperBound() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		boolean testBool = testRange1.contains(6); // Seeing if range (2, 6) contains the value 6
		assertTrue("The expected output should be true", testBool);
		// assertion that expected value matches the actual value (true)
	}
	/**
	 * This test will be testing the intersects function. We will be testing to see if the decremented mutant will
	 * create a failure in the test case.
	 */
	@Test
    	public void containsDecrement() {
        	testRange1 = new Range(5, 6);
        	boolean returned = testRange1.contains(5);
        	assertTrue("The range was false when it should be true", returned);
    	}

	// ------------- tests for intersects(double b0, double b1) -------------
	/**
	 * This test will be testing the intersects function. We will be testing to see if the range intersects with two given points,
	 * and in this case it should not.
	 */
	@Test
	public void intersectsLowerBoundRangeEqualsUpperBound() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 1;
		double upperBound = 2;
		boolean testBool = testRange1.intersects(lowerBound, upperBound); // Seeing if range (2, 6) intersects with (1,
																			// 2)
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (false)
	}
	/**
	 * This test will be testing the intersects function. We will be testing to see if the range intersects with two given points,
	 * and in this case it should not.
	 */
	@Test
	public void intersectsUpperBoundRangeEqualsLowerBound() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 6;
		double upperBound = 7;
		boolean testBool = testRange1.intersects(lowerBound, upperBound); // Seeing if range (2, 6) intersects with (6,
																			// 7)
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (false)
	}
	/**
	 * This test will be testing the intersects function. We will be testing to see if the lower boundary condition is 
	 * found to intersect with the given range of (2,3)
	 */
	@Test
    	public void intersectsBoundary() {
        	//boundary line 157
        	testRange1 = new Range(2, 3);
        	boolean returned = testRange1.intersects(2, 2);
        	assertFalse("The range was true when it should be false", returned);
    	}
	/**
	 * This test will be testing the intersects function. We will be testing to see if an increment mutation
	 * will change the output.
	 */
    	@Test
    	public void intersectsIncrement() {
        	//increment line 158 (++a should be false)
        	testRange1 = new Range(2, 3);
        	boolean returned = testRange1.intersects(2, 2);
        	assertFalse("The range was true when it should be false", returned);
    	}
	/**
	 * This test will be testing the intersects function. We will be testing to see if a decrement mutation
	 * will change the output.
	 */
    	@Test
    	public void intersectsDecrement() {
        	testRange1 = new Range(2, 3);
        	boolean returned = testRange1.intersects(2, 3);
        	assertTrue("The range was false when it should be true", returned);
    	}

	// ------- tests for intersects(Range range) ------------
	/**
	 * This test will be testing the intersects function. We will be testing to see if the range intersects with 
	 * a range that is higher. This case will return false.
	 */
	@Test
	public void intersectsRangeIsFalse() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		double lowerBound = 7;
		double upperBound = 9;
		Range testRange2 = new Range(lowerBound, upperBound);
		boolean testBool = testRange1.intersects(testRange2); // Seeing if range (2, 6) intersects with (7, 9)
		assertFalse("The expected output should be false", testBool);
		// assertion that expected value matches the actual value (true)
	}

	// ------- tests for double min(double d1, double d2) ------------
	/**
	 * This test will be testing the min function. We will be testing to see if the min function performs as it should
	 * with the mutations. 
	 */
	@Test
	public void minTest_combineIgnoringNaN_returnsLowerBound() {
		double NaNParam1 = Math.sqrt(-1); // creating a not-a-number to be used as parameters
		double NaNParam2 = Math.sqrt(-2);
		testRange1 = new Range(1, 4); // This is creating the range for testing purposes.
		Range returnRange;
		returnRange = Range.combineIgnoringNaN(testRange1, new Range(NaNParam1, NaNParam2)); // will make a call to both
																								// min and max with d2
																								// as a NaN value
		assertEquals("The return value should be 1", returnRange.getLowerBound(), 1, .000000001d);
		// assertion that expected value matches the actual value of 4
	}

	// ------- tests for double scale(Range base, double factor) ------------
	/**
	 * This test will be testing the scale function. We will be testing to see if the upper bound of the 
	 * range matches the correct location after it is scaled. 
	 */
	@Test
	public void scalePositiveRangeZeroFactor() {
		testRange1 = new Range(2, 6);
		Range testScale = Range.scale(testRange1, 0);
		assertEquals("The shifted value should be ", 0, testScale.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value of 0
	}

	/**
	 * This test will be testing the scale function. We will be testing to see if the upper bound of the 
	 * range matches the correct location after it is scaled. 
	 */
	@Test
	public void scalePositiveRangePositiveFactorLowerBound() {
		testRange1 = new Range(2, 6);
		Range testScale = Range.scale(testRange1, 2);
		assertEquals("The shifted value should be ", 4, testScale.getLowerBound(), .000000001d);
		// assertion that expected value matches the actual value of 4
	}

	// -- tests for double shiftWithNoZeroCrossing(double value, double delta) ---
	/**
	 * This test will be testing the shift function. We will be testing to see if the upper bound of the 
	 * range matches the correct location after it is shifted. The range values will both be 0 for this test. 
	 */
	@Test
	public void shiftWithNoZeroCrossingWhereValueEqualsZero() {
		testRange1 = new Range(0, 0);
		Range testShiftedRange = Range.shift(testRange1, 158, false);
		assertEquals("The shifted value should be ", 158, testShiftedRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value of 158
	}

	/**
	 * This test will be testing the shift function. We will be testing to see if the upper bound of the 
	 * range matches the correct location after it is shifted. The range values will be negative for this test
	 */
	@Test
	public void shiftWithNoZeroCrossingWhereValueIsNegative() {
		testRange1 = new Range(-2, -1);
		Range testShiftedRange = Range.shift(testRange1, -158, false);
		assertEquals("The shifted value should be ", -159, testShiftedRange.getUpperBound(), .000000001d);
		// assertion that expected value matches the actual value of -159
	}

	// ----------- tests for equals(Object obj) ----------------
	/**
	 * This test will be testing the equals function. We will be testing a null range to see if it 
	 * returns false when compared to a range object that is not null.
	 */
	@Test
	public void equalsParameterIsNotARangeObjec() {
		testRange1 = new Range(2, 6);
		boolean testEqualRanges = testRange1.equals(null);
		assertFalse("These Range objects are equal.", testEqualRanges);
		// assertion that expected value is false
	}

	/**
	 * This test will be testing the equals function. We will be testing to see if the two Range objects are 
	 * equal and in this case, they are not equal.
	 */
	@Test
	public void equalsDifferentLowerBound() {
		testRange1 = new Range(2, 6);
		boolean testEqualRanges = testRange1.equals(new Range(3, 6));
		assertFalse("These Range objects are equal.", testEqualRanges);
		// assertion that expected value is false
	}

	/**
	 * This test will be testing the equals function. We will be testing to see if two Range objects are equal
	 * and in this case, the range objects are not equal.
	 */
	@Test
	public void equalsDifferentUpperBound() {
		testRange1 = new Range(2, 6);
		boolean testEqualRanges = testRange1.equals(new Range(2, 5));
		assertFalse("These Range objects are equal.", testEqualRanges);
		// assertion that expected value is false
	}

	// ----------- tests for hashCode() ----------------
	/**
	 * This test will be testing the hashCode function. We will be testing to see if the created hashCode
	 * is correct.
	 */
	@Test
	public void hashCodeTest() {
		testRange1 = new Range(2, 6);
		int testHashCodeResult = testRange1.hashCode();
		assertEquals("This hashcode is incorrect.", -2145910784, testHashCodeResult);
		// assertion that expected value matches the actual value of -2145910784
	}

	// ------- tests for double toString() ------------
	/**
	 * This test will be testing the toString function. We will be testing to see if the string 
	 * produced is the range itself.
	 */
	@Test
	public void toStringTest() {
		testRange1 = new Range(2, 6); // This is creating the range for testing purposes.
		String message = testRange1.toString();
		assertEquals("The string is wrong.", message, "Range[2.0,6.0]");
		// assertion that expected value matches the actual value of Range[2.0,6.0]
	}

	// ------- tests for constrain -------
	/**
	 * This test will be testing the constrain function. We will be testing a value
	 * that is on the lower boundary of the range.
	 */
    	@Test
    	public void constrainDecrement() {
        	testRange1 = new Range(1, 4);
        	double returned = testRange1.constrain(1);
        	assertEquals("The constrained value should be ", 1, returned, .000000001d);
		// assertion that expected value matches the actual value of 1
    	}

	// -----------------------------------------------------------------------------------------
	// End of Lauraine and Alexis Mutation Code
	// -----------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------------------------
	// The following code was taken from the SENG438 Lab Document
	// -----------------------------------------------------------------------------------------
	@After
	public void tearDown() throws Exception {
		// Tear down function for after running the tests it does nothing.
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Do nothing once the class is over running the cases in the SUT
	}
	// -----------------------------------------------------------------------------------------
	// End of SENG438 Lab Document Code
	// -----------------------------------------------------------------------------------------

}
