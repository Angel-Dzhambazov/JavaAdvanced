package Lectures.L06_Manual_String_Operations;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by fluch on 7/24/2017.
 */
public class P01_Students_Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> result = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split(" - ");
            String[] examResultsLikeString = input[1].split(", ");
            List<Double> examResults = new ArrayList<>();
            double sum = 0;
            for (String grade : examResultsLikeString) {
                double reminder = Double.parseDouble(grade);
                sum+= reminder;
                examResults.add(reminder);
            }
            examResults.add(sum/3);
            result.put(input[0], examResults);
        }

        if (number!=0){
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|"
                    , "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
            for (String student : result.keySet()) {
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|"
                        , student, result.get(student).get(0)
                        , result.get(student).get(1), result.get(student).get(2), result.get(student).get(3)).replace(".",","));
            }
        }
    }
}
