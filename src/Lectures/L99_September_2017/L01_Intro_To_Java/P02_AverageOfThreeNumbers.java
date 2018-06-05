package Lectures.L99_September_2017.L01_Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_AverageOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("\\s+");
        Double sum = 0.0;
        for (int i = 0; i < 3; i++) {

            sum += Double.parseDouble(line[i]);
        }
        sum = sum / 3;
        System.out.printf("%.2f", sum);
    }

}
