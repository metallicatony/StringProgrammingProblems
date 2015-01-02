package org.problems.string;

public class TelephoneWordsRecursive {
	
	private static int counter = 0;
	
	// representation of dial pad using a two dimensional array
	private static final char[][] telephoneChars = new char[][] { 
		{ '0' }, // 0
		{ '1' }, // 1
		{ 'a', 'b', 'c' }, // 2
		{ 'd', 'e', 'f' }, // 3
		{ 'g', 'h', 'i' }, // 4
		{ 'j', 'k', 'l' }, // 5
		{ 'm', 'n', 'o' }, // 6
		{ 'p', 'q', 'r', 's' }, // 7
		{ 't', 'u', 'v' },  // 8
		{ 'w', 'x', 'y', 'z' } // 9 
	};
	

	/**
	 * Gets a character from dial pad
	 * @param i integer
	 * @param j integer
	 * @return
	 */
	private static char getCharacterFromDialPad(int i, int j) {
		if ((i == 0) || (i == 1))
			return telephoneChars[i][0];
		else
			return telephoneChars[i][j];
	}
	
	/**
	 * Returns the size of "i"th first dimension array in a two dimension array
	 * @param i the "i"th first dimension of the two dimension array
	 * @return
	 */
	private static int getSizeOfFirstDimension(int i) {
		return telephoneChars[i].length;
	}

	/**
	 * Recursive helper method to create a word from dial pad
	 * @param word character array
	 * @param numbers given input numbers as string
	 * @param start the index of input digit that is being processed
	 */
	private static void getWordFromDialPad(char[] word, String numbers, int start) {
		// base case -> start is the index value of the position from the word
		if (start > (numbers.length() - 1)) {
			System.out.println(++counter + " ==> " + new String(word));
			// look up dictionary to find whether the word is meaningful or not
			return;
		}

		// Identify the number of iterations based on the digit
		Integer number = numbers.charAt(start) - '0';
		int iterations = getSizeOfFirstDimension(number);

		
		// Iteration in a recursive method is equal to number of possible combinations that a position can take
		// for eg. digit 2 can take 3 possible chars - A, B and C where as digit 7 can take 4 different chars
		for (int j = 0; j < iterations; j++) {
			// store a possible character for the digit and move on to the next position by calling the recursive method again
			word[start] = getCharacterFromDialPad(number, j);
			getWordFromDialPad(word, numbers, start + 1);
		}
	}
	
	/**
	 * Validate dialed numbers
	 * @param numbers
	 * @throws Exception
	 */
	private static void isValidNumber(String numbers) throws Exception {
		Long.valueOf(numbers);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		String numbers = "5129602290";
		isValidNumber(numbers);
		char[] word = new char[numbers.length()];
		getWordFromDialPad(word, numbers, 0);
	}
}
