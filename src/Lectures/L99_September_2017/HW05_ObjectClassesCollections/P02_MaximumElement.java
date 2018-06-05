package Lectures.L99_September_2017.HW05_ObjectClassesCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P02_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Integer maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] commands = reader.readLine().split(" ");
            switch (commands[0]) {
                case "1":
                    Integer currentInt = Integer.valueOf(commands[1]);
                    stack.push(currentInt);
                    if (currentInt > maxElement) {
                        maxElement = currentInt;
                    }
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
//                    maxElement = Integer.valueOf(stack.stream().mapToInt(Integer::intValue).max() + "");
                    printMaxElement(stack);
                    break;
            }
        }
    }

    private static void printMaxElement(ArrayDeque<Integer> stack) {
        if (!stack.isEmpty()){
            String minValue = (stack.stream().mapToInt(Integer::intValue).max() + "");
            String toPrint = minValue.substring(12, minValue.length()-1);
            System.out.println(toPrint);

        }
    }
}
