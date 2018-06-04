package homeWorks.hw01_JavaSyntax;


import java.util.Scanner;

/**
 * Created by fluch on 4/22/2017.
 */
public class P02_TriangleArea {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int xA = scanner.nextInt();
        int yA = scanner.nextInt();
        int xB = scanner.nextInt();
        int yB = scanner.nextInt();
        int xC = scanner.nextInt();
        int yC = scanner.nextInt();

        int area = (xA*(yB-yC) +xB*(yC-yA)+xC*(yA-yB))/2;
        if (area<0){
            area = area*(-1);
        }
        System.out.println(area);
    }
}

