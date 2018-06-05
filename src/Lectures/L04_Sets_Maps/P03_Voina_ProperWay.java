package Lectures.L04_Sets_Maps;


import java.util.LinkedHashSet;
import java.util.Scanner;

public class P03_Voina_ProperWay {


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        LinkedHashSet<Integer> teste1 = getPLayerCards();
        LinkedHashSet<Integer> teste2 = getPLayerCards();

        for (int i = 0; i < 50; i++) {
            if (teste1.isEmpty() || teste2.isEmpty()){
                break;
            }

            int firstCard = teste1.iterator().next();
            teste1.remove(firstCard);

            int secondCard = teste2.iterator().next();
            teste2.remove(secondCard);

            if (firstCard>secondCard){
                teste1.add(firstCard);
                teste1.add(secondCard);
            } else if( secondCard>firstCard){
                teste2.add(firstCard);
                teste2.add(secondCard);
            } else if ( firstCard == secondCard){
                teste1.add(firstCard);
                teste2.add(secondCard);
            }


        }
        print(teste1,teste2);

    }

    private static void print(LinkedHashSet<Integer> teste1, LinkedHashSet<Integer> teste2) {
        if (teste1.size()>teste2.size()){
            System.out.println("First player win!");
        }
        if (teste1.size()<teste2.size()){
            System.out.println("Second player win!");
        }
        if (teste1.size()==teste2.size()){
            System.out.println("Draw!");
        }
    }

    public static LinkedHashSet<Integer> getPLayerCards() {
        LinkedHashSet<Integer> playerCards = new LinkedHashSet<>();
        String[] input = scanner.nextLine().split(" ");
        for (String card : input) {
            playerCards.add(Integer.parseInt(card));
        }
        return playerCards;
    }
}
