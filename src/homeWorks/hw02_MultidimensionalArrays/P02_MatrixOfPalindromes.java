package homeWorks.hw02_MultidimensionalArrays;

import java.util.Scanner;



public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String[][] matrix = new String[a][b];


//        char c = 'a';
//        String s = String.valueOf(c);             fastest + memory efficient
//        String s = Character.toString(c);
//        String s = new String(new char[]{c});


        for (int row = 0; row < a; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = new String(String.valueOf(alphabet[row])+ String.valueOf(alphabet[col+row]) +String.valueOf(alphabet[row]));
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }


    }
}
