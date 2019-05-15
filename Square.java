import java.util.ArrayList;
import java.util.Collections;

public class Square {

	private Dictionary dictionary;
	private ArrayList<String> usedChars = new ArrayList<>();

	Square(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	void build(int numChars, String alphaChars) {
		ArrayList<String> remainingChars = new ArrayList<>();
		ArrayList<String> firstWords = new ArrayList<>();
		ArrayList<String> secondWords = new ArrayList<>();
		ArrayList<String> thirdWords = new ArrayList<>();
		ArrayList<String> fourthWords = new ArrayList<>();
		ArrayList<String> currentSquare = new ArrayList<>();
		currentSquare.add("");
		currentSquare.add("");
		currentSquare.add("");
		currentSquare.add("");

		for (char letter : alphaChars.toCharArray()) {
			remainingChars.add(String.valueOf(letter));
		}
		Collections.sort(remainingChars, String.CASE_INSENSITIVE_ORDER);

		firstWords.addAll(dictionary.getDictionary());

		for (String word : firstWords){
			usedChars.clear();
			currentSquare.set(0, word);
			updateUsedCharacters(currentSquare);
			String firstPrefix = String.valueOf(currentSquare.get(0).charAt(1));
			secondWords.clear();
			secondWords.addAll(dictionary.getWordsByPrefix(firstPrefix));

			for (String word2 : secondWords){
				usedChars.clear();
				currentSquare.set(1, word2);
				updateUsedCharacters(currentSquare);
				String secondPrefix = String.valueOf(currentSquare.get(0).charAt(2) + "" + currentSquare.get(1).charAt(2));
				thirdWords.clear();
				thirdWords.addAll(dictionary.getWordsByPrefix(secondPrefix));

				for (String word3 : thirdWords){
					usedChars.clear();
					currentSquare.set(2, word3);
					updateUsedCharacters(currentSquare);
					String thirdPrefix = String.valueOf(currentSquare.get(0).charAt(3) + "" + currentSquare.get(1).charAt(3) + "" + currentSquare.get(2).charAt(3));
					fourthWords.clear();
					fourthWords.addAll(dictionary.getWordsByPrefix(thirdPrefix));

					for (String word4 : fourthWords){
						usedChars.clear();
						currentSquare.set(3, word4);
						updateUsedCharacters(currentSquare);
						if (usedChars.equals(remainingChars)){
							drawSquare(currentSquare);
						}
					}

				}

			}

		}
	}

	private void updateUsedCharacters(ArrayList<String> currentSquare){
		for (String squareWord : currentSquare){
			for (char ch : squareWord.toCharArray()){
				usedChars.add(String.valueOf(ch));
			}
		}
		Collections.sort(usedChars, String.CASE_INSENSITIVE_ORDER);
	}

	private void drawSquare(ArrayList<String> currentSquare){
		System.out.println();
		for (String word : currentSquare){
			System.out.println(word);
		}
	}
}
