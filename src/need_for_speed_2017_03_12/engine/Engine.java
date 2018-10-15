/*
 * Engine.java
 *
 * created at 2018-10-15 by a.dzhambazov <YOURMAILADDRESS>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package need_for_speed_2017_03_12.engine;


import java.util.List;

import need_for_speed_2017_03_12.contracts.CarManager;
import need_for_speed_2017_03_12.io.ConsoleInputReader;
import need_for_speed_2017_03_12.io.ConsoleOutputWriter;
import need_for_speed_2017_03_12.utilities.InputParser;


public class Engine
{
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager manager;


    public Engine(ConsoleInputReader consoleInputReader, ConsoleOutputWriter consoleOutputWriter, InputParser inputParser, CarManager carManager)
    {
        this.inputReader = consoleInputReader;
        this.outputWriter = consoleOutputWriter;
        this.inputParser = inputParser;
        this.manager = carManager;
    }


    public void run()
    {
        String inputLine = null;

        while (true)
        {
            // inputLine = this.inputReader.readLine();
            // List<String> commandParsesList = this.inputParser.parseIntput(inputLine);

            if (inputLine.equals("INPUT_TERMINATING_COMMAND"))
            {
                break;
            }
        }
    }


    private void dispatchCommand(List<String> commandParses)
    {
        String command = commandParses.remove(0);
        switch (command)
        {
            case "asd":

                break;

            default:
                break;
        }
    }
}
