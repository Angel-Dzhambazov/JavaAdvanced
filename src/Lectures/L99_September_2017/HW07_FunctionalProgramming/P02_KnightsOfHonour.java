package Lectures.L99_September_2017.HW07_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class P02_KnightsOfHonour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        Consumer<Object> c1 = x -> System.out.println("Sir " + x);
        for (String s : input) {
            c1.accept(s);
        }
    }
}
