package homeWorks.hw02_MultidimensionalArrays;Arrays;

import java.util.Scanner;

/**
 * Created by fluch on 4/26/2017.+
 * <p>
 * Ivan's solution
 */
public class P09_2_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());

        while (true) {
            int firstPipeIndex = input.indexOf("|");
            if (firstPipeIndex != -1) {
                int lastPipeIndex = input.indexOf("|", firstPipeIndex + 1);
                String bombContent = input.substring(firstPipeIndex + 1, lastPipeIndex);
                int bombPower = getBombPower(bombContent);
                int startIndex = Math.max(0, firstPipeIndex - bombPower);
                int endIndex = Math.min(lastPipeIndex + bombPower, input.length() - 1);
                while (startIndex<=endIndex){
                    input.setCharAt(startIndex,'.');
                    startIndex++;
                }
            } else {
                break;
            }
        }
        System.out.println(input.toString());
    }

    private static int getBombPower(String bombContent) {
        int sum = 0;
        for (char symbol : bombContent.toCharArray()) {
            sum += symbol;
        }
        return sum % 10;
    }
}
