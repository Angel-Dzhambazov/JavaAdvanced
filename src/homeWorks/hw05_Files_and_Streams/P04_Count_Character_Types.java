package homeWorks.hw05_Files_and_Streams;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class P04_Count_Character_Types {

    public static void main(String[] args) {
        final Path inPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\input.txt");

        final Set<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));
        final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        final Set<Character> whiteSpace = new HashSet<>(Arrays.asList(' ', '\t', '\r', '\n'));

        long punctuationsTotal = 0L;
        long vowelsTotal = 0L;
        long consonantsTotal = 0L;

        try (BufferedReader reader = Files.newBufferedReader(inPath)) {
            // v ediniq ot testovete ne podavat nishto i dava null greshka
            String line;
            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();
                for (char c : chars) {
                    if (punctuation.contains(c)) {
                        punctuationsTotal++;
                    } else if (vowels.contains(c)) {
                        vowelsTotal++;
                    } else if (!whiteSpace.contains(c)) {
                        consonantsTotal++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Vowels: %d%n", vowelsTotal);
        System.out.printf("Consonants: %d%n", consonantsTotal);
        System.out.printf("Punctuation: %d%n", punctuationsTotal);
    }
}
