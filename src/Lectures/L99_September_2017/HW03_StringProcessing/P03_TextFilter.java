package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");
        StringBuilder input = new StringBuilder(reader.readLine());


        for (String word : bannedWords) {
            StringBuilder stars = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                stars.append("*");
            }
            int startIndex = input.indexOf(word);
            while (startIndex >= 0) {
                int endIndex = startIndex + word.length();
                String firstPart = input.substring(0, startIndex);
                String leftover = input.substring(endIndex, input.length());
                input = new StringBuilder("");
                input.append(firstPart);
                input.append(stars);
                input.append(leftover);
                startIndex = input.indexOf(word);

            }

        }
        System.out.println(input);
    }
}
