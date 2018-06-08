package Lectures.L99_September_2017.L01_Intro_To_Java;

import java.math.BigInteger;
import java.util.Scanner;

public class P07_ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split("\\s+");
        // deklarirame sum da e na4alno 1 zashtoto polzvame umnojenie.
        BigInteger sum = new BigInteger(String.valueOf(1));
        int start = Integer.valueOf(range[0]);
        int end = Integer.valueOf(range[1]);

        for (int i = start; i <= end; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));

        }
        System.out.println("product[" + start + ".." + end + "] = " + sum);
    }
}
