package homeWorks.hw02_MultidimensionalArrays;

import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P04_SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int numberOfSquares = 0;
        boolean rowMatch = false;

        //System.out.printf("%d and %d", rows, cols);
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input[j];
                //System.out.print(matrix[i][j] + " ");
            }
            //System.out.println();

        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j].equals(matrix[i][j - 1])) {
                    //System.out.println(matrix[i][j - 1] + matrix[i][j]);
                    if (matrix[i+1][j].equals(matrix[i+1][j-1])){
                        if (matrix[i][j].equals(matrix[i+1][j])){
                            numberOfSquares += 1;
                        }
                    }

                }
            }
        }

        System.out.println(numberOfSquares);


    }
}
