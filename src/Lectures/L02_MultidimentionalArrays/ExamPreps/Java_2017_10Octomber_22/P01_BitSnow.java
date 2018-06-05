package Lectures.L02_MultidimentionalArrays.ExamPreps.Java_2017_10Octomber_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class P01_BitSnow {
    private static boolean DO_WE_END = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        for (int i = 0; i < input.length; i++) {
            boolean doWeEnd = false;
            makeItSnow(input);
            if (DO_WE_END) {
                break;
            }
        }
        System.out.println(String.join(", ", input));
    }

    private static void makeItSnow(String[] input) {
        String[] tempString = new String[input.length];

        for (int i = 0; i < tempString.length; i++) {
            tempString[i] = input[i];
        }
        for (int i = input.length - 1; i > 0; i--) {
            BigInteger bottom = new BigInteger(input[i - 1]);
            BigInteger preBottom = new BigInteger(input[i]);
            BigInteger last = bottom.or(preBottom);
            BigInteger preLast = bottom.and(preBottom);
            input[i - 1] = preLast.toString();
            input[i] = last.toString();
        }
        DO_WE_END = compareArrays(tempString, input);
    }


    public static boolean compareArrays(String[] array1, String[] array2) {

        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].equals(array2[i])) {
                count++;
            }
        }
        return count == array1.length;
    }

}
