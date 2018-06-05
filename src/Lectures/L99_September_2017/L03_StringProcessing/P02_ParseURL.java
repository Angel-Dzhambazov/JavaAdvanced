package Lectures.L99_September_2017.L03_StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02_ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] url = reader.readLine().split("://");
         if (url.length != 2) {
            System.out.println("Invalid URL");
        } else {
            String protocol = url[0];
            String server = url[1].substring(0, url[1].indexOf("/"));
            String resources = url[1].substring(url[1].indexOf("/") + 1, url[1].length());
            System.out.printf("Protocol = %s%nServer = %s%nResources = %s%n", protocol, server, resources);
        }

    }
}
