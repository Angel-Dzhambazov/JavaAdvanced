package ExamPreps.Exam_03_May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P02_Letter_Expression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("");
        StringBuilder number = new StringBuilder("");
        StringBuilder operand = new StringBuilder("");
        Deque sequence = new ArrayDeque();

        boolean didWePutADIGIT = false;
        for (int i = 0; i < input.length; i++) {
            String currentSymbol = input[i];
            if (isADigit(currentSymbol)) {
                if (didWePutADIGIT) {
                    String currentOperand = operand.toString();
                    sequence.add(currentOperand);
                    operand.delete(0, operand.length());
                    didWePutADIGIT = false;
                }
                number.append(currentSymbol);
                if (i == input.length - 1) {
                    String currentDigit = number.toString();
                    sequence.add(currentDigit);
                }

            } else {
                if (!didWePutADIGIT) {
                    String currentDigit = number.toString();
                    sequence.add(currentDigit);
                    number.delete(0, number.length());
                    didWePutADIGIT = true;
                }
                operand.append(currentSymbol);
            }
        }
        Double sum = 0.0;
        Integer count = 0;
        Boolean operandIsPlus = true;
        while (!sequence.isEmpty()) {
            count++;

            if (count % 2 != 0) {
                Double currentDigit = Double.parseDouble(sequence.pop().toString());
                //System.out.println(currentDigit);
                if (count == 1) {
                    sum += currentDigit;
                } else if (operandIsPlus) {
                    sum += currentDigit;
                } else {
                    sum -= currentDigit;
                }
            } else {
                String currentOperand = sequence.pop().toString();
                if (currentOperand.length() % 2 != 0) {
                    operandIsPlus = false;
                } else {
                    operandIsPlus = true;
                }
            }

        }

        if (sum % 1 == 0) {
            System.out.println(sum.intValue());
        } else {
            System.out.printf("%.7f",sum);
        }


    }

    private static boolean isADigit(String currentSymbol) {
        switch (currentSymbol) {
            case "0":
                return true;
            case "1":
                return true;
            case "2":
                return true;
            case "3":
                return true;
            case "4":
                return true;
            case "5":
                return true;
            case "6":
                return true;
            case "7":
                return true;
            case "8":
                return true;
            case "9":
                return true;
            case ".":
                return true;
            default:
                return false;
        }
    }
}
