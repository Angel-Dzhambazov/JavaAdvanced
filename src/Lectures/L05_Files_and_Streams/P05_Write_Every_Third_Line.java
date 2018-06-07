package Lectures.L05_Files_and_Streams;


import java.io.*;

public class P05_Write_Every_Third_Line {

    private static String PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    private static String OUTPUT_PATH = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputP02.txt";

    public static void main(String[] args) {

        int counter = 1;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(PATH)));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            while (line!= null){
                if (counter % 3 == 0) {
                    writer.println(line);
                }
                counter++;
                line = reader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
