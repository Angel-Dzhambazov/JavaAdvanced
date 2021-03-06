
package homeWorks.hw04_Sets_Maps;


import java.util.*;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsSize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashSet<String> set1 = new LinkedHashSet<>();
        HashSet<String> set2 = new HashSet<>();

        for (int i = 0; i < setsSize[0] + setsSize[1]; i++) {
            if (i < setsSize[0]) {
                set1.add(scanner.nextLine());
            } else {
                set2.add(scanner.nextLine());
            }
        }
        set1.retainAll(set2);
        System.out.println(String.join(" ", set1));


    }
}
