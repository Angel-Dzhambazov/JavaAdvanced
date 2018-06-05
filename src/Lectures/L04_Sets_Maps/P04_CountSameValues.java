package Lectures.L04_Sets_Maps;

import java.util.HashMap;
import java.util.Scanner;


public class P04_CountSameValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> result = new HashMap<>();
        String[] input = scanner.nextLine().split(" ");
        for (String key : input) {
            if (!result.containsKey(key)) {
                result.put(key, 1);
            } else {
                result.put(key, result.get(key) + 1);
            }
        }
        for (String key : result.keySet()) {
            System.out.println(key + " - " + result.get(key) + " times");
        }

    }

}
