
package homeWorks.hw04_Sets_Maps;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P08_HandsOfCards {

    public static LinkedHashMap<String, HashSet<String>> players;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        players = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!"JOKER".equals(command)) {
            String[] tokens = command.split(":");
            String[] cards = tokens[1].trim().split(", ");

            if (!players.containsKey(tokens[0])) {
                clearAdd(tokens[0], cards);
            } else {
                moreAdd(tokens[0], cards);
            }
            command = scanner.nextLine();
        }

        for (String key : players.keySet()) {
            System.out.println(key + ": " + calculatePower(players.get(key)));
        }

    }


    private static Integer calculatePower(HashSet<String> strings) {
        Integer power = 0;
        Integer notMultipliedPower = 0;
        for (String card : strings) {
            String[] currentCard = card.split("");
            if (currentCard[0].equals("1")){
                currentCard[0] = "10";
                currentCard[1] = currentCard[2];
            }
            switch (currentCard[0]) {
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                    notMultipliedPower = Integer.parseInt(currentCard[0]);
                    break;
                case "J":
                    notMultipliedPower = 11;
                    break;
                case "Q":
                    notMultipliedPower = 12;
                    break;
                case "K":
                    notMultipliedPower = 13;
                    break;
                case "A":
                    notMultipliedPower = 14;
                    break;
            }
            switch (currentCard[1]) {
                case "S":
                    power += notMultipliedPower * 4;
                    break;
                case "H":
                    power += notMultipliedPower * 3;
                    break;
                case "D":
                    power += notMultipliedPower * 2;
                    break;
                case "C":
                    power += notMultipliedPower;
                    break;
            }
        }
        return power;
    }


    // ako igra4a ve4e e deklariran i ima nqkakvi karti
    private static void moreAdd(String token, String[] cards) {
        HashSet<String> currentCarSet = new HashSet<>();
        currentCarSet.addAll(players.get(token));
        for (String card : cards) {
            currentCarSet.add(card);
        }
        players.put(token, currentCarSet);
    }

    // tova e ako tozi igra4 oshte nqma nikakvi karti
    private static void clearAdd(String token, String[] cards) {
        HashSet<String> currentCarSet = new HashSet<>();
        for (String card : cards) {
            currentCarSet.add(card);
        }
        players.put(token, currentCarSet);
    }
}

