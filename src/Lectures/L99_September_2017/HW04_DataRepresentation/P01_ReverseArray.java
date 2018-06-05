package Lectures.L99_September_2017.HW04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(input[i] + " ");
        }


    }


}
