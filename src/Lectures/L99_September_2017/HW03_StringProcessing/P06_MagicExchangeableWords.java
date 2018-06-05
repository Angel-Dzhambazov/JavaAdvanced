package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06_MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input  = reader.readLine().split(" ");
        String one = input[0];
        String two = input[1];


        Integer count1 = Math.toIntExact(one.chars().distinct().count());
        Integer count2 = Math.toIntExact(two.chars().distinct().count());


        if (count1 == count2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }

}
