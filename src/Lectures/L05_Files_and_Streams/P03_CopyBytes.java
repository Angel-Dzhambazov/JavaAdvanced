package Lectures.L05_Files_and_Streams;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StreamCorruptedException;

public class P03_CopyBytes {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    private static String OUTPUT_PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputP02.txt";

    public static void main(String[] args) {


        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_PATH)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                String digits = String.valueOf(oneByte);

                for (int i = 0; i < digits.length(); i++) {
                    if (digits.charAt(i) == 32) {
                        fileOutputStream.write(Integer.parseInt(String.valueOf(' ')));
                    } else {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
