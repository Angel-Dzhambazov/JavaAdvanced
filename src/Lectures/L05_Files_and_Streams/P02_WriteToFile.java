package Lectures.L05_Files_and_Streams;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P02_WriteToFile {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private static String OUTPUT_PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputP02.txt";

    public static void main(String[] args) {
        String pattern = "[,\\.\\!\\?]";

        List<Character> notNeededCharacters = new ArrayList<>();
        notNeededCharacters.add(',');
        notNeededCharacters.add('.');
        notNeededCharacters.add('!');
        notNeededCharacters.add('?');

        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_PATH)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                if (!notNeededCharacters.contains((char) oneByte)) {
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}


//Skip the following symbols: ',', '.', '!', '?'