package org.problems.string;

public class CombinationCase {
	
	private static int combinationNo = 0;
	
	public static void main(String[] args) {
		String word = "prince";
		String prefix = "";
		int position = 0;
		//caseCombinationInWord(word, prefix, position);
		caseCombinations(word);
	}
	
	public static void caseCombinationInWord(String word, String prefix, int position) {
		// base case
		if (position == word.length()) {
			combinationNo++;
			System.out.println(combinationNo + "==>" + prefix);
			return;
		} else {
			for (int i = 0; i < 2; i++) {
				char c = word.charAt(position);
				if (i == 1) {
					c = Character.toUpperCase(c);
				}
				caseCombinationInWord(word, prefix+c, position + 1);
			}
		}
	}
	
	public static void caseCombinations(String word) {
		int numOfChars = 1;
		int wordLength = word.length();
		while (numOfChars <= wordLength) {
			for (int i = 0; i < wordLength; i++) {
				combinationNo++;
				if (i+numOfChars > wordLength && numOfChars > 1) {
					int numToPrintAtStart = numOfChars - (wordLength - i);
					System.out.println(combinationNo + " ==> " + word.substring(0, numToPrintAtStart).toUpperCase() 
													+ word.substring(numToPrintAtStart, i) 
													 + word.substring(i).toUpperCase());
				} else {
				System.out.println(combinationNo + " ==> " 
							+ word.substring(0, i) 
							+ word.substring(i, i+numOfChars).toUpperCase() 
							+ word.substring(i+numOfChars));
				}
				if (numOfChars == wordLength)
					return;
			}
			numOfChars++;
		}
	}

}
