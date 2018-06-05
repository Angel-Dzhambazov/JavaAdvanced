package Lectures.L99_September_2017.L04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Sorting {
    public static void main(String[] args) throws IOException {

        // bubble and selection sort

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

         selectionSort(input);

        //bubbleSort(input);
        // s tekushtite testove v judge s buble dava 85 tochki, garmi za vreme.

        for (int i : input) {
            System.out.printf("%d ", i);
        }

    }

    private static void bubbleSort(int[] input) {
        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[i]) {
                    int temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }
    }
}
