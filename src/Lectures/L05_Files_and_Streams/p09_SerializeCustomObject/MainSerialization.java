package Lectures.L05_Files_and_Streams.p09_SerializeCustomObject;


import java.io.*;

public class MainSerialization {
    private static String resourceFolder = "G:\\github june 2018\\JavaAdvanced\\src\\Lectures\\L05_Files_and_Streams\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Serialization\\";

    public static void main(String[] args) {
        String serializableObjectPath = resourceFolder + "object.ser";
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        try (FileOutputStream fileOutputStream = new FileOutputStream(serializableObjectPath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(serializableObjectPath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            Cube cube1 = (Cube) objectInputStream.readObject();
            System.out.println(cube1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
