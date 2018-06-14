package seeburger;
import java.util.ArrayList;

public class InitialTestClass {
	public static void main(String[] args) {

		String input = "12656564666678";
		int index = 3;
		// System.out.println(isItEven(input, index));

		//
		// for (char c : input.toCharArray()) {
		// System.out.println(c);
		// }

		int t = 1223;
		ArrayList<Integer> list = new ArrayList();

		while (t > 0) {
			list.add(t % 10);
			t /= 10;
		}
		while (list.size() > 0) {
			System.out.print(list.remove(list.size() - 1) + " ");
		}

		 printDigitsAsWords(input);
		 
		 //class biginteger - da simulira biginteger 
		 //kato mu zdadesh 4islo,stoinostta na 4isloto da se darji kato masiv 
		 ///tozi klas da sabira podobni obekti kato gi sabira 4rez masivi i da izvajda po sa6tiq na4in 
		 // method .add za sabirane s drug podoben obekt
		 // trabva da sabere masivite 

	}

	private static void printDigitsAsWords(String input) {
		for (char c : input.toCharArray()) {
			switch (c) {
			case '0':
				System.out.println("zero");
				break;
			case '1':
				System.out.println("one");
				break;
			case '2':
				System.out.println("two");
				break;
			case '3':
				System.out.println("three");
				break;
			case '4':
				System.out.println("four");
				break;
			case '5':
				System.out.println("five");
				break;
			case '6':
				System.out.println("six");
				break;
			case '7':
				System.out.println("seven");
				break;
			case '8':
				System.out.println("eight");
				break;
			case '9':
				System.out.println("nine");
				break;
			default:
				break;
			}
		}
	}

	private static boolean isItEven(String input, int index) {
		int x = Integer.parseInt(input.substring(index - 1, index));
		if (x % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
