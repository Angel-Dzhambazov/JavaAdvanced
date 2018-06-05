package Lectures.L99_September_2017.L03_StringProcessing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P07_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");


        StringBuilder output = new StringBuilder();
        boolean shouldWePrintAtAll = false;
        while (!"END".equals(input)) {
            boolean didWeFind = false;

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                output.append("valid\n");
                didWeFind = true;
                shouldWePrintAtAll = true;
            }
            if (!didWeFind) {
                output.append("invalid\n");
            }

            input = reader.readLine();
        }
        if (shouldWePrintAtAll){
            System.out.println(output);
        }


    }
}
