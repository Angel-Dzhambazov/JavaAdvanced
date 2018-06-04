
package homeWorks.hw04_Sets_Maps;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by fluch on 5/28/2017.
 */
public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        String[] inputLine = scanner.nextLine().split("-");
        while (!"search".equals(inputLine[0])) {
            if (!inputLine[1].isEmpty()) {
                phonebook.put(inputLine[0], inputLine[1]);
            }
            inputLine = scanner.nextLine().split("-");
        }
        String command = scanner.nextLine();
        while (!"stop".equals(command)) {
            if (phonebook.containsKey(command)) {
                System.out.println(command + " -> " + phonebook.get(command));
            } else {
                System.out.println("Contact " + command + " does not exist.");
            }
            command = scanner.nextLine();
        }
    }
}
