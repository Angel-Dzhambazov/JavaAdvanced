package homeWorks.hw02_MultidimensionalArrays;

import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int diagonal1Sum = 0;
        int diagonal2Sum = 0;
        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split(" ");
            diagonal1Sum += Integer.parseInt(input[i]);
            diagonal2Sum += Integer.parseInt(input[size-1-i]);
        }
        System.out.println(Math.abs(diagonal1Sum-diagonal2Sum));
    }
}
