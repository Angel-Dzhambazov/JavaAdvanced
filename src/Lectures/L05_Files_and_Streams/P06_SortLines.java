package Lectures.L05_Files_and_Streams;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06_SortLines {
    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    private static String OUTPUT_PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputP02.txt";
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";



        Path inputPath = Paths.get(PATH);
        Path outputPath = Paths.get(OUTPUT_PATH);

        try {
            List<String> lines = Files.readAllLines(inputPath);
            Collections.sort(lines);
            Files.write(outputPath, lines);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
