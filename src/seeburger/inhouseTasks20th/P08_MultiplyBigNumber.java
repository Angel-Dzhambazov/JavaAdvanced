package seeburger.inhouseTasks20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08_MultiplyBigNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String number = reader.readLine();
		int multiplier = Integer.parseInt(reader.readLine());

		calculate(number, multiplier);

	}

	private static void calculate(String number, int multiplier) {
		int toAdd = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = number.length(); i > 0; i--) {
			int currentDigit = Integer.parseInt(number.substring(i - 1, i));
			int result = currentDigit * multiplier + toAdd;
			toAdd = result / 10;
			result = result % 10;
			sb.append(result);
		}

		if (toAdd > 0) {
			sb.append(toAdd);
		}
		if (sb.length() > 0) {
			while (true) {
				String lastDigit = sb.substring(sb.length() - 1, sb.length());
				if (lastDigit != "0") {
					break;
				} else {
					sb.setLength(sb.length() - 1);
				}
			}
			System.out.println(sb.reverse().toString());
		} else {
			System.out.println("0");
		}

	}

}
