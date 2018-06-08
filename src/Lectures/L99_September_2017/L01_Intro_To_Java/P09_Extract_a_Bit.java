package Lectures.L99_September_2017.L01_Intro_To_Java;

import java.util.Scanner;

public class P09_Extract_a_Bit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        Integer digit = Integer.valueOf(tokens[0]);
        Integer possition = Integer.valueOf(tokens[1]);

        String[] digitAsBinary = intToBinary(digit);
        System.out.println(digitAsBinary[possition]);



    }

    private static String[] intToBinary(Integer digit) {
        String[] binary = new String[100];
        for (int i = 0; i < 100; ++i, digit /= 2) {
            switch (digit % 2) {
                case 0:
                    binary[i] = "0";
                    break;
                case 1:
                    binary[i] = "1";
                    break;
            }
        }
        return binary;
    }
}
