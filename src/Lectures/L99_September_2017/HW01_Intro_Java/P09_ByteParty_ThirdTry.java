package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class P09_ByteParty_ThirdTry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(reader.readLine());

        StringBuilder[] numbers = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = new StringBuilder("");
            String curentDigitAsBinary = Integer.toBinaryString(Integer.valueOf(reader.readLine()));
            for (int j = 0; j < 8 - curentDigitAsBinary.length(); j++) {
                numbers[i].append("0");
            }
            numbers[i].append(curentDigitAsBinary);
        }

        String[] currentLine = reader.readLine().split(" ");
        while (!"party".equals(currentLine[0])) {
            String command = currentLine[0];
            Integer index = Integer.valueOf(currentLine[1]);
            switch (command) {
                case "-1":
                    for (StringBuilder number : numbers) {
                        if ("1".equals(String.valueOf(number.charAt(index)))) {
                            number.setCharAt(7-index,'0');
                        } else {
                            number.setCharAt(7-index,'1');
                        }
                    }
                    break;
                case "1":
                    for (StringBuilder number : numbers) {
                        number.setCharAt(7-index,'1');
                    }
                    break;
                case "0":
                    for (StringBuilder number : numbers) {
                        number.setCharAt(7-index,'0');
                    }
                    break;
            }
            currentLine = reader.readLine().split(" ");
        }

        for (StringBuilder number : numbers) {

            Integer x = Integer.parseInt(number.toString(),2);
            System.out.println(x);
        }

    }
}
