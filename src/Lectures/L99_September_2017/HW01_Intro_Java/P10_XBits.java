package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10_XBits {
    private static Integer[][] MATRIX = new Integer[8][32];
    private static Integer COUNT_OF_XBITS = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            fillARow(i, Integer.valueOf(reader.readLine()));
        }
//        printMatrix();
        countTheXBits();
        System.out.println(COUNT_OF_XBITS);
    }


    private static void countTheXBits() {
        for (int row = 0; row < 6; row++) {
            for (int col = 31; col >= 2; col--) {
                if (MATRIX[row][col] == 1 && MATRIX[row][col - 1] == 0 && MATRIX[row][col-2] == 1){
                    if (MATRIX[row+1][col] == 0 && MATRIX[row+1][col - 1] == 1 && MATRIX[row+1][col-2] == 0){
                        if (MATRIX[row+2][col] == 1 && MATRIX[row+2][col - 1] == 0 && MATRIX[row+2][col-2] == 1){
                            COUNT_OF_XBITS++;
                        }
                    }
                }
            }
        }
    }

    private static void fillARow(Integer row, Integer currentNumber) {
        for (int column = 31; column >= 0; column--, currentNumber /= 2) {
            if (currentNumber % 2 == 0) {
                MATRIX[row][column] = 0;
            } else {
                MATRIX[row][column] = 1;
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 32; j++) {
                System.out.print(MATRIX[i][j] + " ");
            }
            System.out.println();
        }
    }
}
