package Lectures.L05_Files_and_Streams;


import java.io.File;
import java.util.ArrayDeque;

public class P08_Nested_Folders {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources";

    public static void main(String[] args) {

        File rootDir = new File(PATH);

        if (!rootDir.exists()) {
            return;
        }

        File[] files = rootDir.listFiles();

        if (files == null) {
            return;
        }

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(rootDir);

        System.out.println(rootDir.getName());

        int counter = 1;

        while (!queue.isEmpty()) {
            File currentDir = queue.remove();

            File[] currentFiles = currentDir.listFiles();

            if (currentFiles == null) {
                continue;
            }

            for (File file : currentFiles) {
                if (file.isDirectory()) {
                    counter++;
                    System.out.println(file.getName());
                    queue.add(file);
                }
            }
        }
        System.out.printf("%d folders", counter);
    }
}
