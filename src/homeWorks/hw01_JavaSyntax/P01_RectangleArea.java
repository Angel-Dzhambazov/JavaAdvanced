package homeWorks.hw01_JavaSyntax;


import java.util.Scanner;


public class P01_RectangleArea {
    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double area = a*b;
        System.out.printf("%.2f",area);
    }
}
