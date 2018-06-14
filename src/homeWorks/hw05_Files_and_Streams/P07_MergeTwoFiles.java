package homeWorks.hw05_Files_and_Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P07_MergeTwoFiles {
    public static void main(String[] args) {
        final Path inputPathOne = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\inputOne.txt");
        final Path inputPathTwo = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\inputTwo.txt");
        final Path outputPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\output.txt");


        try (BufferedReader fileReaderOne = Files.newBufferedReader(inputPathOne);
             BufferedReader fileReaderTwo = Files.newBufferedReader(inputPathTwo);
             BufferedWriter fileWriter = Files.newBufferedWriter(outputPath)) {

            fileReaderOne.lines().forEach(line -> {
                try {
                    fileWriter.write(line);
                    fileWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fileReaderTwo.lines().forEach(line -> {
                try {
                    fileWriter.write(line);
                    fileWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

