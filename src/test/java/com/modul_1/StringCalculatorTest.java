package com.modul_1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCalculatorTest {
	StringCalculator calculator;
	
	@Test
	public void shouldReturnZeroIfEmpty() {
		createCalculator();
		assertEquals(0, calculator.add(""));
	}

	@Test
	public void shouldReturnANumberWhenNumberGiven() {
		createCalculator();
		assertEquals(2, calculator.add("2"));
	}
	
	@Test
	public void shouldSumTwoNumbersWhenTwoNumbersGiven() {
		createCalculator();
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void shouldSumMoreNumbersWhenMoreIsGiven() {
		createCalculator();
		assertEquals(10, calculator.add("1,2,3,4"));
	}
	
	private void createCalculator() {
		calculator = new StringCalculator();
	}
}