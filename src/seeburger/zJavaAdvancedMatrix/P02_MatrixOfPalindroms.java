package zJavaAdvancedMatrix;

import java.awt.AlphaComposite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_MatrixOfPalindroms {

	private static String[][] palindroms;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// int sizeA = Integer.parseInt(reader.readLine());
		// int sizeB = Integer.parseInt(reader.readLine());

		int sizeA = 4;
		int sizeB = 23;
		palindroms = new String[sizeA][sizeB];

		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		fillMatrix(palindroms, alphabet);



		printMatrix(palindroms);
	}

	private static void fillMatrix(String[][] matrix, char[] alphabet) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = String.valueOf(alphabet[i]) + String.valueOf(alphabet[j + i])
						+ String.valueOf(alphabet[i]);
			}
		}
	}

	private static void printMatrix(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
