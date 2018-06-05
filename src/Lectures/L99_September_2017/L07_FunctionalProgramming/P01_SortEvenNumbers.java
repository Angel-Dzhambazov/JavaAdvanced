package Lectures.L99_September_2017.L07_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class P01_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String digit : input) {
            Integer currentDigit = Integer.valueOf(digit);
            numbers.add(currentDigit);
        }
        numbers.removeIf(elementInTheNumbersArrayList -> elementInTheNumbersArrayList % 2 != 0);


        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(numbers.size() - 1));

        numbers.sort((n, m) -> n.compareTo(m));
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(numbers.size() - 1));



    }
}
