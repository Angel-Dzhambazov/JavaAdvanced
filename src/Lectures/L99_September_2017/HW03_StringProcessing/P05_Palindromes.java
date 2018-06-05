package Lectures.L99_September_2017.HW03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class P05_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[\\s,?!\\.]");
        List<String> polindroms = new ArrayList<>();
        Set<String> order = new TreeSet<>();


        for (String s : input) {
            if (!"".equals(s)) {
                if (s.length() == 1) {
                    polindroms.add(s);
                    order.add(s);
                } else {
                    String[] sA = s.split("");
                    for (int i = 0; i < s.length() / 2; i++) {
                        int oppositeElement = s.length() - i - 1;
                        if (!sA[i].equals(sA[oppositeElement])) {
                            break;
                        } else {
                            if (i + 1 == s.length() / 2) {
                                polindroms.add(s);
                                order.add(s);
                            }
                        }
                    }
                }
            }
        }

        String[] array = polindroms.toArray(new String[0]);
        Arrays.sort(array);
        String output = Arrays.stream(array).collect(Collectors.joining(", "));
        //System.out.printf("[%s]",output);
        System.out.println(order);

    }
}
