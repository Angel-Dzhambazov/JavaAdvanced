package seeburger.inhouseTasks20th;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P05_Chocolate {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String weDontNeedThis = reader.readLine();

		int[] chocolates = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int students = Integer.valueOf(reader.readLine());

		List<Integer> chocolateList = new ArrayList<>();

		for (int chocolate : chocolates) {
			chocolateList.add(chocolate);
		}
		Collections.sort(chocolateList);

		int difference = chocolateList.get(chocolateList.size() - 1);
		for (int i = 0; i <= chocolateList.size() - students; i++) {
			int tempDifference = chocolateList.get(i + students - 1) - chocolateList.get(i);
			if (tempDifference < difference) {
				difference = tempDifference;
			}
		}

		System.out.println(String.format("Min Difference is %d.", difference));

	}

}
