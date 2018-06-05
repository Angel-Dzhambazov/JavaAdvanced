package Lectures.L07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_Non_Digit_Count {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(reader.readLine());

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Non-digits: " + counter);
    }
}
