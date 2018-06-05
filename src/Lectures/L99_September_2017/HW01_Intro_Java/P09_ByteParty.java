package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P09_ByteParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer bitSize = Integer.valueOf(reader.readLine());

        Integer[][] bits = new Integer[3][8];
        for (int i = 0; i < bitSize; i++) {
            bits[i] = intToBinary(Integer.valueOf(reader.readLine()));
        }
        String currentLine = reader.readLine();
        while (!"party over".equals(currentLine)) {
            String[] tokens = currentLine.split(" ");
            switch (tokens[0]) {
                case "-1":
                    changeBitValue(bits, tokens[1]);
                    break;
                case "0":
                    fillZeroes(bits, tokens[1]);
                    break;
                case "1":
                    fillOnes(bits, tokens[1]);
                    break;
            }
            currentLine = reader.readLine();
        }
        printResult(bits);
      }

    private static void printResult(Integer[][] bits) {
        for (int i = 0; i < bits.length; i++) {
            Integer currentDigit = 0;
            StringBuilder binary = new StringBuilder("");
            for (int j = bits[i].length - 1; j >= 0; j--) {
                binary.append(bits[i][j]);
            }
            Integer currentNumber = Integer.parseInt(binary.toString(), 2);
              System.out.println(currentNumber);
        }
    }

    private static void fillOnes(Integer[][] bits, String token) {
        Integer columnToChange = Integer.valueOf(token);
        for (int i = 0; i < bits.length; i++) {
            bits[i][columnToChange] = 1;
        }
    }

    private static void fillZeroes(Integer[][] bits, String token) {
        Integer columnToChange = Integer.valueOf(token);
        for (int i = 0; i < bits.length; i++) {
            bits[i][columnToChange] = 0;
        }
    }

    private static void changeBitValue(Integer[][] bits, String token) {
        Integer columnToChange = Integer.valueOf(token);
        for (int i = 0; i < bits.length; i++) {
            if (bits[i][columnToChange] == 0) {
                bits[i][columnToChange] = 1;
            } else {
                bits[i][columnToChange] = 0;
            }
        }
    }

    private static void print(Integer[][] bits) {
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < bits[0].length; j++) {
                System.out.print(bits[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Integer[] intToBinary(Integer digit) {
        Integer[] binary = new Integer[10];
        for (int i = 0; i < 10; i++, digit /= 2) {
            switch (digit % 2) {
                case 0:
                    binary[i] = 0;
                    break;
                case 1:
                    binary[i] = 1;
                    break;
            }
        }
        return binary;
    }
}
