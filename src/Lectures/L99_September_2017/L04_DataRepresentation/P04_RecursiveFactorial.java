package Lectures.L99_September_2017.L04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04_RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer digit = Integer.valueOf(reader.readLine());

        Long result = calculate(digit);
        System.out.println(result);
    }

    private static Long calculate(Integer digit) {
        if (digit <= 1) {
            return Long.valueOf(1);
        }
        return Long.valueOf(digit) * calculate(digit - 1);
    }
}
