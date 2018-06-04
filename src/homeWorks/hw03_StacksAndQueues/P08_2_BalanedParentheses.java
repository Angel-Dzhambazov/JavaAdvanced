package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by fluch on 5/2/2017.
 */
public class P08_2_BalanedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        if (input.length % 2 != 0) {
            System.out.println("NO");
            return;
        }
        Deque<Character> openedBrackets = new ArrayDeque<>();
        for (char c : input) {
            if (c == '(' || c == '[' || c == '{') {
                openedBrackets.push(c);
            } else {
                char currentOpenBracket = openedBrackets.pop();
                if (c == ')') {
                    c = '(';
                }
                if (c == ']') {
                    c = '[';
                }
                if (c == '}'){
                    c = '{';
                }
                if (c != currentOpenBracket){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
