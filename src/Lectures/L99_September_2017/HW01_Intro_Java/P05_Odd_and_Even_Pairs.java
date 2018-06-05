package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05_Odd_and_Even_Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        if (input.length % 2 == 1) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < input.length - 1; i+=2) {
                Integer a = Integer.parseInt(input[i]);
                Integer b = Integer.parseInt(input[i + 1]);
                System.out.printf("%d, %d -> ", a, b);
                if (a%2 == b%2){
                    if (a%2 == 1){
                        System.out.println("both are odd");

                    } else {
                        System.out.println("both are even");
                    }
                } else {
                    System.out.println("different");
                }

            }
        }
    }
}
