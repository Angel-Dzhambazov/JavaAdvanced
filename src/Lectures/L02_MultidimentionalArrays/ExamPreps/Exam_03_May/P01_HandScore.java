package Lectures.L02_MultidimentionalArrays.ExamPreps.Exam_03_May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01_HandScore {
    public static Integer currentMultiplier = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] hand = reader.readLine().split(" ");
        Integer sum = 0;
        List<String> sameColour = new ArrayList<>();
        for (int i = 0; i < hand.length; i++) {
            String currentCard = hand[i];
            if (sameColour.isEmpty()) {
                sameColour.add(currentCard);
            } else if (checkForColour(sameColour, currentCard)) {
                sameColour.add(currentCard);
                currentMultiplier++;
            } else {
                sum += calculateSum(sameColour);
                currentMultiplier = 1;
                sameColour.clear();
                sameColour.add(currentCard);
            }

        }
        if (!sameColour.isEmpty()){
            sum+=calculateSum(sameColour);
        }
        System.out.println(sum);
    }

    private static Integer calculateSum(List<String> sameColour) {
        Integer colourSum = 0;
        for (String hand : sameColour) {
            String number = hand.substring(0, hand.length() - 1);
            switch (number) {
                case "A":
                    colourSum += 15;
                    break;
                case "K":
                    colourSum += 14;
                    break;
                case "Q":
                    colourSum += 13;
                    break;
                case "J":
                    colourSum += 12;
                    break;
                default:
                    colourSum += Integer.valueOf(number);
                    break;
            }
        }
        colourSum *= currentMultiplier;
        return colourSum;
    }

    private static boolean checkForColour(List<String> sameColour, String currentCard) {
        String currentCardColour = currentCard.substring(currentCard.length() - 1);
        String isItTheSame = sameColour.get(0).substring(sameColour.get(0).length() - 1);
        if (currentCardColour.equals(isItTheSame)) {
            return true;
        } else {
            return false;
        }

    }

}
