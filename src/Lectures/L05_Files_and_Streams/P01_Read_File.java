package Lectures.L05_Files_and_Streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class P01_Read_File {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(PATH)){
            int oneByte  = fileInputStream.read();
            while (oneByte>=0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
