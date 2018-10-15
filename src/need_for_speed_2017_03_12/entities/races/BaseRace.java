/*
 * BaseRace.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12.entities.races;


import java.util.List;

import need_for_speed_2017_03_12.contracts.Car;


public abstract class BaseRace
{
    private int length;
    private String routeString;
    private int prizePool;
    private List<Car> participants;
}
