package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by fluch on 5/2/2017.
 */
public class P05_CalculateSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());

        Deque<Long> sequence = new ArrayDeque<>();

        sequence.add(number);
        for (int i = 0; i < 50; i++) {
            Long element = sequence.poll();
            System.out.printf("%d ", element);
            long s2 = element + 1;
            long s3 = 2 * element + 1;
            long s4 = element + 2;

            sequence.add(s2);
            sequence.add(s3);
            sequence.add(s4);

        }
    }
}
