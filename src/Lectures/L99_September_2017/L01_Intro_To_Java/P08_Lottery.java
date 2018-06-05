package Lectures.L99_September_2017.L01_Intro_To_Java.L01_Intro;

import java.util.Scanner;

public class P08_Lottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 8; i++) {
            for (int j = i + 1; j <= 9; j++) {
                for (int k = j + 1; k <= 10; k++) {
                    System.out.println(i + " " + j + " " + k);
                }

            }
        }
    }
}
