package Lectures.L99_September_2017.HW04_DataRepresentation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10_SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        while (true) {
            String input = reader.readLine();
            if ("END".equals(input)) {
                break;
            }
            lines.add(input);
        }
        Pattern pattern = Pattern.compile("<div\\s+.*(?<forRemove>(id|class)\\s*=\\s*\"(?<target>[a-z]+)\").*>");
        Pattern pattern1 = Pattern.compile("<\\/div>\\s+<!--\\s*(?<target>[a-z]+)\\s*-->");

        for (int i = 0; i < lines.size(); i++) {
            Matcher matcher = pattern.matcher(lines.get(i));
            Matcher matcher1 = pattern1.matcher(lines.get(i));
            if (matcher.find()) {
                String newLine = lines.get(i)
                        .replace("<div", "<" + matcher.group("target"))
                        .replace(matcher.group("forRemove"), "");
                lines.set(i,newLine
                        .replaceAll("\\s+", " ")
                        .replaceAll("\\s*>",">"));

            }
            if (matcher1.find()){
                String newLine = lines.get(i).replace(matcher1.group(), "</"+ matcher1.group("target")+">");
                lines.set(i,newLine
                        .replaceAll("\\s+", " ")
                        .replaceAll("\\s*>",">"));
            }
        }

        for (String line : lines) {
            System.out.println(line);
        }

    }
}
