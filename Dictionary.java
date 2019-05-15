import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

	private File file;
	private ArrayList<String> dictionary;

	Dictionary() {
		file = new File("C:\\workspace\\connor.reilly\\Other\\WordSquare\\src\\dict.txt");
		dictionary = new ArrayList<>();
	}

	void load() throws FileNotFoundException {

		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			dictionary.add(scanner.nextLine());
		}
	}

	private void filterByNumChars(int numChars) {
		ArrayList<String> wordsToKeep = new ArrayList<>();
		for (String word : dictionary) {
			if (word.length() == numChars) {
				wordsToKeep.add(word);
			}
		}
		dictionary = wordsToKeep;
	}

	private void filterByAlphaChars(String alphaChars) {
		ArrayList<String> wordsToKeep = new ArrayList<>();
		char alphaCharArray[] = alphaChars.toCharArray();
		for (String word : dictionary) {
			char[] wordCharArray = word.toCharArray();
			boolean keepWord = true;
			for (int i = 0; i < wordCharArray.length; i++) {
				boolean foundChar = false;
				for (int j = 0; j < alphaCharArray.length; j++) {
					if (wordCharArray[i] == alphaCharArray[j]) {
						foundChar = true;
					}
				}
				if (!foundChar) {
					keepWord = false;
				}
			}
			if (keepWord) {
				wordsToKeep.add(word);
//				System.out.println(word);
			}
		}
		dictionary = wordsToKeep;
//		System.out.println("Word count: " + dictionary.size());
	}

	void filterAll(int numChars, String alphaChars) {
		filterByNumChars(numChars);
		filterByAlphaChars(alphaChars);
	}

	public ArrayList<String> getWordsByPrefix(String prefix) {
		ArrayList<String> wordsToKeep = new ArrayList<>();
		for (String word : dictionary) {
			if (word.startsWith(prefix)) {
				wordsToKeep.add(word);
			}
		}
		return wordsToKeep;
	}

	public ArrayList<String> getDictionary() {
		return dictionary;
	}

}
