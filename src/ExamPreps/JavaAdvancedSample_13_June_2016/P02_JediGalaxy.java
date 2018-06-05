package ExamPreps.JavaAdvancedSample_13_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_JediGalaxy {

    private static Integer[][] MATRIX;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split("\\s+");
        fillMatrix(size);
        String[] ivo = reader.readLine().split("\\s+");
        //String nextLine = reader.readLine();

        //while (!"Let the Force be with you".equals(nextLine)) {
        String[] evil = reader.readLine().split("\\s+");
        evilStrikes(evil);
        //    nextLine = reader.readLine();

        long sum = ivoMoves(ivo);

        System.out.println(sum);
       // printMatrix();

        //  fillMatrix(size);
    }

    private static void printMatrix() {
        for (Integer[] matrix : MATRIX) {
            for (Integer integer : matrix) {
                System.out.printf(" " + integer);
            }
            System.out.println();
        }
    }

    private static void evilStrikes(String[] evil) {
        Integer evilRow = Integer.valueOf(evil[0]);
        Integer evilCol = Integer.valueOf(evil[1]);

        // taq glupost zasega v komentar
//        Integer rowDifference = evilRow - MATRIX.length + 1;
//        Integer colDifference = evilCol - MATRIX[0].length + 1;
//        Integer difference = 0;
//        if (rowDifference > 0 || colDifference > 0) {
//            difference = Math.max(rowDifference, colDifference);
//        }
//
//        Integer evilStartRow = evilRow - difference;
//        Integer evilStartCol = evilCol - difference;


        Integer evilStartRow = evilRow;
        Integer evilStartCol = evilCol;
        while (evilStartRow>= MATRIX.length||evilStartCol>= MATRIX[0].length){
            evilStartRow--;
            evilStartCol--;
        }


        while (evilStartCol >= 0 && evilStartRow >= 0) {
            //System.out.println(MATRIX[evilStartRow][evilStartCol]);
            MATRIX[evilStartRow][evilStartCol] = 0;
            evilStartRow--;
            evilStartCol--;
        }

    }


    private static long ivoMoves(String[] ivo) {
        Integer ivoRow = Integer.valueOf(ivo[0]);
        Integer ivoCol = Integer.valueOf(ivo[1]);

        // taq glupost zasega v komentar

//        Integer difference = 0;
//        Integer rowDifference = ivoRow - MATRIX.length + 1;
//        Integer colDifference = ivoCol * -1;
//
//        if (rowDifference > 0 || colDifference > 0) {
//            difference = Math.max(rowDifference, colDifference);
//        }
//
//        Integer ivoStartRow = ivoRow - difference;
//        Integer ivoStartCol = ivoCol + difference;

        Integer ivoStartRow = ivoRow;
        Integer ivoStartCol = ivoCol;
        while (ivoStartRow >= MATRIX.length || ivoStartCol < 0) {
            ivoStartRow--;
            ivoStartCol++;
        }

        long sum = 0L;
        while (ivoStartRow >= 0 && ivoStartCol < MATRIX[0].length) {
            sum += MATRIX[ivoStartRow][ivoStartCol];
            ivoStartRow--;
            ivoStartCol++;
        }
        return sum;
    }

    private static void fillMatrix(String[] size) {
        Integer x = Integer.valueOf(size[0]);
        Integer y = Integer.valueOf(size[1]);
        MATRIX = new Integer[x][y];
        Integer counter = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                MATRIX[i][j] = counter;
                counter++;
            }
        }


    }
}
