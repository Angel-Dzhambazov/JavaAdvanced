
package homeWorks.hw04_Sets_Maps;


import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        TreeMap<Character, Integer> chars = new TreeMap<>();
        for (char c : input) {

            if (!chars.containsKey(c)) {
                chars.put(c, 1);
            } else {
                chars.put(c, chars.get(c) + 1);
            }
        }

        for (Character key : chars.keySet()) {
            System.out.printf("%s: %d time/s%n", key, chars.get(key));
        }

    }
}
