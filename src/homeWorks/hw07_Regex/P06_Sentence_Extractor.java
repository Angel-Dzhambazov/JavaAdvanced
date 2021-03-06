
package homeWorks.hw07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_Sentence_Extractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();
        Pattern pattern = Pattern.compile("(^| )[^!.?]+ " + word + " .+?[.!?]");
        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
