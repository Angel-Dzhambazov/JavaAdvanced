package Lectures.L02_MultidimentionalArrays.ExamPreps.C_Sharp_19_July_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fluch on 5/19/2017.
 */
public class tests {
    public static void main(String[] args) throws IOException {





        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for (String s : input) {
            list.add(Integer.parseInt(s));
        }

        int offset = Integer.parseInt(reader.readLine());
        int currentIndex = 0;


        while (offset!=16){
            currentIndex = Math.abs((currentIndex+ offset) % list.size());
            System.out.println(currentIndex);


            if (offset<0){
                currentIndex = list.size()-currentIndex;
                System.out.println(currentIndex);
            }
            offset = Integer.parseInt(reader.readLine());
        }

    }
}
