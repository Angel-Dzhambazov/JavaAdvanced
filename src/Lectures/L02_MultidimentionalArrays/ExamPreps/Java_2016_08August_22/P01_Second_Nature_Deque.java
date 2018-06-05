package Lectures.L02_MultidimentionalArrays.ExamPreps.Java_2016_08August_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P01_Second_Nature_Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] flowers = reader.readLine().split(" ");
        String[] waterBuckets = reader.readLine().split(" ");

        Deque<Integer> flowersQueue = new ArrayDeque<>();
        Deque<Integer> secondNature = new ArrayDeque<>();
        Deque<Integer> waterStack = new ArrayDeque<>();
        for (int i = 0; i < flowers.length; i++) {
            flowersQueue.offer(Integer.valueOf(flowers[i]));
        }
        for (int i = 0; i < waterBuckets.length; i++) {
            waterStack.push(Integer.valueOf(waterBuckets[i]));
        }
        Integer extraWater = 0;
        Integer currentBucket = 0;

        // Watering the flowers
        while (!flowersQueue.isEmpty() && !waterStack.isEmpty()) {
            Integer currentFlower = flowersQueue.poll();
            if (extraWater >= 0) {
                currentBucket = waterStack.pop() + extraWater;
            } else if (extraWater < 0) {
                currentBucket = extraWater * (-1);
            }
            extraWater = currentBucket - currentFlower;
            if (flowersQueue.isEmpty() && extraWater > 0) {
                if (!waterStack.isEmpty()) {
                    extraWater += waterStack.pop();
                    waterStack.push(extraWater);
                } else {
                    waterStack.push(extraWater);
                }
            }
            if (extraWater == 0) {
                secondNature.offer(currentFlower);
            }
        }


        while (!waterStack.isEmpty()) {
            if (waterStack.isEmpty()) {
                System.out.print(waterStack.pop());
            } else {
                System.out.print(waterStack.pop() + " ");
            }

        }
        while (!flowersQueue.isEmpty()) {
            System.out.print(flowersQueue.poll() + " ");
        }
        System.out.println();
        if (secondNature.isEmpty()) {
            System.out.print("None");
        }
        while (!secondNature.isEmpty()) {
            System.out.print(secondNature.poll() + " ");
        }


    }
}
