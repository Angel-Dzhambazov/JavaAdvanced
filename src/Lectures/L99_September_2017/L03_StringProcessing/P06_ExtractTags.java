package Lectures.L99_September_2017.L03_StringProcessing;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class P06_ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("<.+?>");


        while (!"END".equals(input)){
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(matcher.group(0));
            }
            input = reader.readLine();
        }


    }
}
