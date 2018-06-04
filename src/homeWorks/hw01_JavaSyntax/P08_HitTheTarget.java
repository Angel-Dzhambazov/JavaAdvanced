package homeWorks.hw01_JavaSyntax;

import java.util.Scanner;

public class P08_HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                if (i + j == target){
                    System.out.printf("%d + %d = %d\n",i , j , target);
                }
                if (i - j == target){
                    System.out.printf("%d - %d = %d\n",i , j , target);
                }

            }
        }
    }
}
