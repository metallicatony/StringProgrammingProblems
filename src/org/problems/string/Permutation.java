package org.problems.string;

/**
 * Class to permute a given string. Idea is to pick one character from word and append with prefix at every level (the for loop effectively does that).
 * The rest of characters apart from the picked character is now the new word.Keep repeating the same until the base case (word length = 1) is reached and 
 * thats when you print the prefix + word value. 
 *
 */
public class Permutation {
	
	private static int counter = 1;
	
	public static void main(String[] args) {
		String prefix = "", word = "abc";
		permute(prefix, word);
	}
	
	private static void permute(String prefix, String word) {
		int wordLength = word.length();
		// base case for recursion
		if (wordLength == 1) {
			System.out.println(counter + " ==> " + prefix+word);
			counter++;
		} else {
			for (int i = 0; i < wordLength; i++) {
				permute(prefix + word.charAt(i),
						word.substring(0, i) + word.substring(i + 1));
			}
		}
	}
}
