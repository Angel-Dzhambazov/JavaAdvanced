package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by fluch on 4/30/2017.
 */
public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split("\\s+");
        String[] tokens = scanner.nextLine().split("\\s+");
        int coutOfElements = Integer.valueOf(inputData[0]);
        int amountToPop = Integer.valueOf(inputData[1]);
        int neo = Integer.valueOf(inputData[2]);
        ArrayDeque<Integer> input = new ArrayDeque<>();

        for (String token : tokens) {
            input.push(Integer.valueOf(token));
        }

        for (int i = 0; i <amountToPop ; i++) {
            input.pop();
        }

        boolean output = input.contains(neo);
        if (output){
            System.out.println("true");
        } else if (!input.isEmpty()){
            int minValue = Integer.MAX_VALUE;
            for (Integer integer : input) {
                if (minValue>integer){
                    minValue = integer;
                }

            }
            System.out.println(minValue);

        } else if(input.isEmpty()){
            System.out.println(0);
        }


    }
}
