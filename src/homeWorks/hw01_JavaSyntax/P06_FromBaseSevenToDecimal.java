package homeWorks.hw01_JavaSyntax;


import java.util.Scanner;


public class P06_FromBaseSevenToDecimal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String x = scanner.nextLine();
        int baseToConvertTo = 10;
        int currentBase = 7;

        System.out.println(Integer.toString(Integer.parseInt(x, currentBase), baseToConvertTo));

    }
}
