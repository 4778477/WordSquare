import java.util.ArrayList;

public class Square {

	private Dictionary dictionary;

	Square(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	void build(int numChars, String alphaChars) {
		ArrayList<String> remainingChars = new ArrayList<>();
		ArrayList<String> currentSquare = new ArrayList<>();
		for (char letter : alphaChars.toCharArray()){
			remainingChars.add(String.valueOf(letter));
		}
		System.out.println(remainingChars);
		currentSquare.add(dictionary.getDictionary().get(0));
		System.out.println(currentSquare);

	}

}
