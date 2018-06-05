package homeWorks.hw02_MultidimensionalArrays;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fluch on 4/26/2017.
 */

public class P12_StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        int rotation = method(input);
        int rows = 0;
        int cols = 0;
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        String currentLine = scanner.nextLine();
        while (!"END".equals(currentLine)) {
            int currentColsLength = currentLine.length();
            cols = Math.max(cols, currentLine.length());
            ArrayList<String> currentLineAsArrayList = new ArrayList<>();
            for (int i = 0; i < currentColsLength; i++) {
                currentLineAsArrayList.add(String.valueOf(currentLine.charAt(i)));
            }
            matrix.add(currentLineAsArrayList);
            rows++;
            currentLine = scanner.nextLine();
        }

        int rotatedRows = rows;
        int rotatedCols = cols;
        switch (rotation) {
            case 0:
                print(matrix);
                break;
            case 1:
                rotatedRows = cols;
                rotatedCols = rows;
                for (int i = 0; i < rotatedRows; i++) {
                    for (int j = 0; j < rotatedCols; j++) {
                        try {
                            int targetRow = rows - j - 1;
                            int targetCol = cols - rotatedRows + i;
                            String currentChar = matrix.get(targetRow).get(targetCol);
                            System.out.print(currentChar);
                        } catch (Exception error) {
                            String currentChar = " ";
                            System.out.print(currentChar);
                        }
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 0; i < rotatedRows; i++) {
                    for (int j = 0; j < rotatedCols; j++) {
                        try {
                            int targetRow = rows - i - 1;
                            int targetCol = cols - j - 1;
                            String currentChar = matrix.get(targetRow).get(targetCol);
                            System.out.print(currentChar);
                        } catch (Exception error) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 3:
                rotatedRows = cols;
                rotatedCols = rows;
                for (int i = 0; i < rotatedRows; i++) {
                    for (int j = 0; j < rotatedCols; j++) {
                        try {
                            int targetRow = rows - rotatedCols + j;
                            int targetCol = cols - i - 1;
                            String currentChar = matrix.get(targetRow).get(targetCol);
                            System.out.print(currentChar);
                        } catch (Exception error) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
        }

    }

    private static void print(ArrayList<ArrayList<String>> matrix) {
        for (ArrayList<String> strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }


    private static int method(StringBuilder input) {
        int output = 0;
        while (true) {
            int openBraket = input.indexOf("(");
            if (openBraket != -1) {
                int closeBracket = input.indexOf(")", openBraket + 1);
                String substring = input.substring(openBraket + 1, closeBracket);
                output = Integer.parseInt(substring) / 90;
            }
            break;
        }
        return output % 4;
    }
}
