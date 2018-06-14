package seeburger.inhouseTasks20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08_MelrahShake {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();
		String pattern = reader.readLine();

		int firstIndex = input.indexOf(pattern);
		int lastIndex = input.lastIndexOf(pattern);

		while (true) {
			if (firstIndex > -1 && lastIndex > -1 && pattern.length() > 0) {
				System.out.println("Shaked it.");
				input = removeShaken(input, firstIndex, lastIndex, pattern.length());
				pattern = removeFromPattern(pattern);
				firstIndex = input.indexOf(pattern);
				lastIndex = input.lastIndexOf(pattern);
			} else {
				System.out.println("No shake.");
				System.out.println(input);
				break;
			}
		}

	}

	private static String removeShaken(String input, int firstIndex, int lastIndex, int patternLength) {
		String leftPart = input.substring(0, firstIndex);
		String middlePart = input.substring(firstIndex + patternLength, lastIndex);
		String rightPart = input.substring(lastIndex + patternLength, input.length());
		return leftPart + middlePart + rightPart;
	}

	private static String removeFromPattern(String pattern) {
		String leftPart = pattern.substring(0, pattern.length() / 2);
		String rightPart = pattern.substring(pattern.length() / 2 + 1, pattern.length());
		return leftPart + rightPart;
	}
}
