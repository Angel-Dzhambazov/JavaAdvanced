package Lectures.L03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by fluch on 5/2/2017.
 */
public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        while (stack.size() > 1) {
            Integer first = Integer.valueOf(stack.pop());

            String operator = stack.pop();
            Integer second = Integer.valueOf(stack.pop());
            if ("+".equals(operator)) {
                stack.push(String.valueOf(first + second));
            } else if ("-".equals(operator)) {
                stack.push(String.valueOf(first - second));
            }
        }
        System.out.println(stack.peek());

    }
}
