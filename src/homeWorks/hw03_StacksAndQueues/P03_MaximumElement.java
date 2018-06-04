package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by fluch on 4/30/2017.
 */
public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.valueOf(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        Deque<Integer> maxValueDeque = new ArrayDeque<>();


        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfLines; i++) {

            String[] currentLine = scanner.nextLine().split(" ");
            String command = currentLine[0];

            switch (command) {
                case "1":
                    int currentInt = Integer.valueOf(currentLine[1]);
                    stack.push(currentInt);
                    if (currentInt >= maxValue) {
                        maxValue = currentInt;
                        maxValueDeque.push(maxValue);
                    }
                    break;
                case "2":
                    int currentNum = stack.pop();
                    if (currentNum == maxValue) {
                        maxValueDeque.pop();
                        if (!maxValueDeque.isEmpty()) {
                            maxValue = maxValueDeque.peek();
                        } else {
                            maxValue = Integer.MIN_VALUE;
                        }
                    }
                    break;
                case "3":
                    System.out.println(maxValueDeque.peek());
                    break;
            }
        }
    }
}
