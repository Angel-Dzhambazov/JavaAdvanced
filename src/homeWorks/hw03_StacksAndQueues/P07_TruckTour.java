package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class P07_TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStations = Integer.parseInt(scanner.nextLine());
        Deque<String> stations = new ArrayDeque<>();
        for (int i = 0; i < numberOfStations; i++) {
            stations.offer(scanner.nextLine());
        }
        Deque<String> testQueue = new ArrayDeque<>();
        testQueue.addAll(stations);
        int tank = 0;
        int startPossition = 0;


        while (!testQueue.isEmpty()) {
            String[] currentStation = testQueue.poll().split(" ");
            tank += Integer.parseInt(currentStation[0]);
            tank -= Integer.parseInt(currentStation[1]);
            if (tank < 0) {
                startPossition++;
                tank = 0;
                testQueue.clear();
                testQueue.addAll(stations);
                for (int i = 0; i < startPossition; i++) {
                    String stationToBeRotated = testQueue.poll();
                    testQueue.offer(stationToBeRotated);
                }
            }
            if (testQueue.isEmpty()) {
                System.out.println(startPossition);
                break;
            }
        }
    }
}
