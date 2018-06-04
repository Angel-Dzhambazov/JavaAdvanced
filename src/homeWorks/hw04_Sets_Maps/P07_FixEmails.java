
package homeWorks.hw04_Sets_Maps;



import java.util.*;

public class P07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> personalEmails = new LinkedHashMap<>();

        String name = "";
        while (!"stop".equals(name = scanner.nextLine())) {
            String email = scanner.nextLine();
            int dotIndex = email.lastIndexOf('.');
            String domain = email.substring(dotIndex + 1);
            switch (domain.toLowerCase()){
                case "uk":
                case "us":
                case "com":
                    continue;
            }
            if (!personalEmails.containsKey(name)){
                personalEmails.put(name, new ArrayList<>());
            }

            personalEmails.get(name).add(email);
        }
        for (Map.Entry<String, List<String>> entry : personalEmails.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(),String.join(", ",entry.getValue()));
        }
    }
}
