package Lectures.L04_Sets_Maps;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by fluch on 5/26/2017.
 */
public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> parking = new HashSet<String>();

        while (true) {
            String input = scanner.nextLine();
            if ("END".equals(input)) {
                break;
            } else {
                String[] currentCar = input.split(", ");
                if ("IN".equals(currentCar[0])) {
                    parking.add(currentCar[1]);
                } else if ("OUT".equals(currentCar[0])) {
                    parking.remove(currentCar[1]);
                }
            }
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }
    }

}
