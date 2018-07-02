package Lectures.L07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Intro {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile(reader.readLine());
        Matcher matcher = pattern.matcher(reader.readLine());

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println( counter);


    }

    public static class P05_Extract_Tags {
        public static void main (String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            Pattern pattern = Pattern.compile("<.+?>");
            String currentLine = reader.readLine();
            while (!"END".equals(currentLine)){
                Matcher matcher = pattern.matcher(currentLine);
                while (matcher.find()){
                    System.out.println(matcher.group());
                }
                currentLine = reader.readLine();
            }

        }
    }
}
