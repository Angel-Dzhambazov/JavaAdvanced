package homeWorks.hw02_MultidimensionalArrays;
import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P05_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int[][] inputMatrix = new int[rows][cols];
        int[][] finalMatrix = new int[3][3];
        int[][] currentMatrix = new int[3][3];
        int currentSum = 0;
        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < rows; i++) {
            String[] currentLine = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                inputMatrix[i][j] = Integer.parseInt(currentLine[j]);
                //  System.out.printf("%d ", inputMatrix[i][j]);
                if (i > 1) {
                    if (j > 1) {
                        for (int k = 2; k >= 0; k--) {
                            for (int l = 2; l >= 0; l--) {

                                currentSum += inputMatrix[i - k][j - l];
                                currentMatrix[2-k][2-l] = inputMatrix[i - k][j - l];
                                //System.out.printf("%d ",currentMatrix[2-k][2-l]);
                                if ( (k == 0 && l == 0) && currentSum> maxSum){
                                    maxSum = currentSum;
                                    maxRow = i-2;
                                    maxCol = j-2;
                                }
                            }
                            //  System.out.println();
                        }
                    }
                }
                currentSum = 0;
            }
            //System.out.println();
        }
        System.out.printf("Sum = %d",maxSum);
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", inputMatrix[maxRow+i][maxCol+j]);
            }
            System.out.println();
        }
    }
}
