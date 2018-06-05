package Lectures.L02_MultidimentionalArrays.ExamPreps.Java_2016_05May_08;

public class wtf {
    public static void main(String[] args) {
        Integer sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i*10*10;
            System.out.println(sum);

        }
        System.out.println(sum);
        Integer sum2 = 0;
        for (int i = 2; i <= 9; i++) {
            sum2+= 10*i;
            System.out.println( sum2);
        }
        System.out.println( sum2);
        System.out.println(sum+sum2);
    }
}
