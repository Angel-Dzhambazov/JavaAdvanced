package Lectures.L03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by fluch on 5/2/2017.
 */
public class P01_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> reversed = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            reversed.push(String.valueOf(c));
        }
        while (!reversed.isEmpty()){
            System.out.print(reversed.poll());
        }

    }
}
