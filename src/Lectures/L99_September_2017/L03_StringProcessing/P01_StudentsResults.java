package Lectures.L99_September_2017.L03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" - ");
        String name = input[0];
        String[] grades = input[1].split(", ");
        double jAdv = Double.parseDouble(grades[0]);
        double jOOP = Double.parseDouble(grades[1]);
        double advOOP = Double.parseDouble(grades[2]);
        double average = (jAdv + jOOP + advOOP) / 3.0;
        System.out.println("Name      |   JAdv|JavaOOP| AdvOOP|Average|");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", name, jAdv, jOOP, advOOP, average);


    }
}
