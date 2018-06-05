package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();
        String currentLine = reader.readLine();
        while (!"end".equals(currentLine)) {
            sb.append(currentLine).append(System.getProperty("line.separator"));
            currentLine = reader.readLine();
        }
        Pattern pattern = Pattern.compile("(?:^|\\s)([a-zA-Z][\\w\\.-]+)@([a-zA-Z-]+(?:(?:\\.[a-zA-Z]+\\.[a-zA-Z]+)|(?:\\.[a-zA-Z]+)))");
        Matcher matcher = pattern.matcher(sb);


        while (matcher.find()) {

            //String currentEmail = matcher.group().trim();
            System.out.println(matcher.group().trim());
        }
    }
}
