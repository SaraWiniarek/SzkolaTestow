package com.modul_1;
public class StringCalculator {
	
	public int add(String input) {
		if (input.isEmpty())
			return 0;
		else {
			String[] numbers = input.split(",");
			int result = 0;
			
			for(int i = 0; i < numbers.length; i++)
				result += getIntFrom(numbers[i]);
			
			return result;
		}
	}
	
	private int getIntFrom(String number) {
		return Integer.parseInt(number);
	}
}