package Lectures.L02_MultidimentionalArrays.ExamPreps.Java_2016_06June_19;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class P02_Cubics_Rube_TapoUslovie {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer cubeSize = Integer.parseInt(reader.readLine());
        Double d = Math.pow(cubeSize, 3);
        Integer totalCells = d.intValue();
        BigInteger secretNumber = BigInteger.ZERO;

        HashSet<String[]> bombedCells = new HashSet<>();

        String currentLine = reader.readLine();
        while (!"Analyze".equals(currentLine)) {
            String[] tokens = currentLine.split("\\s+");
            Integer x = Integer.valueOf(tokens[0]);
            Integer y = Integer.valueOf(tokens[1]);
            Integer z = Integer.valueOf(tokens[2]);
            Integer particle = Integer.valueOf(tokens[3]);
            String[] coordinates = new String[3];
            for (int i = 0; i < 3; i++) {
                coordinates[i] = tokens[1];
            }

            if (doesCellExist(x, y, z, cubeSize)) {
                if (!bombedCells.contains(coordinates)) {
                    bombedCells.add(coordinates);
                    if (particle>0){
                        totalCells -= 1;
                    }
                    secretNumber = secretNumber.add(BigInteger.valueOf(particle));
                }
            }
            currentLine = reader.readLine();
        }
        System.out.println(secretNumber);
        System.out.println(totalCells);
    }


    private static boolean doesCellExist(Integer x, Integer y, Integer z, Integer cubeSize) {
        if (0 <= x && x < cubeSize) {
            if (0 <= y && y < cubeSize) {
                if (0 <= z && z < cubeSize) {
                    return true;
                }
            }
        }
        return false;
    }


}
