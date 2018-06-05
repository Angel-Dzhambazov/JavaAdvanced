package Lectures.L99_September_2017.HW04_DataRepresentation;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class P04_CombinationsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(reader.readLine());
        Integer k = Integer.valueOf(reader.readLine());

        Long result = binominal(n, k);
        System.out.println(result);
    }

    private static long binominal(Integer n, Integer k) {
        if (k > n - k) {
            k = n - k;
        }
        long b = 1;

        for (int i = 1, m = n; i <= k; i++, m--) {
            b = b * m / i;
        }
        return b;
    }

}
