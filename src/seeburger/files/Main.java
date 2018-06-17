package seeburger.files;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String sourceFolder = "F:\\TRASH";
    private static final String destination = "G:\\trash";

    public static void main(String[] args) throws IOException {

	CopyManager copyManager = new CopyManager(sourceFolder, destination);
	CopyProcessor copyThread = new CopyProcessor(copyManager);
	copyThread.start();

	System.out.println("Press any key to stop ...");
	Scanner scanner = new Scanner(System.in);

	scanner.nextLine();
	copyThread.shutdown();
    }
}