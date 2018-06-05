package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08_MelrahShake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder input = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());

        while (true) {
            if (pattern.length() == 0) {
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
            int firstIndex = input.indexOf(pattern.toString());
            int lastIndex = input.lastIndexOf(pattern.toString());

            if (firstIndex == -1 || lastIndex == -1 || lastIndex == firstIndex) {
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
            input.delete(lastIndex, lastIndex + pattern.length());
            input.delete(firstIndex, firstIndex + pattern.length());

            System.out.println("Shaked it.");

            pattern.deleteCharAt(pattern.length() / 2);
        }
    }
}
