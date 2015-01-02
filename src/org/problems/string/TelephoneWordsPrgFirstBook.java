package org.problems.string;

public class TelephoneWordsPrgFirstBook {
	
	private static char getChar(int digit, int position) throws Exception {
		String[] telephoneChars = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		if ((position - 1) < 0) {
			throw new Exception("Operation Not allowed");
		}
		
		if (digit == 0 || digit == 1) {
			return (char) ('0'+ digit);
		} else {
			return telephoneChars[digit].charAt(position - 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] numbers = {5, 4, 1};
		int digit = 0;
		char[] word = new char[numbers.length];
		getTelephoneWords(word, numbers, digit);
	}
	
	/*
	 */
	private static void getTelephoneWords(char[] telephoneWord, int[] numbers, int digit) throws Exception {
		if (digit == numbers.length) {
			System.out.println(telephoneWord);
			return;
		} else {
			for (int i = 0; i < 3; i++) {
				telephoneWord[digit] = getChar(numbers[digit], i+1);
				if (digit < numbers.length) {
					getTelephoneWords(telephoneWord, numbers, digit+1);
					if (telephoneWord[digit] == '1' || telephoneWord[digit] == '0') {
						return;
					}
				}
			}
		}
	}

}
