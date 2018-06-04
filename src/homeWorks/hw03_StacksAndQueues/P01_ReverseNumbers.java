package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by fluch on 4/27/2017.
 */
public class P01_ReverseNumbers {
    public static void main(String[] args) {
//        input = 1 2 3 4 5
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> reversed = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            reversed.push(Integer.valueOf(token));
        }
        System.out.print(reversed.poll());
        while (!reversed.isEmpty()){
            System.out.print(" "+ reversed.poll());
        }
    }
}
