package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class P11_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsNumber = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        Deque<String> executedText = new ArrayDeque<>();
        Deque<String> typeOfCommand = new ArrayDeque<>();
        for (int i = 0; i < commandsNumber; i++) {
            String[] currentCommand = scanner.nextLine().split(" ");
            switch (currentCommand[0]) {
                case "1":
                    text.append(currentCommand[1]);
                    executedText.push(currentCommand[1]);
                    typeOfCommand.push("1");
                    break;
                case "2":
                    StringBuilder deletedCommand = new StringBuilder();
                    for (int j = 0; j < Integer.parseInt(currentCommand[1]); j++) {
                        deletedCommand.append(text.charAt(text.length() - 1));
                        text.deleteCharAt(text.length() - 1);
                    }
                    deletedCommand.reverse();
                    executedText.push(deletedCommand.toString());
                    typeOfCommand.push("2");
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(currentCommand[1]) - 1));
                    break;
                case "4":
                    String whatToDo = typeOfCommand.pop();
                    String workingText = executedText.pop();
                    switch (whatToDo) {
                        case "1":
                            for (int j = 0; j < workingText.length(); j++) {
                                text.deleteCharAt(text.length() - 1);
                            }
                            break;

                        case "2":
                            text.append(workingText);
                            break;
                    }
                    break;
            }
        }

    }
}
