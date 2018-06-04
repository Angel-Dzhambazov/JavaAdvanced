package homeWorks.hw02_MultidimensionalArrays;
import java.util.Scanner;

/**
 * Created by fluch on 4/24/2017.
 */
public class P09_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        char[] input = s.toCharArray();
        int startOfBomb = 0;
        int endOfBomb = 0;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            char currentChar = input[i];
            if ('|' == currentChar) {
                if (startOfBomb == 0) {
                    startOfBomb = i;
                    //System.out.printf("found it start of bomb at %d the symbol is %s\n", startOfBomb, s.charAt(startOfBomb + 1));
                } else {
                    endOfBomb = i;
                    //System.out.printf("found it end of bomb at %d the symbol is %s\n", endOfBomb, s.charAt(endOfBomb - 1));
                    for (int k = startOfBomb + 1; k <= endOfBomb - 1; k++) {

                        char currentChart = input[k];
                        //System.out.print(currentChart);
                        sum += Integer.valueOf(currentChart);
                        //System.out.println(sum);
                    }
                    sum = sum % 10;
                    //System.out.println(sum);
                    //StringBuilder myName = new StringBuilder(s);
                    for (int l = startOfBomb - sum; l < endOfBomb + sum + 1; l++) {
                        input[l] = '.';
                    }


                    startOfBomb = 0;
                    endOfBomb = 0;
                    sum = 0;

                }

            }
        }
        System.out.println(input);

    }
}
