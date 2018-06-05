package Lectures.L06_Manual_String_Operations;

import java.util.Scanner;

/**
 * Created by fluch on 7/25/2017.
 */
public class P02_ParseURLS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("://");
        if (input.length!=2){
            System.out.println("Invalid URL");
        } else {
            System.out.println(String.format("Protocol = %s",input[0]));
            int index = input[1].indexOf("/");
            String server = String.format("Server = %s",input[1].substring(0,index));
            String resource = String.format("Resources = %s",input[1].substring(index+1));
            System.out.println(server);
            System.out.println(resource);

        }



    }
}
