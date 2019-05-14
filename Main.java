import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

	    Dictionary dictionary = new Dictionary();
	    dictionary.load();

//	    System.out.println("\nInput: ");
//	    String input;
//	    input = sc.next();
//	    int numChars = Integer.parseInt(input);
//
//	    input = sc.nextLine();
//	    String alphaChars = input;
//
//	    dictionary.filterAll(numChars, alphaChars);

		dictionary.filterAll(Integer.parseInt("4"), "aaccdeeeemmnnnoo");

		Square square = new Square(dictionary);

		square.build(Integer.parseInt("4"), "aaccdeeeemmnnnoo");

    }

}
