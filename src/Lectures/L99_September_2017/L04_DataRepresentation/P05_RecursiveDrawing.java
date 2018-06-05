package Lectures.L99_September_2017.L04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class P05_RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer digit = Integer.valueOf(reader.readLine());

        pleaseDraw(digit);


    }

    private static void pleaseDraw(Integer digit) {

        //base
        if (digit <= 0) {
            return;
        }
        //pre
        System.out.println(String.join("", Collections.nCopies(digit, "*")));
        //recurcion
        pleaseDraw(digit - 1);
        System.out.println(String.join("", Collections.nCopies(digit, "#")));

    }
}