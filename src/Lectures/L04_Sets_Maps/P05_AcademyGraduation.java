package Lectures.L04_Sets_Maps;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class P05_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();

            String[] scores = scanner.nextLine().split(" ");
            double sumOfscores = 0;
            for (String grade : scores) {
                sumOfscores += Double.parseDouble(grade);
            }
            sumOfscores = sumOfscores / scores.length;
            students.put(name, sumOfscores);

        }

        for (String key : students.keySet()) {
            System.out.println(key + " is graduated with " + students.get(key));
        }

    }
}
