package Lectures.L04_Sets_Maps;


import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");


        for (String card : input1) {
            set1.add(Integer.parseInt(card));
        }

        for (String card : input2) {
            set2.add(Integer.parseInt(card));
        }


        ArrayDeque<Integer> teste1 = new ArrayDeque<>();
        teste1.addAll(set1);
        ArrayDeque<Integer> teste2 = new ArrayDeque<>();
        teste2.addAll(set2);

        for (int i = 0; i < 50; i++) {

            Integer player1Card = teste1.pollFirst();
            Integer player2Card = teste2.pollFirst();

            if (player1Card == player2Card) {
                teste1.add(player1Card);
                teste2.add(player2Card);
            } else if (player1Card > player2Card) {
                if (!teste1.contains(player1Card)) {
                    teste1.add(player1Card);
                }
                if (!teste1.contains(player2Card)) {
                    teste1.add(player2Card);
                }
            } else if (player2Card > player1Card) {
                if (!teste2.contains(player1Card)) {
                    teste2.add(player1Card);
                }
                if (!teste2.contains(player2Card)) {
                    teste2.add(player2Card);
                }
            }
            if (teste1.isEmpty() || teste2.isEmpty()) {
                break;
            }
        }
        if (teste1.size() == teste2.size()) {
            System.out.println("Draw!");
        }
        if (teste1.size() > teste2.size()) {
            System.out.println("First player win!");
        }
        if (teste1.size() < teste2.size()) {
            System.out.println("Second player win!");
        }

    }
}
