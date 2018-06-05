package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        Double output = 0.0;
        for (String element : input) {
            double currentSum = 0.0;
            int firstLetter = (int) element.charAt(0);
            Integer digit = Integer.valueOf(element.substring(1, element.length() - 1));
            int lastLetter = (int) element.charAt(element.length() - 1);
            if (firstLetter <= 90) {
                firstLetter %= 64;
                currentSum += (digit*1.0) / firstLetter;
            } else {
                firstLetter %= 96;
                currentSum += (digit*1.0) * firstLetter;
            }
            if (lastLetter <= 90) {
                lastLetter %= 64;
                currentSum -= lastLetter;
            } else {
                lastLetter %= 96;
                currentSum += lastLetter;
            }
            output += currentSum;
            //System.out.printf("F.Letter value = %d\n digit is = %d\n L.Letter value = %d\n", firstLetter, digit, lastLetter);
        }

        System.out.printf("%.2f",output);

    }
}
