package Homeworks.HW10_BitOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


// za stari izpiti ot programing basics - old examps ot  8 nomevri nadolu ima bitovi operacii
//8773276988229695713
// mask?

public class P01_BitFlipper_ExamPreparation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger num = new BigInteger(reader.readLine());
        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");
        //System.out.println(num.toString(2));

        for (int i = 0; i <= 61; i++) {
            BigInteger threeDigits = num.shiftRight(61-i).and(seven);
            //System.out.println(threeDigits.toString(2));

            if (threeDigits.equals(seven) || threeDigits.equals(zero)){

                System.out.println(num.toString(2));
                System.out.println(threeDigits.shiftLeft(61-i).toString(2));
                num = num.xor(seven.shiftLeft(61-i));

                i+=2;
            }
        }
        System.out.println(num);

    }
}
