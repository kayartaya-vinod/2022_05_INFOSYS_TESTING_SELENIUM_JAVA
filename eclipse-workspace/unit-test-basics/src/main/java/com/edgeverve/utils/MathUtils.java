package com.edgeverve.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {

	static final Logger log = LoggerFactory.getLogger(MathUtils.class.getName());

	/**
	 * This function accepts a String consisting of 0 or more numbers separated by
	 * comma. The String may or may not contain non numeric values as well.
	 * 
	 * @param input - comma delimited numbers in String format
	 * @return sum of all numerical values in the string input
	 * @throws NumberFormatException if the input contains non numerical values other than white spaces
	 * @throws NullPointerException if the input is a null value
	 */
	public long sum(String input) throws NumberFormatException, NullPointerException {
		long total = 0;

		String[] data = input.split(",");
		for (String num : data) {
			total += Integer.parseInt(num.strip());
		}

		return total;
	}

	public long factorial(int input) {
		log.trace("Recieved an input of {}", input);

		if (input < 0) {
			throw new IllegalArgumentException("The factorials of negative real numbers are complex numbers, "
					+ "and this function doesn't handle such cases.");
		}

		long f = 1;
		while (input > 1) {
			log.trace("current value of input is {} and f is {}", input, f);
			f *= input;
			input--;
		}

		return f;
	}

}
