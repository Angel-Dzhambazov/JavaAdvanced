package ExamPreps.C_Sharp_19_July_2015;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_BunkerBuster {
    private static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().trim().split("\\s+");
        Integer rows = Integer.parseInt(size[0]);
        Integer cols = Integer.parseInt(size[1]);
        matrix = new Integer[rows][cols];

        readMatrix(reader);

        String command = reader.readLine();

        while (!command.equals("cease fire!")) {
            String[] tokens = command.trim().split("\\s+");
            Integer impactRow = Integer.parseInt(tokens[0]);
            Integer impactCol = Integer.parseInt(tokens[1]);
            Integer damage = (int) tokens[2].charAt(0);



            executeCommand(impactRow, impactCol, damage);
            command = reader.readLine();
        }
        int cellDestroyed = findResult();
        Double percent = (100.0 * cellDestroyed) / (rows * cols);
        System.out.println("Destroyed bunkers: " + cellDestroyed);

        System.out.println("Damage done: " + String.format("%.1f", percent) + " %");

    }

    private static int findResult() {
        Integer counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] <= 0) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    private static void executeCommand(Integer impactRow, Integer impactCol,Integer damage) {

        cellDamage(impactRow, impactCol, damage);

        if (damage % 2 != 0) {
            damage = damage / 2 + 1;
        } else {
            damage = damage / 2;
        }
        cellDamage(impactRow - 1, impactCol - 1, damage);
        cellDamage(impactRow - 1, impactCol, damage);
        cellDamage(impactRow - 1, impactCol + 1, damage);
        cellDamage(impactRow, impactCol - 1, damage);
        cellDamage(impactRow, impactCol + 1, damage);
        cellDamage(impactRow + 1, impactCol - 1, damage);
        cellDamage(impactRow + 1, impactCol, damage);
        cellDamage(impactRow + 1, impactCol + 1, damage);
    }

    private static void cellDamage(Integer impactRow, Integer impactCol, Integer damage) {
        try {
            matrix[impactRow][impactCol] -= damage;
        } catch (IndexOutOfBoundsException ex) { }

    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = reader.readLine().trim().split(" ");
            for (int col = 0; col < reminder.length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }

    }
}
