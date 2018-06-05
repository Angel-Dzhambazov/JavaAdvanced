package ExamPreps.Java_2017_10Octomber_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_RegEx {
    private static StringBuilder OUTPUT = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder workingLine = new StringBuilder(reader.readLine());
        String commandPattern = reader.readLine();

        int count = 0;
        while (!"Print".equals(commandPattern)) {
            count++;
            if (commandPattern.contains("%")) {
                int index = commandPattern.indexOf("%");
                while (index >= 0) {
                    String firstPart = commandPattern.substring(0, index);
                    String lastPart = commandPattern.substring(index + 1, commandPattern.length());
                    commandPattern = firstPart + "[^\\s]*" + lastPart;
                    index = commandPattern.indexOf("%");
                }
                String regex = commandPattern;

                regex.replaceAll(".", "[.]");
                int dotIndex = regex.indexOf(".");
                while (dotIndex >= 0) {
                    String firstPart = regex.substring(0, dotIndex);
                    String secondPart = regex.substring(dotIndex + 1, regex.length());
                    regex = firstPart + "[.]" + secondPart;
                    dotIndex = regex.indexOf(".",dotIndex+2);
                }


                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(workingLine.toString());
                while (matcher.find()) {
                    StringBuilder magic = new StringBuilder(matcher.group());

                    int indexMagic = workingLine.toString().indexOf(magic.toString());

                    String firstPart = indexMagic == 0 ? "" : workingLine.toString().substring(0, indexMagic);
                    String lastPart = workingLine.toString().substring(indexMagic + magic.length(), workingLine.toString().length());
                    magic.reverse();
                    String tempLine = firstPart + magic.toString() + lastPart;
                    workingLine.delete(0, workingLine.length());
                    workingLine.append(tempLine);

                }

                // System.out.println("Problem, line:" + count);
            } else {

                int index = workingLine.toString().indexOf(commandPattern);
                while (index >= 0) {
                    StringBuilder middle = new StringBuilder(workingLine.toString().substring(index, index + commandPattern.length()));
                    middle.reverse();

                    String firstPart = index == 0 ? "" : workingLine.toString().substring(0, index);
                    String secondPart = workingLine.toString().substring(index + commandPattern.length(), workingLine.toString().length());
                    String finalLine = firstPart + middle.toString() + secondPart;
                    workingLine.delete(0, workingLine.length());
                    workingLine.append(finalLine);

                    index = workingLine.toString().indexOf(commandPattern);
                }
            }
            commandPattern = reader.readLine();
        }
        System.out.println(workingLine);

    }


}
