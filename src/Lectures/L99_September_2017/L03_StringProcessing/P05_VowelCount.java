package Lectures.L99_September_2017.L03_StringProcessing;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_VowelCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("[AEIOUYaeiouy]");
        int count = 0;
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        System.out.printf("Vowels: %d", count);
    }
}
