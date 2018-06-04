

package homeWorks.hw07_Regex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Match_Full_Name {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String currentLine = reader.readLine();

        //Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        Pattern pattern = Pattern.compile("^\\+359( |-)2\\1\\d{3}\\1\\d{4}$");
        while (!"end".equals(currentLine)){
            Matcher matcher = pattern.matcher(currentLine);
            if (matcher.find()){
                System.out.println(matcher.group());
            }
            currentLine = reader.readLine();
        }
    }
}
