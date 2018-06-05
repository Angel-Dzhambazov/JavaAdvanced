package Lectures.L99_September_2017.HW07_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;

public class P13_Inferno_AngelReshenie {
    private static  HashSet<String> commands = new HashSet<>();
// ako go napravq hashset ot String[] metoda .contains ne mi vra6ta "true" kogato tyrsq dali ima takava komanda vavedena,
// nito moteda .remove premahva komandata, koeto me prinudi da polzwam HashSet ot String, i posle da go slpitvam dolu
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        while (true) {
            String[] currentCommands = reader.readLine().split(";");
            if ("Forge".equals(currentCommands[0])) {
                break;
            }
            fillTheHashSet(currentCommands);
        }

        for (int i = 0; i < arr.length; i++) {
            boolean shouldWeRemove = false;
            for (String s : commands) {
                Predicate<Integer> predicate = makePredicate(s, arr);
                if (predicate.test(i)) {
                    shouldWeRemove = true;
                    break;
                }
            }
            if (!shouldWeRemove) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void fillTheHashSet(String[] currentCommands) {
        switch (currentCommands[0]) {
            case "Exclude":
                String insert = currentCommands[1] + "-" + currentCommands[2];
                commands.add(insert);
                break;
            case "Reverse":
                String removed = currentCommands[1] + "-" + currentCommands[2];
                if (commands.contains(removed)) {
                    commands.remove(removed);
                }
                break;
            default:
                break;
        }
    }

    private static Predicate<Integer> makePredicate(String s, int[] arr) {
        String[] command = s.split("-");
        switch (command[0].toUpperCase()) {
            case "SUM LEFT":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] == Integer.valueOf(command[1]);
            case "SUM RIGHT":
                return index -> (index > arr.length - 1 ? 0 : arr[index + 1]) + arr[index] == Integer.valueOf(command[1]);
            case "SUM LEFT RIGHT":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] + (index < arr.length -1 ? arr[index + 1] : 0) == Integer.valueOf(command[1]);
            default:
                return null;
        }
    }
}
