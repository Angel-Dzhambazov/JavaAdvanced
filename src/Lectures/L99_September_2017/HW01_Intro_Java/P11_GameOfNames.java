package Lectures.L99_September_2017.HW01_Intro_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11_GameOfNames {
    private static Integer SCORE = Integer.MIN_VALUE;
    private static String WINNER = "";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer countOfPlayers = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countOfPlayers; i++) {
            String currentPlyaer = reader.readLine();
            Integer currentScore = Integer.parseInt(reader.readLine());
            checkForNewWinner(currentPlyaer, currentScore);
        }
        System.out.printf("The winner is %s - %d points", WINNER, SCORE);
    }

    private static void checkForNewWinner(String currentPlyaer, Integer currentScore) {
        Integer currentSum = currentScore;
        for (int i = 0; i < currentPlyaer.length(); i++) {
            int tempSum = String.valueOf(currentPlyaer.charAt(i)).charAt(0);
            if (tempSum % 2 == 0) {
               // System.out.printf("current letter of name is %s\n current number of that letter is %d\n", currentPlyaer.charAt(i), tempSum);
                currentSum += tempSum;
            } else {
               // System.out.printf("current letter of name is %s\n current number of that letter is %d\n", currentPlyaer.charAt(i), tempSum);
                currentSum -= String.valueOf(currentPlyaer.charAt(i)).charAt(0);
            }
        }
        if (currentSum > SCORE) {
            SCORE = currentSum;
            WINNER = currentPlyaer;
        }
    }
}
