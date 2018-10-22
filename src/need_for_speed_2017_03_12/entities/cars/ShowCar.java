/*
 * ShowCar.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12.entities.cars;



public class ShowCar extends BaseCar
{
    private int stars;


    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability)

    {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        stars = 0;
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(super.toString());
        String startsAsString = stars == 0 ? "None" : String.format("%d *", this.stars);
        sb.append(System.lineSeparator()).append(String.format("Add-ons: %s", startsAsString));

        return sb.toString();
    }

}
