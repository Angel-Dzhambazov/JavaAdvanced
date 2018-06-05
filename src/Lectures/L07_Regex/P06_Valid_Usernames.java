package Lectures.L07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_Valid_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");

        String currentLine = reader.readLine();
        while (!"END".equals(currentLine)){

            Matcher matcher = pattern.matcher(currentLine);

            if (matcher.find()){
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            currentLine = reader.readLine();
        }
    }
}
