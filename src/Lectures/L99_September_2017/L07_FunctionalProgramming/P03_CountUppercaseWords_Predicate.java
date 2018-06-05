package Lectures.L99_September_2017.L07_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class P03_CountUppercaseWords_Predicate {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        ArrayList<String > output = new ArrayList<>();

        Predicate<String> checkForUppercaseLetter = x -> Character.isUpperCase(x.charAt(0));
        for (String s : input) {
            if (checkForUppercaseLetter.test(s)){
                output.add(s);
            }
        }
        System.out.println(output.size());
        for (String s : output) {
            System.out.println(s);
        }
    }
}
