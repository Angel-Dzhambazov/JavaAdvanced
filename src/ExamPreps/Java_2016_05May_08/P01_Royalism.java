package ExamPreps.Java_2016_05May_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01_Royalism {

    //All hail Royal!
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // R = 18ta bukva

        String[] input = reader.readLine().split(" ");


        Integer royalists = 0;
        Integer declinedRoyalists = 0;
        List listRoyalists = new ArrayList();
        List listDeclinedRoyalists = new ArrayList();
        for (String s : input) {
            Integer sum = 0;
            char[] currentArray = s.toCharArray();
            for (char c : currentArray) {
                sum += (int) c;
            }
            if (sum > 26) {
                sum = sum % 26;
            }
            if (sum == 18) {
                royalists += 1;
                listRoyalists.add(s);
            } else {
                declinedRoyalists += 1;
                listDeclinedRoyalists.add(s);
            }
        }

        if (royalists >= declinedRoyalists) {
            System.out.println("Royalists - " + royalists);
            for (Object listRoyalist : listRoyalists) {
                System.out.println(listRoyalist);
            }
            System.out.println("All hail Royal!");
        } else {
            for (Object denied : listDeclinedRoyalists) {
                System.out.println(denied);
            }
            System.out.println("Royalism, Declined!");

        }

        String debug = "";


    }
}
