package org.problems.string;

/**
 * Class to provide different combinations of a given string
 * a, ab, abc, ac, b, bc, c
 *
 */
public class Combination {
	public static void main(String[] args) {
		String word = "abc";
		String prefix = new String();
		int start = 0;
		combine(prefix, word, start);
	}
	
	public static void combine(String prefix, String word, int start) {
		if (start != 0) {
			System.out.println(prefix);
		}
		for (int i = start; i < word.length(); i++) {
			combine(prefix + word.charAt(i), word, i + 1);
		}
	}
}
