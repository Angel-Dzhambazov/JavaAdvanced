package seeburger.files;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static final String sourceFolder = "C://Users//a.dzhambazov//Desktop//deklaracii//filesToMove";
	private static final String destination = "C://Users//a.dzhambazov//Desktop//deklaracii//premesten file";

	public static void main(String[] args) throws IOException {

		// task
		CopyManager copyManager = new CopyManager(sourceFolder, destination);
		// Thread copy = new Thread("nqkakav task");
		// copy.start(); => polzva se tova
		// copy.run(); => tova ne se polzva

		// nishkata
		CopyProcessor copyThread = new CopyProcessor(copyManager);

		copyThread.start();

		System.out.println("Press any key to stop ...");
		Scanner scanner = new Scanner(System.in);

		scanner.nextLine();
		copyThread.shutdown();
	}
}
