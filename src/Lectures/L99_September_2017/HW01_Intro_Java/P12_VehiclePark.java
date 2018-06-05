package Lectures.L99_September_2017.HW01_Intro_Java;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12_VehiclePark {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] vehicles = reader.readLine().split(" ");
        Integer sold = 0;

        String command = reader.readLine();
        while (!"End of customers!".equals(command)) {
            boolean didWeSellACar = false;
            for (int i = 0; i < vehicles.length; i++) {
                if (!"".equals(vehicles[i])) {
                    char type = vehicles[i].charAt(0);
                    String seats = vehicles[i].substring(1, vehicles[i].length());
                    if (doWeHaveSuchCar(command, type, seats)) {
                        Integer typeValue = (int) vehicles[i].charAt(0);
                        Integer seatsAsDigit = Integer.valueOf(seats);
                        Integer soldPrice = typeValue * seatsAsDigit;
                        System.out.printf("Yes, sold for %d$\n", soldPrice);

                        vehicles[i] = "";
                        didWeSellACar = true;
                        sold++;
                        break;
                    }
                }
            }
            if (!didWeSellACar) {
                System.out.println("No");
            }
            command = reader.readLine();
        }
        String[] updatedPark = new String[vehicles.length - sold];
        Integer positionInUpdatedPark = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (!"".equals(vehicles[i])) {
                updatedPark[positionInUpdatedPark] = vehicles[i];
                positionInUpdatedPark++;
            }
        }

        String debug = "";

        String joined = String.join(", ", updatedPark);
        System.out.println("Vehicles left: " + joined);

        System.out.println("Vehicles sold: " + sold);


    }

    private static void printSoldAndPrice(String vehicle) {


    }

    private static boolean doWeHaveSuchCar(String command, char type, String seats) {
        String[] tokens = command.split(" ");
        String vehicle = tokens[0].toLowerCase();

        if (type == vehicle.charAt(0)) {
            if (tokens[2].equals(seats)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;

        }

    }
}
