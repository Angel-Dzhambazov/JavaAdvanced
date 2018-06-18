package seeburger.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class Toni {
	public static final String PATH1 = "C:/Users/a.dzhambazov/Desktop/deklaracii/";
	public static final String PATH2 = "C:/Users/a.dzhambazov/Desktop/deklaracii/premesten file/";
	public static final String OLD_FILE_NAME = "testFile.txt";
	public static final String NEW_FILE_NAME = "thisFileHasBeenMoved.txt";
	public static final String STRING_TO_ADD = "subject=testFile";
	public static final String STRING_TO_SEARCH = "Database";

	public static void main(String[] args) {
		String firstFilePath = PATH1 + OLD_FILE_NAME;
		String secondFilePath = PATH2 + NEW_FILE_NAME;

		try {
			copyDirectory(firstFilePath, secondFilePath);

			appendToFile(secondFilePath, STRING_TO_ADD);

			searchFile(secondFilePath, STRING_TO_SEARCH);

			boolean checkEqual = checkEqualFiles(firstFilePath, secondFilePath);
			System.out.println(checkEqual);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean checkEqualFiles(String firstFilePath, String secondFilePath) throws Exception {
		File file1 = new File(firstFilePath);
		File file2 = new File(secondFilePath);

		if (file1.length() != file2.length())
			return false;

		byte[] bytes1 = Files.readAllBytes(file1.toPath());
		byte[] bytes2 = Files.readAllBytes(file2.toPath());

		return Arrays.equals(bytes1, bytes2);
	}

	private static boolean checkEqualFilesOptimized(String firstFilePath, String secondFilePath) throws Exception {
		File file1 = new File(firstFilePath);
		File file2 = new File(secondFilePath);

		if (file1.length() != file2.length())
			return false;

		boolean isEqual = false;
		int step = 2048;

		try (FileInputStream fis1 = new FileInputStream(file1); FileInputStream fis2 = new FileInputStream(file2);) {

		}

		return isEqual;
	}


	private static void searchFile(String dest, String stringToSearch) throws Exception {
		File file = new File(dest);

		Scanner scanner = new Scanner(file);

		boolean found = false;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains(stringToSearch)) {
				System.out.println(line);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("String not found" + System.lineSeparator());
		}

		scanner.close();
	}

	private static void appendToFile(String dest, String strToAppend) throws Exception {
		Files.write(Paths.get(dest), (System.lineSeparator() + strToAppend).getBytes(), StandardOpenOption.APPEND);
	}

	private static void copyDirectory(String source, String dest) throws Exception {
		File oldFile = new File(source);
		File newFile = new File(dest);

		// Files.copy(oldFile.toPath(), newFile.toPath(),
		// StandardCopyOption.REPLACE_EXISTING);
		Files.move(oldFile.toPath(), newFile.toPath());
	}
}