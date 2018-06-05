package ExamPreps.Java_2016_06June_13_Sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class P01_JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        StringBuilder jedis = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String currentLine = reader.readLine();
            jedis.append(currentLine);
            jedis.append(" ");
        }

        String[] array = jedis.toString().split(" ");

        List<String> masters = new ArrayList<>();
        List<String> knights = new ArrayList<>();
        List<String> padawans = new ArrayList<>();
        List<String> toshko = new ArrayList<>();
        //LinkedHashSet<String> masters = new LinkedHashSet<>();
        // LinkedHashSet<String> knights = new LinkedHashSet<>();
        // LinkedHashSet<String> padawans = new LinkedHashSet<>();
        // LinkedHashSet<String> toshko = new LinkedHashSet<>();
        Boolean isYodaPresent = false;
        for (String currentJedi : array) {
            char[] whatKind = currentJedi.toCharArray();
            switch (whatKind[0]) {
                case 'm':
                    masters.add(currentJedi);
                    break;
                case 'k':
                    knights.add(currentJedi);
                    break;
                case 'p':
                    padawans.add(currentJedi);
                    break;
                case 't':
                    toshko.add(currentJedi);
                    break;
                case 's':
                    toshko.add(currentJedi);
                    break;
                case 'y':
                    isYodaPresent = true;
                    break;
            }
        }

        if (!isYodaPresent) {
            for (String s : toshko) {
                System.out.print(s + " ");
            }
        }

        for (String master : masters) {
            System.out.print(master + " ");
        }
        for (String knight : knights) {
            System.out.print(knight + " ");
        }
        if (isYodaPresent) {
            for (String s : toshko) {
                System.out.print(s + " ");
            }
        }

        for (String padawan : padawans) {
            System.out.print(padawan + " ");
        }


    }
}

