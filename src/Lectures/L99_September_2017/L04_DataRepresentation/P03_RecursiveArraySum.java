package Lectures.L99_September_2017.L04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03_RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int result = sum(input, 0);
        System.out.println(result);

    }

    private static int sum(int[] input, int i) {
        if (i == input.length - 1) {
            return input[i];
        }
        return input[i] + sum(input, i + 1);
    }
}
