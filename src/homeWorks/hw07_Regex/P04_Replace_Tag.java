
package homeWorks.hw07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_Replace_Tag {
    public static void main(String[] args) throws IOException {

        // dva problema izleznaha, kato pravim patter-na trqbva da e s+ za da ima prazni redove nov red i drugi
        // vtoriqt e 4e moje na edin red da ima pove4e za prepravqne, togava trrqbva v kraq na while-a da se vikne matcher = pattern.matcher(sb);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)<\\/a>");

        StringBuilder sb = new StringBuilder();
        String currentLine = reader.readLine();

        while (!"END".equals(currentLine)) {
            sb.append(currentLine).append(System.getProperty("line.separator"));
            currentLine = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            // group 1 = <a     da stane => [URL
            // group 3 = >      da stane => ]
            // group 5 = </a>   da stane => [/URL]

            int startIndex = matcher.start();
            int endIndex = matcher.end();

            String replacedTag = "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
            sb.replace(startIndex, endIndex, replacedTag);
            matcher = pattern.matcher(sb);

        }




        System.out.println(sb);


    }
}
