package Lectures.L99_September_2017.L01_Intro;

import java.util.Scanner;

public class P04_Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine().trim();
        String name1 = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = "*****";
        }
        if (name1.isEmpty()) {
            name1 = "*****";
        }
        System.out.println("Hello, " + name + " " + name1+"!");

    }
}
