package homeWorks.hw05_Files_and_Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class P05_Line_Numbers {
    public static void main(String[] args) {
        final Path inPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\inputLineNumbers.txt");
        final Path outPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\output.txt");

        // kato ne dava primitivna promenliva v lamda-ta mu podavame masiv ot edin element, koito otbroqva
        final int[] lines = {1};
        try (BufferedReader br = Files.newBufferedReader(inPath);
             BufferedWriter bw = Files.newBufferedWriter(outPath)) {
            br.lines()
                    .forEach(str -> {
                        try {
                            bw.write(String.format("%d. %s%n", lines[0]++, str));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
