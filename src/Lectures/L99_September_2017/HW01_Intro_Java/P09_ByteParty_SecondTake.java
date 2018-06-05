package Lectures.L99_September_2017.HW01_Intro_Java;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P09_ByteParty_SecondTake {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(reader.readLine());


        List<char[]> binary = new ArrayList<>();
        for (char[] chars : binary) {
            chars = makeBinary(Integer.valueOf(reader.readLine()));
        }

        String currentLine = reader.readLine();

        while (!"party over".equals(currentLine)) {
            String[] tokens = currentLine.split(" ");
            switch (tokens[0]) {
                case "-1":
                    changeDigit(binary,Integer.valueOf(tokens[1]));
                    break;
                case "0":
                    setAllZeroes(binary,Integer.valueOf(tokens[1]));
                    break;
                case "1":
                    setAllOnes(binary,Integer.valueOf(tokens[1]));
                    break;
            }
        }
        print(binary);

    }

    private static void print(List<char[]> binary) {
        for (char[] numbersAsBinaryChars : binary) {
            StringBuilder sb = new StringBuilder();
            for (char digit : numbersAsBinaryChars) {
                sb.append(digit);
            }
            String actualBinary = sb.reverse().toString();
            System.out.println(Integer.valueOf(actualBinary,2));
        }

    }

    private static void setAllOnes(List<char[]> binary, Integer integer) {
        for (char[] numbersAsBinaryChars : binary) {
            numbersAsBinaryChars[integer] = 1;
        }
    }

    private static void setAllZeroes(List<char[]> binary, Integer integer) {
        for (char[] numbersAsBinaryChars : binary) {
            numbersAsBinaryChars[integer] = 0;
        }
    }

    private static void changeDigit(List<char[]> binary, Integer integer) {
        for (char[] numbersAsBinaryChars : binary) {
            if(numbersAsBinaryChars[integer]==1){
                numbersAsBinaryChars[integer] = 0;
            } else {
                numbersAsBinaryChars[integer] = 1;
            }
        }
    }

    private static char[] makeBinary(Integer integer) {
        char[] iAmConfused = new char[8];
        for (int i = 0; i < 8; i++, integer /= 2) {
            switch (integer % 2) {
                case 0:
                    iAmConfused[i] = 0;
                    break;
                case 1:
                    iAmConfused[i] = 1;
                    break;
            }
        }

        return iAmConfused;
    }


    private static String currentDigitAsBinary(Integer currentDigit) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 8; i++, currentDigit /= 2) {
            switch (currentDigit % 2) {
                case 0:
                    line.append(0);
                    break;
                case 1:
                    line.append(1);
                    break;
            }
        }
        String output = line.toString();
        return output;
    }
}
