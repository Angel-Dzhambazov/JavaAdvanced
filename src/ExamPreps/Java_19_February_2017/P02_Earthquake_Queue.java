package ExamPreps.Java_19_February_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P02_Earthquake_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.valueOf(reader.readLine());
        Deque<int[]> earthquake = new ArrayDeque<>();
        int outputCount = 0;
        StringBuilder outputString = new StringBuilder();

        // Deque => offer/poll
        for (int i = 0; i < lines; i++) {
            String[] numbers = reader.readLine().split(" ");
            int[] waves = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                waves[j] = Integer.valueOf(numbers[j]);
            }
            earthquake.offer(waves);
        }

        while (!earthquake.isEmpty()) {
            int[] wave = earthquake.poll();
            if (wave.length == 1) {
                outputCount++;
                outputString.append(wave[0] + " ");
            } else {
                for (int j = 1; j < wave.length; ) {
                    if (wave[0] >= wave[j]) {
                        j++;
                        if (j == wave.length){
                            outputCount++;
                            outputString.append(wave[0] + " ");
                            break;
                        }
                    } else if (wave[0] < wave[j]) {
                        outputCount++;
                        outputString.append(wave[0] + " ");
                        int[] newWave = new int[wave.length - j];
                        for (int k = 0; k < wave.length - j; k++) {
                            newWave[k] = wave[k + j];
                        }
                        earthquake.offer(newWave);
                        break;
                    }


                }
            }
        }
        outputString.deleteCharAt(outputString.length() - 1);
        System.out.println(outputCount);
        System.out.println(outputString);
    }
}
