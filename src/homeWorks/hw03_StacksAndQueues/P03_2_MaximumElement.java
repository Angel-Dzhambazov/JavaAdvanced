package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by fluch on 4/30/2017.
 */

public class P03_2_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        Deque<Integer> maxNumber = new ArrayDeque<>();

        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < commands; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            String commandType = commandLine[0];



            switch (commandType) {
                case "1":
                    int number = Integer.parseInt(commandLine[1]);
                    stack.push(number);
                    if (number >= maxElement) {
                        maxElement = number;
                        maxNumber.push(number);
                    }
                    break;
                case "2":
                    int currentNum = stack.pop();
                    if (currentNum == maxElement){
                        maxNumber.pop();
                        if (!maxNumber.isEmpty()){
                            maxElement = maxNumber.peek();
                        } else {
                            maxElement = Integer.MIN_VALUE;
                        }
                    }
                    break;
                case "3":
                    System.out.println(maxNumber.peek());
            }
        }
    }
}
