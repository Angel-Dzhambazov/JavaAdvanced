
package homeWorks.hw07_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_Series_Of_Letters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher matcher = pattern.matcher(reader.readLine());

        while (matcher.find()){
            System.out.print(matcher.group(1));
            System.out.println("This is a github push test");
        }
    }

}













