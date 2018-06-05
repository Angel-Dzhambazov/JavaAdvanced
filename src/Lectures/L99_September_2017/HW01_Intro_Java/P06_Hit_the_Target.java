package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P06_Hit_the_Target{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer target = Integer.parseInt(reader.readLine());

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                if (i+j==target){
                    System.out.printf("%d + %d = %d\n",i,j,target);
                }
            }
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                if (i-j==target){
                    System.out.printf("%d - %d = %d\n",i,j,target);
                }
            }
        }
    }
}
