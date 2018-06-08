package homeWorks.hw10_BitOperations;

import java.math.BigInteger;

public class P99_test {
    public static void main(String[] args) {
        BigInteger digit = new BigInteger("71");
        System.out.println(digit.toString(2));
        BigInteger twoDigits = digit.shiftRight(6);
        System.out.println(twoDigits.toString(2));
    }
}
