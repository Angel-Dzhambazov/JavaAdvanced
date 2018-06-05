package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P07_CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer minLength = Math.min(input[0].length(), input[1].length());

        Integer sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += input[0].charAt(i) * input[1].charAt(i);
        }
        if (input[0].length() != input[1].length()) {
            if (input[0].length() > input[1].length()) {
                for (int i = minLength; i < input[0].length(); i++) {
                    sum += input[0].charAt(i);
                }
            } else {
                for (int i = minLength; i < input[1].length(); i++) {
                    sum += input[1].charAt(i);
                }
            }
        }
        System.out.println(sum);

    }
}
