/*
 * PerformanceCar.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12.entities.cars;


import java.util.ArrayList;
import java.util.List;


public class PerformanceCar extends BaseCar
{
    private List<String> addOns;


    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability)
    {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(super.toString());
        String addonsAsString = addOns.size() == 0 ? "None" : String.join(", ", this.addOns);
        sb.append(System.lineSeparator()).append(String.format("Add-ons: %s", addonsAsString));

        return sb.toString();
    }
}
