/*
 * Main.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12;


import need_for_speed_2017_03_12.contracts.CarManager;
import need_for_speed_2017_03_12.core.CarManagerImpl;
import need_for_speed_2017_03_12.engine.Engine;
import need_for_speed_2017_03_12.io.ConsoleInputReader;
import need_for_speed_2017_03_12.io.ConsoleOutputWriter;
import need_for_speed_2017_03_12.utilities.InputParser;


public class Main
{
    public static void main(String[] args)
    {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();

        CarManager manager = new CarManagerImpl();
        Engine engine = new Engine(inputReader, consoleOutputWriter, inputParser, manager);

    }
}
