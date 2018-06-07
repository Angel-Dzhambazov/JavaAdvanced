package Lectures.L05_Files_and_Streams;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class P03_CopyBytes {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    private static String OUTPUT_PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputP02.txt";

    public static void main(String[] args) {


        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_PATH)) {
            int oneByte = fileInputStream.read();
            int asciiCodeSpace = 32;
            int asciiCodeNewLine = 10;
            while (oneByte >= 0) {
                if (asciiCodeNewLine == oneByte || asciiCodeSpace == oneByte) {
                    fileOutputStream.write(oneByte);
                } else {
                    char[] characters = String.valueOf(oneByte).toCharArray();
                    for (char character : characters) {
                        fileOutputStream.write(character);
                    }
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
