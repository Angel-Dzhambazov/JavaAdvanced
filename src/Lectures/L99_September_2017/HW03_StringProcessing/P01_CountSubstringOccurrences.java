package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toLowerCase();

        String regex = reader.readLine().toLowerCase();
        String updatedRegex = "(?=(" + regex + ")).";
        Pattern pattern = Pattern.compile(updatedRegex);
        Matcher matcher = pattern.matcher(input);

        int count = 0;

        while (matcher.find()) {
            count++;
        }
        System.out.println(count);

    }
}
