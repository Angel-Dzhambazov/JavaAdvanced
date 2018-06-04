package homeWorks.hw01_JavaSyntax;

import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P07_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < input.length - 1; i = i + 2) {

                int a = Integer.parseInt(input[i]);
                int b = Integer.parseInt(input[i + 1]);

                if (a % 2 == 0) {
                    if (b % 2 == 0) {
                        System.out.printf("%d, %d -> both are even\n", a, b);
                    }
                    if (b % 2 != 0) {
                        System.out.printf("%d, %d -> different\n", a, b);
                    }
                }
                if (a % 2 != 0) {
                    if (b % 2 != 0) {
                        System.out.printf("%d, %d -> both are odd\n", a, b);
                    }
                    if (b % 2 == 0) {
                        System.out.printf("%d, %d -> different\n", a, b);
                    }
                }
            }
        }
    }
}
