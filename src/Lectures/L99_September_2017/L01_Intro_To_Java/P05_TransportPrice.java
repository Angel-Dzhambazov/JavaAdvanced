package Lectures.L99_September_2017.L01_Intro;

import java.util.Scanner;

public class P05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer distance = Integer.valueOf(scanner.nextLine());
        String time = scanner.nextLine();

        if (distance < 20) {
            if ("day".equals(time)) {
                System.out.printf("%.2f", (0.7 + distance * 0.79));
            } else {
                System.out.printf("%.2f", (0.7 + distance * 0.9));
            }
        } else if (distance < 100) {
            System.out.printf("%.2f", distance * 0.09);
        } else {
            System.out.printf("%.2f", distance * 0.06);
        }
    }
}
