package seeburger;

public class RecursionPrinting {
	public static void main(String[] args) {
		int a = 10;
		int x = 100000;
		int mulitplier = 10;

		
		
		recurtionPrinting(a, x, mulitplier);

	}

	public static void recurtionPrinting(int a, int b, int multiplier) {
		int currentDigit = a * multiplier;
		System.out.print(a + " ");
		if (currentDigit >= b) {
			System.out.print(currentDigit + " ");
			System.out.print(currentDigit + " ");
		} else {
			recurtionPrinting(currentDigit, b, multiplier);
		}


		boolean bb = currentDigit >= b;
		String output = String.format("%d ", currentDigit);
		
		
		System.out.print(a + " ");
	}
}
