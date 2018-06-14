package seeburger.inhouseTasks20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_MatchFullName {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> output = new ArrayList<>();

		String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
		String input = reader.readLine();

		while (true) {
			if ("end".equalsIgnoreCase(input)) {
				break;
			}
			Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			Matcher matcher = pattern.matcher(input);
			while (matcher.find()) {
				output.add(input);
			}
			input = reader.readLine();
		}
		
		for (String line: output) {
			System.out.println(line);
		}
	}

}
