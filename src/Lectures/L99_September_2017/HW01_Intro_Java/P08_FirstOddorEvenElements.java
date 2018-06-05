package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08_FirstOddorEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        String[] get = reader.readLine().split(" ");

        Integer count = Integer.valueOf(get[1]);
        if ("odd".equals(get[2])) {
            for (int i = 0; i < input.length; i++) {
                if (Integer.valueOf(input[i]) % 2 == 1) {
                    System.out.print(input[i] + " ");
                    count--;
                    if (count == 0) {
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < input.length; i++) {
                if (Integer.valueOf(input[i]) % 2 == 0) {
                    System.out.print(input[i] + " ");
                    count--;
                    if (count == 0) {
                        break;
                    }
                }
            }
        }

    }
}
