package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by fluch on 5/2/2017.
 */
public class P08_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();

        Deque<Character> openBrackets = new ArrayDeque<>();
        if (input.length % 2 != 0) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < input.length / 2; i++) {
            if (input[i] == '(' || input[i] == '[' || input[i] == '{'){
                openBrackets.push(input[i]);
            } else {
                System.out.println("NO");
                return;
            }
        }
        for (int i = input.length / 2; i < input.length; i++) {
            char openedChar = openBrackets.pop();
            switch (input[i]) {
                case ')':
                    if (openedChar != '(') {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case ']':
                    if (openedChar != '[') {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case '}':
                    if (openedChar != '{') {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case '(': System.out.println("NO"); return;
                case '[': System.out.println("NO"); return;
                case '{': System.out.println("NO"); return;
            }
        }
        System.out.println("YES");
    }
}
