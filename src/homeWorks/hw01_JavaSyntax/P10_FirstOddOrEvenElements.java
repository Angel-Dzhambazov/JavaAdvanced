package homeWorks.hw01_JavaSyntax;

import java.util.Scanner;

public class P10_FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int oddsCount = 0;
        int evensCount = 0;
        // TODO tuka kak da ne nalivam array ot string ami napravo array ot int?
        String[] inputs = scanner.nextLine().split("\\s+");

        for (int i = 0; i < inputs.length; i++) {
            if (Integer.parseInt(inputs[i]) % 2 != 0) {
                oddsCount += 1;
            } else {
                evensCount += 1;
            }
        }
        int[] odds = new int[oddsCount];
        int[] evens = new int[evensCount];
        int currentOdd = 0;
        int currentEven = 0;
        // TODO tuka ne moje li da nalivam arraya dinami4no? Ami trqbva parvo da znam kolko mu e goleminata?
        for (int i = 0; i < inputs.length; i++) {
            if (Integer.parseInt(inputs[i]) % 2 != 0) {
                odds[currentOdd] = Integer.parseInt(inputs[i]);
                currentOdd += 1;
            } else {
                evens[currentEven] = Integer.parseInt(inputs[i]);
                currentEven += 1;
            }
        }


        String[] commands = scanner.nextLine().split("\\s+");
//        int oddsCount = 0;
//        int evensCount = 0;
        switch (commands[2]) {
            case "odd":
                for (int i = 0; i < Math.min(oddsCount, Integer.parseInt(commands[1])) - 1; i++) {
                    System.out.printf("%d ", odds[i]);
                }
                System.out.printf("%d", odds[Math.min(oddsCount, Integer.parseInt(commands[1])) - 1]);
                break;
            case "even":
                for (int i = 0; i < Math.min(evensCount, Integer.parseInt(commands[1])) - 1; i++) {
                    System.out.printf("%d ", evens[i]);
                }
                System.out.printf("%d", evens[Math.min(evensCount, Integer.parseInt(commands[1])) - 1]);
                break;
        }
    }
}
