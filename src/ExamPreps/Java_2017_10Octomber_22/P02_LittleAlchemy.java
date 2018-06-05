package ExamPreps.Java_2017_10Octomber_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer[] digits = new Integer[input.length];
        Deque<Integer> elements = new ArrayDeque<>();
        cloneArrays(input, digits, elements);
        int count = 0;


        while (true) {
            String[] currentLine = reader.readLine().split("\\s+");
            if ("Revision".equals(currentLine[0])) {
                break;
            }
            if ("Apply".equals(currentLine[0])) {


                for (int i = 0; i < Integer.valueOf(currentLine[2]); i++) {
                    if (elements.isEmpty()){
                        break;
                    }
                    int currentElement = elements.poll();
                    if (currentElement > 1) {
                        currentElement--;
                        elements.offer(currentElement);
                    } else {
                        count++;
                    }
                }
            } else if (count > 0) {
                elements.offer(Integer.valueOf(currentLine[2]));
                count--;
            }
        }
        while (!elements.isEmpty()) {
            System.out.print(elements.poll() + " ");
        }
        System.out.println();
        System.out.println(count);

    }


    private static void cloneArrays(String[] input, Integer[] digits, Deque<Integer> elements) {
        for (int i = 0; i < input.length; i++) {
            digits[i] = Integer.valueOf(input[i]);
            elements.offer(digits[i]);
        }
    }
}
