package homeWorks.hw01_JavaSyntax;

import java.util.Scanner;

public class P05_FromDecimalToBaseSeven {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextInt();
        int baseToConvertTo = 7;
        System.out.println(Long.toString(x, baseToConvertTo));
    }

}


