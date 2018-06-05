package Lectures.L99_September_2017.L04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int digit = Integer.valueOf(reader.readLine());


        // linear search
        // int index = linearSearch(a, digit);

        // binary search
        int index = binarySearch(a, digit);
        System.out.println(index);

    }

    private static int binarySearch(int[] a, int digit) {
    //    selectionSort(a);
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (a[middle] < digit) {
                start = middle + 1;
            } else if (a[middle] > digit) {
                end = middle - 1;
            } else if (a[middle] == digit) {
                return middle;
            }
        }
        return -1;
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    private static int linearSearch(int[] a, int digit) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == digit) {
                return i;
            }
        }
        return -1;
    }
}
