package homeWorks.hw03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06_Robotics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsInput = scanner.nextLine().split(";");

        String[] robotName = new String[robotsInput.length];
        int[] processTime = new int[robotsInput.length];
        int[] robotsCounter = new int[robotsInput.length];
        for (int i = 0; i < robotsInput.length; i++) {
            String[] robotsToken = robotsInput[i].split("-");
            robotName[i] = robotsToken[0];
            processTime[i] = Integer.parseInt(robotsToken[1]);
        }
        String[] time = scanner.nextLine().split(":");
        long h = Long.parseLong(time[0]) * 60 * 60;
        long m = Long.parseLong(time[1]) * 60;
        long s = Long.parseLong(time[2]);
        long seconds = h + m + s;

        Deque<String> products = new ArrayDeque<>();
        String product = "";
        while (!"End".equals(product = scanner.nextLine())) {
            products.offer(product);
        }
        while (!products.isEmpty()) {
            seconds++;
            for (int i = 0; i < robotName.length; i++) {
                if (robotsCounter[i] > 0) {
                    robotsCounter[i]--;
                }
            }

            String currentProduct = products.poll();
            boolean isProductTaken = false;
            for (int i = 0; i < robotName.length; i++) {
                if (robotsCounter[i] == 0) {
                    robotsCounter[i] = processTime[i];
                    isProductTaken = true;
                    System.out.printf("%s - %s [%s]%n", robotName[i], currentProduct, convertSecondsToHMS(seconds));
                    break;
                }
            }
            if (!isProductTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static String convertSecondsToHMS(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
