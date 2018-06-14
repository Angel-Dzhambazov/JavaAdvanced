package seeburger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//judge has this input:
//000000005
//000000005
public class P02_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String one = removeZeroes(reader.readLine());
        String two = removeZeroes(reader.readLine());

        if (one.length() < two.length()) {
            String temp = one;
            one = two;
            two = temp;
        }
        int toAdd = 0;

        StringBuilder sb = new StringBuilder();
        while (two.length() > 0) {
            String justOne = one.substring(one.length() - 1, one.length());
            String justTwo = two.substring(two.length() - 1, two.length());
            one = (one.substring(0, one.length() - 1));
            two = (two.substring(0, two.length() - 1));
            int a = Integer.parseInt(justOne);
            int b = Integer.parseInt(justTwo);
            int result = a + b + toAdd;
            sb.append(result % 10);
            toAdd = result / 10;
        }
        while (one.length() > 0) {
            String justOne = one.substring(one.length() - 1, one.length());
            int a = Integer.parseInt(justOne);
            int result = a + toAdd;
            sb.append(result % 10);
            toAdd = result / 10;
            one = one.substring(0, one.length() - 1);
        }
        if (toAdd == 1) {
            sb.append(toAdd);
        }
        System.out.println(sb.reverse().toString());
    }

    public static String removeZeroes(String str) {
        while ("0".equalsIgnoreCase(str.substring(0, 1))) {
            str = str.substring(1, str.length());
        }
        return str;
    }

}