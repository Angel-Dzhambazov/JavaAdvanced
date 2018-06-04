
package homeWorks.hw04_Sets_Maps;


import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P09_UserLogs {

    private static TreeMap<String, LinkedHashMap<String, Integer>> spammers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        spammers = new TreeMap<>();


        String[] currentLine = scanner.nextLine().split(" ");
        while (!"end".equals(currentLine[0])) {

            String tempUser = tempUser(currentLine[2]);

            String tempIP = tempIP(currentLine[0]);

            addSpammer(tempUser, tempIP);

            currentLine = scanner.nextLine().split(" ");
        }
        String debug = "";
        for (String user : spammers.keySet()) {
            System.out.println(user + ": ");
            LinkedHashMap<String, Integer> tempIpMap = spammers.get(user);
            int numberOfIPs = 1;

            for (String ip : tempIpMap.keySet()) {
                if (numberOfIPs == tempIpMap.size()) {
                    System.out.println(ip + " => " + tempIpMap.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + tempIpMap.get(ip) + ", ");
                    numberOfIPs++;
                }
            }

        }


    }

    private static void addSpammer(String tempUser, String tempIP) {
        if (!spammers.containsKey(tempUser)) {
            LinkedHashMap<String, Integer> tempIpMap = new LinkedHashMap<>();
            tempIpMap.put(tempIP, 1);
            spammers.put(tempUser, tempIpMap);
        } else {
            LinkedHashMap<String, Integer> tempIpMap = spammers.get(tempUser);
            if (!tempIpMap.containsKey(tempIP)) {
                tempIpMap.put(tempIP, 1);
                spammers.put(tempUser, tempIpMap);
            } else {
                tempIpMap.put(tempIP, tempIpMap.get(tempIP) + 1);
                spammers.put(tempUser, tempIpMap);
            }
        }

    }

    private static String tempIP(String s) {
        String[] tokens = s.split("=");
        String ip = tokens[1];
        return ip;
    }


    private static String tempUser(String s) {
        String[] tokens = s.split("=");
        String tempUser = tokens[1];
        return tempUser;
    }
}
