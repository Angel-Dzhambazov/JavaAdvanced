package homeWorks.hw01_JavaSyntax;


import java.util.Scanner;


public class P04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();


//        ((a2 + b2) / (a2 – b2))(a + b + c) / √c

        double F1a = (a * a + b * b) / (a * a - b * b);
        double F1b = (a + b + c) / Math.sqrt(c);
        double F1 = Math.pow(F1a, F1b);

        double F2a = (a * a + b * b - c*c*c);
        double F2b = (a-b);
        double F2 = Math.pow(F2a,F2b);

//        Abs (Avg (a, b, c) – Avg (f1, f2))

        double A1 = (a + b + c)/3;
        double A2 = (F1 + F2)/2;
        double diff = Math.abs(A1-A2);

        System.out.printf("F1 result: %.2f; ", F1);
        System.out.printf("F2 result: %.2f; ", F2);
        System.out.printf("Diff: %.2f", diff);

    }
}
