package homeWorks.hw02_MultidimensionalArrays;

/**
 * Created by fluch on 4/22/2017.
 * TODO Hint: •	Read about Exception Handling
 * Input:
 * Sj0u$hbc
 * $87yihc87
 * Ewg3444
 * $4$$
 * V>>^^>>>VVV<<
 * Output:
 * Coins collected: 2
 * <p>
 * Walls hit: 2
 */


import java.util.Scanner;

public class P07_CollectCoins {

    private static int NUMBER_OF_COINS_COLLECTED = 0;
    private static int NUMBER_OF_WALLS_HIT = 0;

    public static void main(String[] args) {
        String[][] board = new String[4][];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            board[i] = scanner.nextLine().split("");
        }
//        for (char[] chars : board) {
//            System.out.print(chars);
//            System.out.println();
//        }
        String[] commands = scanner.nextLine().split("");
        int currentRow = 0;
        int currentCol = 0;
        String debug = "";
        for (int currentCommand = 0; currentCommand < commands.length; currentCommand++) {
            switch (commands[currentCommand]) {
                case ">":
//                    try {
//                        currentCol++;
//                    } catch (ArrayIndexOutOfBoundsException e){
//                        NUMBER_OF_WALLS_HIT++;
//                    }
                    if (currentCol < board[currentRow].length - 1) {
                        currentCol++;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
                case "V":
                    if (currentRow < 3 && currentCol < board[currentRow + 1].length) {
                        currentRow++;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
                case "<":
                    if (currentCol > 0) {
                        currentCol--;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
                case "^":
                    if (currentRow > 0 && currentCol < board[currentRow - 1].length) {
                        currentRow--;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
            }
            //System.out.println(board[currentRow][currentCol]);
            if ("$".equals(board[currentRow][currentCol])) {
                NUMBER_OF_COINS_COLLECTED++;
                board[currentRow][currentCol] = "s";
            }
        }
        System.out.println("Coins = " + NUMBER_OF_COINS_COLLECTED);
        System.out.println("Walls = " + NUMBER_OF_WALLS_HIT);
    }
}
