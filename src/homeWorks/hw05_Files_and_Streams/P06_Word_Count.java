package homeWorks.hw05_Files_and_Streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P06_Word_Count {
	public static void main(String[] args) {
        final Path inPath = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\words.txt");
        final Path inputText = Paths.get("src\\homeWorks\\hw05_Files_and_Streams\\Resources\\text.txt");

        final Map<String, Integer> wordsCount = new HashMap<>();
        final Map<String, Integer> inputTextToLowerCase = new HashMap<>();


        try (BufferedReader wordsToLookForInTheInput = Files.newBufferedReader(inPath);
             BufferedReader reader = Files.newBufferedReader(inputText)) {

            // palnim map s kliu4 vsqka duma ot inputTextaToLowerCase, a za stoinost vsqka kolko pyti se sreshta v text-a
        	
            String line;
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split("([.,!?]?\\s+|[!?.])"))
                        .forEach(word -> {

                        	if (inputTextToLowerCase.containsKey(word.toLowerCase())) {
                        		inputTextToLowerCase.put(word.toLowerCase(), inputTextToLowerCase.get(word.toLowerCase())+1);
                        	} else {
                        	   	inputTextToLowerCase.put(word.toLowerCase(), 1);
                        	}

                        });
            }
                        
            
            // palnim map s tyrsenite dumi i tehniq broi v originalniq text
            wordsToLookForInTheInput.lines()
            .forEach(str -> Arrays.stream(str.split("\\s+"))
                    .forEach(word -> {
                        word = word.toLowerCase();
                        if (!wordsCount.containsKey(word)) {
                            wordsCount.put(word, 0);
                        }
                        if (inputTextToLowerCase.containsKey(word)) {
                            wordsCount.put(word, inputTextToLowerCase.get(word));
                        }
                    }));


        } catch (IOException e) {
            e.printStackTrace();
        }

        //sortirame dumite po broi sre6taniq v teksta (sort by value).
        wordsCount.entrySet().stream()
                .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                .forEach(kvp -> System.out.printf("%s - %d%n",
                        kvp.getKey(), kvp.getValue()));
    }
}
