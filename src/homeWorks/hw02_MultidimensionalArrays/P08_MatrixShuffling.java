package homeWorks.hw02_MultidimensionalArrays;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P08_MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);


        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String currentLine[] = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currentLine[j];
            }
        }

        String[] currentCommand = scanner.nextLine().split("\\s+");
//        TODO tuka neshto v proverkite ne mi e stavalo i zatova mi garmi na 1 red... wtf
//        while (!"END".equals(currentCommand[0])) {
//            int r1 = 0;
//            int c1 = 0;
//            int r2 = 0;
//            int c2 = 0;
//            if ("swap".equals(currentCommand[0])){
//                r1 = Integer.parseInt(currentCommand[1]);
//                c1 = Integer.parseInt(currentCommand[2]);
//                r2 = Integer.parseInt(currentCommand[3]);
//                c2 = Integer.parseInt(currentCommand[4]);
//            }
//            String debug = "";
//            if (!"swap".equals(currentCommand[0])) {
//                System.out.println("Invalid input!");
//            } else if (!(r1 <= rows && c1 <= cols && r2 <= rows && c2 <= cols)) {
//                System.out.println("Invalid input!");
//
//            } else if ((r1 <= rows && c1 <= cols && r2 <= rows && c2 <= cols)&& currentCommand.length==5){
//
//                String buffer = matrix[r2][c2];
//                matrix[r2][c2] = matrix[r1][c1];
//                matrix[r1][c1] = buffer;
//                printMatrix(matrix);
//            }
//            currentCommand = scanner.nextLine().split("\\s+");
//        }
        while (!"END".equals(currentCommand[0])) {
            if ("swap".equals(currentCommand[0]) && currentCommand.length == 5) {
                int r1 = Integer.parseInt(currentCommand[1]);
                int c1 = Integer.parseInt(currentCommand[2]);
                int r2 = Integer.parseInt(currentCommand[3]);
                int c2 = Integer.parseInt(currentCommand[4]);
                if (r1 > rows || r2 > rows || c1 > cols || c2 > cols) {
                    System.out.println("Invalid input!");
                } else {
                    String buffer = matrix[r2][c2];
                    matrix[r2][c2] = matrix[r1][c1];
                    matrix[r1][c1] = buffer;
                    printMatrix(matrix);
                }
            } else {
                System.out.println("Invalid input!");
            }
            currentCommand =scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.println();
        }
    }

}
