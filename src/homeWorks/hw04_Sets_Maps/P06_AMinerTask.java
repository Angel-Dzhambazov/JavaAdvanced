
package homeWorks.hw04_Sets_Maps;



import javafx.beans.binding.When;
import jdk.nashorn.internal.ir.WhileNode;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resourses = new LinkedHashMap<>();
        String currentLine = scanner.nextLine();

        while (!"stop".equals(currentLine)) {
            Integer quantity = Integer.parseInt(scanner.nextLine());

            if (!resourses.containsKey(currentLine)) {
                resourses.put(currentLine, quantity);
            } else {
                resourses.put(currentLine, resourses.get(currentLine) + quantity);
            }
            currentLine = scanner.nextLine();
        }

        for (String key : resourses.keySet()) {
            System.out.printf("%s -> %d%n", key, resourses.get(key));
        }
    }
}
