package Lectures.L99_September_2017.L07_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P02_SumNumbers_Function {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        Integer output = 0;

        Function<String, Integer> parse = s -> Integer.valueOf(s);

        for (String s : input) {
            output+=parse.apply(s);
        }
        System.out.printf("Count = %d\nSum = %d", input.length, output);


    }
}






