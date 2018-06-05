package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_FormattingNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Integer a = Integer.parseInt(input[0]);
        Double b = Double.parseDouble(input[1]);
        Double c = Double.parseDouble(input[2]);

        String[] digitAsBinary = intToBinary(a);
        StringBuilder binary = makeBinary(digitAsBinary);

        String hex = Integer.toHexString(a).toUpperCase();

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", hex, binary, b, c);


    }

    private static StringBuilder makeBinary(String[] digitAsBinary) {
        StringBuilder binary = new StringBuilder();

        for (String s : digitAsBinary) {
            binary.append(s);
        }
        return binary;
    }


    private static String[] intToBinary(Integer digit) {
        String[] binary = new String[10];
        for (int i = 9; i >= 0; i--, digit /= 2) {
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
