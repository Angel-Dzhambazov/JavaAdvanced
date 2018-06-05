package Lectures.L99_September_2017.HW01_Intro_Java;

        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.util.Scanner;


public class P01_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        //Integer result = Integer.valueOf(input[0]) * Integer.valueOf(input[1]);
        BigDecimal resultB = BigDecimal.ONE;
        resultB = resultB.multiply(new BigDecimal(input[0]));
        resultB = resultB.multiply(new BigDecimal(input[1]));
       // Double actualResult = result * 1.00;
        System.out.printf("%.2f", resultB);
    }
}
