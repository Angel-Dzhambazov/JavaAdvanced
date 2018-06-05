package Lectures.L02_MultidimentionalArrays.ExamPreps.Java_2017_10Octomber_22;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_BitSnow_Matrix {

    private static int[][] MATRIX;
    private static int[][] FINAL_MATRIX;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        MATRIX = new int[input.length][16];
        FINAL_MATRIX = new int[input.length][16];
        for (int i = 0; i < input.length; i++) {
            Integer currentDigit = Integer.valueOf(input[i]);
            String[] digitAsBinary = Integer.toBinaryString(currentDigit).split("");
            fillARowOFTheMatrix(digitAsBinary, i);
        }
        makeItSnow();
        String[] output = new String[input.length];
        fillOutput(output);
        System.out.println(String.join(", ",output));

    }

    private static void fillOutput(String[] output) {

        for (int i = 0; i < MATRIX.length; i++) {
            StringBuilder binaryDigit = new StringBuilder("");
            for (int j = 0; j < 16; j++) {
                binaryDigit.append(String.valueOf(FINAL_MATRIX[i][j]));
            }
            int currentInt = Integer.parseInt(binaryDigit.toString(), 2);
            output[i] = String.valueOf(currentInt);
        }

    }

    private static void makeItSnow() {
        for (int col = 0; col < 16; col++) {
            int numberOfSnows = 0;
            for (int row = 0; row < MATRIX.length; row++) {
                int currentInt = MATRIX[row][col];
                if (currentInt == 1) {
                    numberOfSnows++;
                }
            }
            fillFinalMatrix(numberOfSnows, col);
        }
    }

    private static void fillFinalMatrix(int numberOfSnows, int currentColumn) {
        int zeroes = MATRIX.length - numberOfSnows;
        for (int i = 0; i < zeroes; i++) {
            FINAL_MATRIX[i][currentColumn] = 0;
        }
        for (int i = zeroes; i < MATRIX.length; i++) {
            FINAL_MATRIX[i][currentColumn] = 1;
        }
    }

    private static void fillARowOFTheMatrix(String[] digitAsBinary, int row) {
        int difference = 16 - digitAsBinary.length;
        for (int i = digitAsBinary.length - 1; i >= 0; i--) {
            MATRIX[row][i + difference] = Integer.valueOf(digitAsBinary[i]);
        }
        for (int i = difference - 1; i >= 0; i--) {
            MATRIX[row][i] = 0;
        }
    }

}
