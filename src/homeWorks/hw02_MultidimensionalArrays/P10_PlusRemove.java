package homeWorks.hw02_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fluch on 4/26/2017.
 */
public class P10_PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentLine = scanner.nextLine().toLowerCase();

        List<char[]> input = new ArrayList<char[]>();
        while (!"END".equals(currentLine)) {
            input.add(currentLine.toCharArray());
            currentLine = scanner.nextLine();
        }

        int rowCount = input.size();

        char[][] charMatrix = new char[rowCount][];
        int[][] binary = new int[rowCount][];
        int currentRow = 0;

        for (char[] chars : input) {
            charMatrix[currentRow] = chars;

            int[] binnaryLine = new int[chars.length];
            for (int i = 0; i < binnaryLine.length; i++) {
                binnaryLine[i] = 1;
            }
            binary[currentRow] = binnaryLine;
            currentRow++;
        }


        List<int[]> foundEquals = new ArrayList<>();
        for (int i = 0; i < rowCount - 2; i++) {
            char[] currentMatrixLine = charMatrix[i];
            for (int j = 1; j < currentMatrixLine.length; j++) {
                int plusOneRowLength = charMatrix[i + 1].length - 1;
                int plusTwoRowLength = charMatrix[i + 2].length - 1;
                if (!(plusOneRowLength < j + 1 || plusTwoRowLength < j)) {
                    if (areEven(i, j, charMatrix)) {
                        int[] currentCharFound = new int[2];
                        currentCharFound[0] = i;
                        currentCharFound[1] = j;
                        foundEquals.add(currentCharFound);
                        binary[i][j] = 0;
                        binary[i + 1][j - 1] = 0;
                        binary[i + 1][j] = 0;
                        binary[i + 1][j + 1] = 0;
                        binary[i + 2][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < binary[i].length ; j++) {
                if (binary[i][j] == 1){
                    System.out.print(charMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static boolean areEven(int i, int j, char[][] charMatrix) {

        String a = new String(String.valueOf(charMatrix[i][j])).toLowerCase();

        String b = new String(String.valueOf(charMatrix[i+1][j-1])).toLowerCase();
        String c = new String(String.valueOf(charMatrix[i+1][j])).toLowerCase();
        String d = new String(String.valueOf(charMatrix[i+1][j+1])).toLowerCase();

        String e = new String(String.valueOf(charMatrix[i+2][j])).toLowerCase();

        if (a.equals(c) && a.equals(e) &&
                b.equals(c) && b.equals(d)) {
            return true;
        } else {
            return false;
        }
    }
}
