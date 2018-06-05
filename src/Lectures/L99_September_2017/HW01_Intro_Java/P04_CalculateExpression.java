package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04_CalculateExpression {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Double a = Double.parseDouble(input[0]);
        Double b = Double.parseDouble(input[1]);
        Double c = Double.parseDouble(input[2]);

        Double f1 = calculateF1(a, b, c);
        Double f2 = calculateF2(a, b, c);
        Double diff = calculateDiff(a, b, c, f1, f2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);

    }

    private static Double calculateDiff(Double a, Double b, Double c, Double f1, Double f2) {
        Double avg1 = (a + b + c) / 3.0;
        Double avg2 = (f1 + f2) / 2.0;
        Double diff = Math.abs(avg1 - avg2);
        return diff;
    }

    private static Double calculateF2(Double a, Double b, Double c) {
        Double basis = (a * a + b * b - c * c * c);
        Double power = a - b;
        Double result = Math.pow(basis, power);
        return result;

    }

    private static Double calculateF1(Double a, Double b, Double c) {
        Double basis = ((a * a + b * b) / (a * a - b * b));
        Double power = (a + b + c) / (Math.sqrt(c));
        Double result = Math.pow(basis, power);
        return result;
    }

}
