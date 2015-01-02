package org.problems.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelephoneWordsIterative {
	
	/**
	 * Returns the list of words created using phone dial pad and the given phone number
	 * @param digits the phone number
	 * @return list of combination of words
	 */
	public static ArrayList<String> getWordFromDialPad(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<String> preres = new ArrayList<String>();
		res.add("");

		for (int i = 0; i < digits.length(); i++) {
			for (String str : res) {
				String letters = map.get(digits.charAt(i));
				for (int j = 0; j < letters.length(); j++)
					preres.add(str + letters.charAt(j));
			}
			res = preres;
			preres = new ArrayList<String>();
		}
		return res;
	}

	static final HashMap<Character, String> map = new HashMap<Character, String>() {
		private static final long serialVersionUID = -4944417767712227819L;

		{
			put('0', "0");
			put('1', "1");
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};

	public static void main(String[] args) throws Exception {
		Long numbers = Long.valueOf("5129602290");
		List<String> telephoneWords = getWordFromDialPad(numbers.toString());
		int counter = 0;
		for (String word: telephoneWords) {
			System.out.println(++counter + " ==> " + word);
		}
	}
}