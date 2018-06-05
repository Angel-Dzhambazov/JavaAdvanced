package Lectures.L99_September_2017.L03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(reader.readLine());
        String open = "<upcase>";
        String close = "</upcase>";
        int startIndex = input.indexOf(open);;
        while (startIndex >= 0) {
            int endIndex = input.indexOf(close);
            String firstPart = input.substring(0, startIndex);
            String upperCase = input.substring(startIndex + open.length(), endIndex).toUpperCase();
            String leftover = input.substring(endIndex + close.length(), input.length());
            input = new StringBuilder("");
            input.append(firstPart);
            input.append(upperCase);
            input.append(leftover);
            startIndex = input.indexOf(open);
           }
        System.out.println(input);
    }
}
