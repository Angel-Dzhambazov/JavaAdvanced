package Lectures.L04_Sets_Maps;

import java.util.*;


public class P02_SoftUni_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> guestList = new HashSet<String>();
        TreeSet<String> vipList = new TreeSet<>();
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

        int invited = 0;
        int attended = 0;
        int missing = 0;
        while (true) {
            String input = scanner.nextLine();
            if (!"PARTY".equals(input)) {
                if (numbers.contains(input.charAt(0))) {
                    vipList.add(input);
                } else {
                    guestList.add(input);
                }
                invited += 1;
            }
            if ("PARTY".equals(input)) {
                break;
            }
        }
        while (true) {
            String input = scanner.nextLine();
            if (!"END".equals(input)) {
                if (numbers.contains(input.charAt(0))){
                    vipList.remove(input);
                }else {
                    guestList.remove(input);
                }

                attended += 1;
            }
            if ("END".equals(input)) {
                break;
            }
        }

        vipList.addAll(guestList);
        System.out.println(invited - attended);
        for (String person : vipList) {
            System.out.println(person);
        }
    }
}
