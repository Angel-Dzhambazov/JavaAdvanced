package Lectures.L02_MultidimentionalArrays.ExamPreps.C_Sharp_19_July_2015;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P02_ArraySlider {

    private static List<BigInteger> List = new ArrayList<>();
    private static Integer currentIndex = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().trim().split("\\s+");
        for (String s : input) {
            List.add(new BigInteger(s));
        }
        String command = reader.readLine();
        while (!command.equals("stop")) {
            String[] reminder = command.trim().split("\\s+");
            int offset = Integer.parseInt(reminder[0]);
            String operation = reminder[1];
            BigInteger operand = new BigInteger(reminder[2]);

            findIndex(offset);
            //currentIndex = Math.abs((currentIndex + offset) % List.size());

            operationExecute(operation, operand);
            command = reader.readLine();
        }


        System.out.println(List);
    }

    private static void operationExecute(String operation, BigInteger operand) {
        switch (operation) {
            case "&":
                List.set(currentIndex, (List.get(currentIndex).and(operand)));
                break;
            case "|":
                List.set(currentIndex, (List.get(currentIndex).or(operand)));
                break;
            case "^":
                List.set(currentIndex, (List.get(currentIndex).xor(operand)));
                break;
            case "+":
                List.set(currentIndex, (List.get(currentIndex).add(operand)));
                break;
            case "-":
                List.set(currentIndex, (List.get(currentIndex).subtract(operand)));

                if (List.get(currentIndex).compareTo(BigInteger.ZERO) < 0) {
                    List.set(currentIndex, BigInteger.ZERO);
                }
                break;
            case "*":
                List.set(currentIndex, (List.get(currentIndex).multiply(operand)));
                break;
            case "/":
                List.set(currentIndex, (List.get(currentIndex).divide(operand)));
                break;
        }
    }

    private static void findIndex(int offset) {
        currentIndex = ((currentIndex + offset) % List.size()) >= 0 ?
                (currentIndex + offset) % List.size() :
                List.size() + (currentIndex + offset) % List.size();

    }
}
