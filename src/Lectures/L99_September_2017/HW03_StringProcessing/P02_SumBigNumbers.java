package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split("");
        String[] second = reader.readLine().split("");

        StringBuilder output = new StringBuilder();
        Integer reminder = 0;
        if (second.length > first.length) {
            String[] third = first;
            first = second;
            second = third;
        }

        if (first.length >= second.length) {
            int difference = first.length - second.length;
            for (int i = first.length - 1; i >= difference; i--) {
                Integer result = Integer.valueOf(first[i]) + Integer.valueOf(second[i - difference]);
                int a = result % 10 + reminder;
                if (a >= 10) {
                    reminder = a / 10;
                    a %= 10;
                } else {
                    reminder = result / 10;
                }
                output.append(a);
            }
            for (int i = difference - 1; i >= 0; i--) {
                Integer result = Integer.valueOf(first[i]);
                int a = result % 10 + reminder;

                if (a >= 10) {
                    reminder = a / 10;
                    a %= 10;
                } else {
                    reminder = result / 10;
                }
                output.append(a);
                if (i == 0 && reminder != 0) {
                    output.append(reminder);
                }
            }
        }


        System.out.println(output.reverse());


    }
}
