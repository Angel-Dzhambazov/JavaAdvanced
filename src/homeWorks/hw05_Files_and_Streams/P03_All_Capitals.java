package homeWorks.hw05_Files_and_Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class P03_All_Capitals {

    public static void main(String[] args) {
        final Path inPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\input.txt");
        final Path outPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\output.txt");

        try (BufferedReader br = Files.newBufferedReader(inPath);
             BufferedWriter bw = Files.newBufferedWriter(outPath)) {
            String test = br.readLine();
            while (test != null) {
                try {
                    bw.write(test.toUpperCase());
                    bw.newLine();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                test = br.readLine();
            }
//            br.lines()
//                    .map(String::toUpperCase)
//                    .forEach(str -> {
//                        try {
//                            bw.write(str);
//                            bw.newLine();
//                        } catch (IOException ioe) {
//                            ioe.printStackTrace();
//                        }
//                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
