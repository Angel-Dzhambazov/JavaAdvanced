/*
 * BaseCar.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12.entities.cars;


import need_for_speed_2017_03_12.contracts.Car;


public abstract class BaseCar implements Car
{
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;


    protected BaseCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability)
    {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }


    // {brand} {model} {yearOfProduction}
    // o {horsepower} HP, 100 m/h in {acceleration} s
    // o {suspension} Suspension force, {durability} Durability

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d", this.brand, this.model, this.yearOfProduction)).append(System.lineSeparator());
        sb.append(String.format("%d HP, 100 m/h in %d s"), this.horsepower, this.acceleration).append(System.lineSeparator());
        sb.append(String.format("%d Suspension force, %d Durability"), this.suspension, this.durability);
        return sb.toString();
    }
}
