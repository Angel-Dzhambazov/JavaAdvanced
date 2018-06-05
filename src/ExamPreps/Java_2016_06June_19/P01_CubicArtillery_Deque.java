package ExamPreps.Java_2016_06June_19;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class P01_CubicArtillery_Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> bunkers = new ArrayDeque<>();
        Integer capacity = Integer.valueOf(reader.readLine());
        String currentLine = reader.readLine();
        Deque<Integer> extraWeapons = new ArrayDeque<>();

        while (!"Bunker Revision".equals(currentLine)) {
            String[] tokens = currentLine.split(" ");
            Deque<Integer> weapons = new ArrayDeque<>();

            for (String element : tokens) {
                if (isABunker(element)) {
                    bunkers.offer(element);
                } else {
                    weapons.offer(Integer.valueOf(element));
                }
            }


            String currentBunker = bunkers.poll();

            Deque<Integer> weaponsInCurrentBunker = new ArrayDeque<>();
            Integer sumOfWeaponsInCurrentBunker = 0;
            while (!weapons.isEmpty()) {
                Integer currentWeapon = weapons.poll();
                if (currentWeapon <= capacity) {
                    if (currentWeapon <= capacity - sumOfWeaponsInCurrentBunker) {
                        weaponsInCurrentBunker.offer(currentWeapon);
                        sumOfWeaponsInCurrentBunker += currentWeapon;
                    } else if (!bunkers.isEmpty()){
                        extraWeapons.offer(currentWeapon);
                    }
                    else if (bunkers.isEmpty() && currentWeapon <= capacity) {
                        doMagic(currentWeapon, sumOfWeaponsInCurrentBunker, weaponsInCurrentBunker, capacity);
                    }
                }
            }
            if (!bunkers.isEmpty()){
                weapons = extraWeapons;
            }
            currentLine = reader.readLine();
            if (!"Bunker Revision".equals(currentLine)) {
                printWeapons(currentBunker, weaponsInCurrentBunker);
            } else {
                if (!bunkers.isEmpty()) {
                    printWeapons(currentBunker, weaponsInCurrentBunker);
                }
            }
        }
    }

    private static void doMagic(Integer currentWeapon, Integer sumOfWeaponsInCurrentBunker, Deque<Integer> weaponsInCurrentBunker, Integer capacity) {
        Boolean isMagicDone = true;

        while (isMagicDone) {
            Integer removedWeapon = weaponsInCurrentBunker.poll();
            sumOfWeaponsInCurrentBunker -= removedWeapon;
            if (currentWeapon <= capacity - sumOfWeaponsInCurrentBunker) {
                weaponsInCurrentBunker.offer(currentWeapon);
                sumOfWeaponsInCurrentBunker += currentWeapon;
                isMagicDone = false;
            }
        }


    }

    private static void printWeapons(String currentBunker, Deque<Integer> weaponsInCurrentBunker) {
        System.out.print(currentBunker + " -> ");
        if (weaponsInCurrentBunker.isEmpty()) {
            System.out.println("Empty");
        } else {
            while (!weaponsInCurrentBunker.isEmpty()) {
                if (weaponsInCurrentBunker.size() != 1) {
                    System.out.print(weaponsInCurrentBunker.poll() + ", ");
                } else if (weaponsInCurrentBunker.size() == 1) {
                    System.out.println(weaponsInCurrentBunker.poll());
                }
            }
        }
    }


    private static boolean isABunker(String element) {
        if (element.matches("[0-9]+")) {
            return false;
        } else {
            return true;
        }
    }
}
