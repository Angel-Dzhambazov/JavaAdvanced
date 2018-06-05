package Lectures.L99_September_2017.L01_Intro;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03_EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double bgn = Double.parseDouble(scanner.nextLine()) * 1.2;


        BigDecimal rate = new BigDecimal(4210500000000.00);
        BigDecimal newBGN = new BigDecimal(bgn);
        BigDecimal result = rate.multiply(BigDecimal.valueOf(bgn));


        System.out.printf("%.2f marks", result);


    }
}
