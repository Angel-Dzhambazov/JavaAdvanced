//
//public class TodorsTasks_01_Matrix {
//	private static int[][] patternC;
//	public static void main(String[] args) {
//
//		int x = 5;
//		fillMatrixPatternC(patternC);
//		System.out.println("\nThis is matrix pattern C\nThe rows are filled as a snake");
//		printMatrix(patternC);
//	}
//	
//
//	private static void fillMatrixPatternC(int[][] matrix) {
//		int counter = 1;
//		int max = matrix.length * matrix.length;
//
//		int column = 0;
//		int row = 0;
//
//		int bottomRow = matrix.length - 1;
//		int rightCol = matrix[0].length - 1;
//		int topRow = 0;
//		int leftCol = 0;
//
//		while (counter <= max) {
//			while (row <= bottomRow) {
//				matrix[row][column] = counter++;
//				row++;
//			}
//			leftCol++; // vsi4ko v lqvo e palno
//			column++;
//			row--;
//
//			while (column <= rightCol) {
//				matrix[row][column] = counter++;
//				column++;
//			}
//			bottomRow--; // nai-dolen red palen
//			column--;
//			row--;
//
//			while (row >= topRow) {
//				matrix[row][column] = counter++;
//				row--;
//			}
//			row++;
//			column--;
//			rightCol--; // nai-dqsna kolona palna
//
//			while (column >= leftCol) {
//				matrix[row][column] = counter++;
//				column--;
//			}
//			topRow++; // nai-goren red palen
//			row++;
//			column++;
//		}
//
//	}
//	
//	private static void printMatrix(int[][] matrix) {
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//	}
//}
