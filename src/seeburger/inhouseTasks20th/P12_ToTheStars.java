package seeburger.inhouseTasks20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P12_ToTheStars {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<String> stars = new ArrayList<>();
		List<String> finalStars = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			stars.add(reader.readLine());
		}

		String[] normandy = reader.readLine().split("\\s+");

		int moves = Integer.parseInt(reader.readLine());

		Double xAxis = Double.parseDouble(normandy[0]);
		Double yAxis = Double.parseDouble(normandy[1]);

		for (String star : stars) {
			String[] tokens = star.split("\\s+");
			Boolean isItOnTheWay = false;
			double currentX = Double.parseDouble(tokens[1]);
			double currentY = Double.parseDouble(tokens[2]);
			String tempStar = tokens[0].toLowerCase();
			if (xAxis >= currentX - 1.0 && xAxis <= currentX + 1.0) {
				isItOnTheWay = true;
				finalStars.add(star);
			}
		}

		for (String star : finalStars) {
			System.out.println(star);
		}

		for (Double i = yAxis; i <= yAxis + moves; i++) {
			String print = "space";
			for (String star : finalStars) {
				String[] tokens = star.split("\\s+");
				Double tempY = Double.parseDouble(tokens[2]);
				if (tempY - 1 >= i && tempY + 1 <= i) {
					print = tokens[0].toLowerCase();
				}
			}
			System.out.println(print);
		}
	}
}
