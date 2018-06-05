package Lectures.L02_MultidimentionalArrays.ExamPreps.Java_2016_05May_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class P02_RoyalNonStop {

    public static Integer[][] MATRIX;

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimentions = reader.readLine().split(" ");
        Integer x = Integer.parseInt(dimentions[0]);
        Integer y = Integer.parseInt(dimentions[1]);

        String[] lukankaAndRakiya = reader.readLine().split(" ");
        BigDecimal lukanka = new BigDecimal(lukankaAndRakiya[0]);
        BigDecimal rakiya = new BigDecimal(lukankaAndRakiya[1]);
        BigDecimal sum = BigDecimal.ZERO;

        Integer customers = 0;
        String currentLine = reader.readLine();
        while (!"Royal Close".equals(currentLine)) {
            String[] customer = currentLine.split(" ");
            Integer x1 = Integer.valueOf(customer[0]);
            Integer y1 = Integer.valueOf(customer[1]);
            sum = sum.add(doMagic(x1, y1, lukanka, rakiya));
            customers++;
            currentLine = reader.readLine();
        }


        System.out.printf("%.6f", sum);
        System.out.println();

        System.out.println(customers);


    }

    private static BigDecimal doMagic(Integer x1, Integer y1, BigDecimal lukanka, BigDecimal rakiya) {
        BigDecimal sum = BigDecimal.ZERO;

        if (x1 >= y1) {
            for (int i = 1; i <= y1 + 1; i++) {
                if (x1 % 2 == 1) {
                    //rakiya
                    BigDecimal tempSum = rakiya.multiply(new BigDecimal(i * x1 + 1));
                    sum = sum.add(tempSum);
                } else {
                    sum = sum.add(lukanka.multiply(new BigDecimal(i * y1+1)));
                }
            }
            for (int i = x1 - 1; i > 0; i--) {
                if (i % 2 == 1) {
                    //rakiya
                    sum = sum.add(rakiya.multiply(new BigDecimal(i)));
                } else {
                    sum = sum.add(lukanka.multiply(new BigDecimal(i)));
                }
            }
        } else {
            for (int i = x1; i > 0; i--) {
                if (i % 2 == 1) {
                    //rakiya
                    sum = sum.add(rakiya.multiply(new BigDecimal(i * y1)));
                } else {

                    sum = sum.add(lukanka.multiply(new BigDecimal(i * y1)));
                }
            }
            for (int i = y1 - 1; i < 1; i--) {
                if (i % 2 == 1) {
                    //rakiya
                    sum = sum.add(rakiya.multiply(new BigDecimal(i)));
                } else {
                    sum = sum.add(lukanka.multiply(new BigDecimal(i)));
                }
            }
        }
        return sum;
    }


}
