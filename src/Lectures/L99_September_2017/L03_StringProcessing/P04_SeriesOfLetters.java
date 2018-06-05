package Lectures.L99_September_2017.L03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04_SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("");
        StringBuilder output = new StringBuilder();
        output.append(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (!input[i-1].equals(input[i])){
                output.append(input[i]);
            }
        }
        System.out.println(output);

    }
}
