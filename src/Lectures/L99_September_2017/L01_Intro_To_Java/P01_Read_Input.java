package Lectures.L99_September_2017.L01_Intro_To_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P01_Read_Input {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        String firstW = scanner.next("\\w+");
        String firstS = scanner.next("\\w+");


        int sum = 0;

        Integer currentInt1 = scanner.nextInt();
        Integer currentInt2 = scanner.nextInt();
        Integer currentInt3 = scanner.nextInt();
        sum = currentInt1 + currentInt2 + currentInt3;


        String thirdWord = scanner.next("\\w+");


        System.out.print(firstW + " " + firstS + " " + thirdWord + " " + sum);


    }

}
