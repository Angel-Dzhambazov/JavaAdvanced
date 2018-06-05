package Lectures.L99_September_2017.HW07_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class P13_Inferno {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Predicate<Integer>> commands = new HashMap<>();

        while (true) {
            String[] input = reader.readLine().split(";");
            if ("Forge".equals(input[0])) {
                break;
            }
            Predicate<Integer> predicate = makePredicate(input, arr);

            switch (input[0]){
                case "Exclude":
                    commands.put((input[0]+ input[1]+ input[2]), predicate);
                    break;
                case "Reverse":
                    commands.remove(input[0]+ input[1]+ input[2]);
                    default:
                        break;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            boolean forRemove = false;
            for (Map.Entry<String, Predicate<Integer>> stringPredicateEntry : commands.entrySet()) {
                if (stringPredicateEntry.getValue().test(i)){
                    forRemove = true;
                    break;
                }
            }
            if (!forRemove){
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static Predicate<Integer> makePredicate(String[] input, int[] arr) {
        switch (input[1].toUpperCase()) {
            case "SUM LEFT":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] == Integer.valueOf(input[2]);
            case "SUM RIGHT":
                return index -> (index >= arr.length - 1 ? 0 : arr[index + 1]) + arr[index] == Integer.valueOf(input[2]);
            case "SUM LEFT RIGHT":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] + (index >= arr.length - 1 ? 0 : arr[index + 1]) == Integer.valueOf(input[2]);
            default:
                return null;
        }
    }
}
