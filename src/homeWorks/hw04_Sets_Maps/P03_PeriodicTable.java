
package homeWorks.hw04_Sets_Maps;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by fluch on 5/28/2017.
 */
public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] currentElements = scanner.nextLine().split(" ");
            for (String element : currentElements) {
                elements.add(element);
            }
        }

        for (String element : elements) {
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.println();
    }
}
