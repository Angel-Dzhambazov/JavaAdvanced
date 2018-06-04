package homeWorks.hw02_MultidimensionalArrays;


import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P01_FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        int[][] array = new int[size][size];

        if (new String("A").equals(input[1])) {

            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    array[row][col] = row + 1 + col * size;
                }
            }

        } else if (new String("B").equals(input[1])) {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {

                    if (col % 2 == 0) {
                        array[row][col] = row + 1 + col * size;

                    } else if (col % 2 != 0) {
                        array[row][col] = size - row + col * size;
                    }

                }
            }
        }

        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}