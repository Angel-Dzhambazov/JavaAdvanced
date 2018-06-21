package seeburger.graphImplementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileToUse = reader.readLine();

        Graph ourGraph = new Graph(fileToUse);
    }
}
