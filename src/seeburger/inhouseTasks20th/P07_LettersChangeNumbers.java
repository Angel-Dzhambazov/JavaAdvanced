package seeburger.inhouseTasks20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P07_LettersChangeNumbers {
	private static double result = 0.0;
	private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	private static List<String> lower = new ArrayList<>();
	private static List<String> upper = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// filling the list with the alphabet
		for (int i = 0; i < alphabet.length; i++) {
			lower.add(String.valueOf(alphabet[i]));
		}
		for (int i = 0; i < alphabet.length; i++) {
			upper.add(String.valueOf(alphabet[i]).toUpperCase());
		}

		// reading the input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// iterating over the input
		String[] input = reader.readLine().split("\\s+");
		for (String word : input) {
			calculateInt(word);
		}
		
		System.out.println(String.format("%.2f", result));

	}

	private static void calculateInt(String word) {
		String firstLetter = word.substring(0, 1);
		String lastLetter = word.substring(word.length() - 1, word.length());
		double digit = Double.valueOf(word.substring(1, word.length() - 1));

		int firstIndex = 0;
		int lastIndex = 0;

		// doing operation with according to first letter
		if (lower.contains(firstLetter)) {
			firstIndex = lower.indexOf(firstLetter) + 1;
			digit *= firstIndex * 1.0;
		} else {
			firstIndex = upper.indexOf(firstLetter) + 1;
			digit /= firstIndex * 1.0;
		}

		// doing operation according to last letter

		if (lower.contains(lastLetter)) {
			lastIndex = lower.indexOf(lastLetter) + 1;
			digit += lastIndex;
		} else {
			lastIndex = upper.indexOf(lastLetter) + 1;
			digit -= lastIndex;
		}

		result += digit;

	}
}
