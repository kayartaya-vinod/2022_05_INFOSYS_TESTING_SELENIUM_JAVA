package com.edgeverve.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edgeverve.utils.MathUtils;

class MathUtilsTests {

	static final Logger log = LoggerFactory.getLogger(MathUtilsTests.class);

	MathUtils mu;
	
	@BeforeAll
	static void first() {
		log.trace("inside the MathUtilsTests.first()");

	}
	
	@AfterAll
	static void last() {
		log.trace("inside the MathUtilsTests.last()");
	}

	@BeforeEach
	void setup() {
		log.trace("inside the setup() method of MathUtilsTests.java");
		mu = new MathUtils();
	}

	@AfterEach
	void tearDown() {
		log.trace("inside the tearDown() method of MathUtilsTests.java");
	}
	
	@Test
	void shouldGetFactorialOf5() {
		log.trace("inside the shouldGetFactorialOf5() method of MathUtilsTests.java");
		long actual = mu.factorial(5);
		Assertions.assertEquals(120, actual);
	}

	@Test
	void shouldGetFactorialOfZero() {
		log.trace("inside the shouldGetFactorialOfZero() method of MathUtilsTests.java");
		long actual = mu.factorial(0);
		Assertions.assertEquals(1, actual);
	}

	@Disabled("Currently not handled")
	@Test
	void shouldGetFactorialOfMinusFive() {
		long actual = mu.factorial(-5);
		Assertions.assertEquals(-120, actual);
	}

}
