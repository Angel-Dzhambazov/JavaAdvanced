package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P04_UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();


        StringBuilder b = new StringBuilder();

        for (char c : input.toCharArray()) {
            b.append("\\u").append(String.format("%04x", (int) c));
            //b.append("\\u").append(Integer.toHexString(c));
        }
        System.out.println(b);

    }
}
