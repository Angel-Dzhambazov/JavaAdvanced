package Lectures.L05_Files_and_Streams;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_Extract_Integers {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    private static String OUTPUT_PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputP02.txt";

    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(new FileInputStream(PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
