package Lectures.L99_September_2017.HW01_Intro_Java;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_TriangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] one = reader.readLine().split(" ");
        String[] two = reader.readLine().split(" ");
        String[] three = reader.readLine().split(" ");

        Integer area  = calculateArea(one,two,three);
        System.out.println(area);
    }





    private static Integer calculateArea(String[] one, String[] two, String[] three) {
        Integer Ax = Integer.valueOf(one[0]);
        Integer Ay = Integer.valueOf(one[1]);
        Integer Bx = Integer.valueOf(two[0]);
        Integer By = Integer.valueOf(two[1]);
        Integer Cx = Integer.valueOf(three[0]);
        Integer Cy = Integer.valueOf(three[1]);

        Integer area = Ax*(By-Cy)+Bx*(Cy-Ay)+Cx*(Ay-By);
        if (area<0){
            area*=-1;
        }
        area /=2;
        return  area;
    }
}
