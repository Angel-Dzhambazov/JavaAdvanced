package Lectures.L99_September_2017.HW04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_NestedLoops {


    private static int numberOfLoops;
    private static int[] loops;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numberOfLoops = Integer.valueOf(reader.readLine());
        loops = new int[numberOfLoops];
        simulateLoops(0);

    }

    private static void simulateLoops(int currentIndex) {
        if (currentIndex == numberOfLoops) {
            printLoop();
            return;
        }
        for (int i = 1; i <= numberOfLoops; i++) {
            loops[currentIndex] = i;
            simulateLoops(currentIndex+1);
        }
    }

    private static void printLoop() {
        System.out.println(Arrays.toString(loops).replaceAll("[\\]\\[,]", ""));
    }

}
