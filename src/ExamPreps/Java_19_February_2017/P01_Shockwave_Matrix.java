package ExamPreps.Java_19_February_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Shockwave_Matrix {
    public static Integer[][] MATRIX;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] size = reader.readLine().split(" ");
        Integer rows = Integer.parseInt(size[0]);
        Integer columns = Integer.parseInt(size[1]);
//        System.out.println(rows);
//        System.out.println(columns);
        MATRIX = new Integer[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                MATRIX[i][j] = 0;
            }
        }
        for (Integer[] matrix : MATRIX) {
            for (Integer cell : matrix) {
                cell = 0;
            }
        }


        String debug = "";

        String currentLine = reader.readLine();
        while (!"Here We Go".equals(currentLine)) {
            String[] coordinates = currentLine.split(" ");
            int x1 = Integer.valueOf(coordinates[0]);
            int y1 = Integer.valueOf(coordinates[1]);
            int x2 = Integer.valueOf(coordinates[2]);
            int y2 = Integer.valueOf(coordinates[3]);

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    MATRIX[i][j] += 1;
                }

            }

            currentLine = reader.readLine();
        }

        StringBuilder currentMatrixLine = new StringBuilder();
        for (Integer[] matrix : MATRIX) {
            for (Integer cell : matrix) {
                currentMatrixLine.append(cell + " ");
            }
            currentMatrixLine.substring(0, currentMatrixLine.length() - 1);
            System.out.println(currentMatrixLine);
            currentMatrixLine.delete(0, currentMatrixLine.length());
        }

    }


}
