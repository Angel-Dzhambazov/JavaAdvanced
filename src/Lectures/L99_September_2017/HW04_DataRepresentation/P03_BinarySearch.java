package Lectures.L99_September_2017.HW04_DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] array = reader.readLine().split("\\s+");

        int[] inputAsInt = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            inputAsInt[i] = Integer.valueOf(array[i]);
        }

        int index = Integer.valueOf(reader.readLine());
        int result = binarySearch(inputAsInt,index);
        System.out.println(result);
    }

    private static int binarySearch(int[] a, int digit) {
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
}
