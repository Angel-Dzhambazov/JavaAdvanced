package Lectures.L99_September_2017.L07_FunctionalProgramming;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P04_AddVAT_Function {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        Function<String, Double> vat = x -> Double.parseDouble(x) * 1.2;
        System.out.println("Prices with VAT:");
        for (String s : input) {
            System.out.println(String.format("%.2f", vat.apply(s)).replaceAll("\\.", ","));
        }
    }
}
