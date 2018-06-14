import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestHelloWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(reader.readLine());
        String binaryY = intToBinary(y);
        String binaryX = changeBits(binaryY);
        int x = binaryToInt(binaryX);
        System.out.println(x);
    }

    private static int binaryToInt(String binaryX) {
        char[] array = binaryX.toCharArray();
        int x = 0;
        for (int i = array.length - 1; i >= 0; i--) if (array[i] == '1') x += Math.pow(2, (array.length - i - 1));
        return x;
    }

    private static String changeBits(String binaryY) {
        char[] array = binaryY.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binaryY.length(); i++) {
            if (array[i] == '1') {
                sb.append(0);
            } else {
                sb.append(1);
            }
        }
        return sb.toString();
    }

    private static String intToBinary(int y) {
        StringBuilder sb = new StringBuilder();
        if (y == 0 || y == 1) {
            return String.valueOf(y);
        } else {
            while (y != 0) {
                sb.append(y % 2);
                y /= 2;
            }
        }
        return sb.reverse().toString();
    }
}
