package Lectures.L07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_Valid_Time {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^([0-9]{1,2}):([0-9]{2}):([0-9]{2}) [AP]M$");

        String currentLine = reader.readLine();
        while (!"END".equals(currentLine)) {

            Matcher matcher = pattern.matcher(currentLine);
            if (matcher.find()) {

                int hour = Integer.valueOf(matcher.group(1));
                int minutes = Integer.valueOf(matcher.group(2));
                int seconds = Integer.valueOf(matcher.group(3));

                if(validTime(hour,minutes,seconds)){
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }

            } else {
                System.out.println("invalid");
            }
            currentLine = reader.readLine();
        }

    }

    private static boolean validTime(int hour, int minutes, int seconds) {
        if (!(1<=hour && hour<=12)){
            return false;
        }
        if (!(0<=minutes&&minutes<=50)){
            return false;
        }
        if (!(0<=seconds&&seconds<=59)){
            return false;
        }

        return  true;
    }
}
