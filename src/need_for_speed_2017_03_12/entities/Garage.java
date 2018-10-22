/*
 * Garage.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12.entities;


import java.util.ArrayList;
import java.util.List;

import need_for_speed_2017_03_12.contracts.Car;


public class Garage
{
    private List<Car> parkedCars;


    public Garage()
    {
        this.parkedCars = new ArrayList<>();
    }
}
