package com.edgeverve.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.edgeverve.utils.MathUtils;

class MathUtilsSumTests {

	MathUtils mu;

	@BeforeEach
	void init() {
		mu = new MathUtils();
	}

	@Test
	void shouldAddTwoNumbers() {
		String input = "10, 20";
		long expected = 30;
		long actual = mu.sum(input);
		assertEquals(expected, actual);
	}

	@Test
	void shouldAddNumbersWithDifferentWhiteSpaces() {
		String input = "10,\n20,\t30,   40,50";
		long expected = 150;
		long actual = mu.sum(input);
		assertEquals(expected, actual);
	}

	@Test
	void shouldAddNegativeNumbers() {
		String input = "-10, -20";
		long expected = -30;
		long actual = mu.sum(input);
		assertEquals(expected, actual);
	}

	@Test
	void shouldThrowNullPointerExceptionForNullInput() {
		// not the best way to handle exceptional scenarios
		try {
			mu.sum(null);
			fail("Was expecting a NullPointerException; but didn't catch one!");
		} catch (NullPointerException e) {
			// test passes; nothing to be done here.
			// Exception ducking!
		} catch (Exception e) {
			fail("Wasn't expecting this exception - " + e.getClass().getName());
		}
	}

	@Test
	void shouldThrowNumberFormatExceptionForNonNumericalInputs() {
		String input = "10, 20, Vinod, 30, Kumar, 40";

		assertThrows(NumberFormatException.class, () -> mu.sum(input));
	}
}
