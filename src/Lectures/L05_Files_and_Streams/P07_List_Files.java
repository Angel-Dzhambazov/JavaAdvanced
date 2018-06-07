package Lectures.L05_Files_and_Streams;


import java.io.File;

public class P07_List_Files {
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

        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.printf("%s: %s%n", file.getName(), file.length());
            }
        }
    }
}
