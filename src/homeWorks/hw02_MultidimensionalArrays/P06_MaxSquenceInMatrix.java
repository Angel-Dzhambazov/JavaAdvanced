package homeWorks.hw02_MultidimensionalArrays;;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P06_MaxSquenceInMatrix {
    private static int SEQUENCE_COUNT = 0;
    private static String SEQUENCE_SYMBOL = "";

    public static void main(String[] args) {
        Scanner scannner = new Scanner(System.in);
        String[] dimmentions = scannner.nextLine().split(" ");
        int rows = Integer.parseInt(dimmentions[0]);
        int cols = Integer.parseInt(dimmentions[1]);

        String[][] matrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scannner.nextLine().split(" ");
        }
        String debug = "";
        List<String> sequence = new ArrayList<>();

        //Line (row)
        for (int i = 0; i < matrix.length; i++) {
            sequence.addAll(Arrays.asList(matrix[i]));
            checkForSequence(sequence);
        }
        // Columns
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                sequence.add(matrix[row][col]);
            }
            checkForSequence(sequence);
        }

        //Diagonal
        int diagSize = Math.min(rows, cols);
        for (int i = 0; i < diagSize; i++) {
            sequence.add(matrix[i][i]);
        }
        checkForSequence(sequence);

        for (int i = 0; i < SEQUENCE_COUNT; i++) {
            System.out.printf("%s, ", SEQUENCE_SYMBOL);
        }
    }


    private static void checkForSequence(List<String> sequence) {
        for (int startPossition = 0; startPossition < sequence.size() - 1; startPossition++) {

            int counter = 1;
            String symbol = sequence.get(startPossition);
            int currentPossition = startPossition + 1;

            while (symbol.equals(sequence.get(currentPossition))) {
                counter++;
                if (counter >= SEQUENCE_COUNT) {
                    SEQUENCE_COUNT = counter;
                    SEQUENCE_SYMBOL = symbol;
                }
                currentPossition++;
                if (currentPossition >= sequence.size()) {
                    break;
                }
            }
        }
        sequence.clear();
    }
}
