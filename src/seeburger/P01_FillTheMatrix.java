package seeburger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_FillTheMatrix {

	private static int[][] patternA;
	private static int[][] patternB;
	private static int[][] patternC;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//int x = Integer.parseInt(reader.readLine());
		int x = 5;

		patternA = new int[x][x];
		patternB = new int[x][x];
		patternC = new int[x][x];

		fillMatrixPatternA(patternA);
		fillMatrixPatternB(patternB);
		fillMatrixPatternC(patternC);

		
		System.out.println("This is matrix pattern A\nThe rows are filled from top to bottom");
		printMatrix(patternA);
		System.out.println("\nThis is matrix pattern B\nThe rows are filled from top to bottom to top to bottom again");
		printMatrix(patternB);
		System.out.println("\nThis is matrix pattern C\nThe rows are filled as a snake");
		printMatrix(patternC);

	}
	


	private static void fillMatrixPatternA(int[][] matrix) {
		int currentColumn = 0;
		int counter = 1;
		int max = matrix.length * matrix.length;

		while (counter <= max) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][currentColumn] = counter++;
			}
			currentColumn++;
		}
	}

	private static void fillMatrixPatternB(int[][] matrix) {
		int currentColumn = 0;
		int counter = 1;

		int max = matrix.length * matrix.length;

		while (counter <= max) {
			if (currentColumn % 2 == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][currentColumn] = counter++;
				}
				currentColumn++;
			} else {
				for (int i = matrix.length - 1; i >= 0; i--) {
					matrix[i][currentColumn] = counter++;
				}
				currentColumn++;
			}
		}
	}
	

	private static void fillMatrixPatternC(int[][] matrix) {
		int counter = 1;
		int max = matrix.length * matrix.length;

		int column = 0;
		int row = 0;

		int bottomRow = matrix.length - 1;
		int rightCol = matrix[0].length - 1;
		int topRow = 0;
		int leftCol = 0;

		while (counter <= max) {
			while (row <= bottomRow) {
				matrix[row][column] = counter++;
				row++;
			}
			leftCol++; // vsi4ko v lqvo e palno
			column++;
			row--;

			while (column <= rightCol) {
				matrix[row][column] = counter++;
				column++;
			}
			bottomRow--; // nai-dolen red palen
			column--;
			row--;

			while (row >= topRow) {
				matrix[row][column] = counter++;
				row--;
			}
			row++;
			column--;
			rightCol--; // nai-dqsna kolona palna

			while (column >= leftCol) {
				matrix[row][column] = counter++;
				column--;
			}
			topRow++; // nai-goren red palen
			row++;
			column++;
		}

	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}
