package seeburger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderMethod {

	public static void main(String[] args) {
		String input = "C:\\Program Files\\Java";
		findSubfoulder(input);
	}

	private static void findSubfoulder(String input) {
		if (input == null) {
			System.out.println("You have not entered a valid directory path");
		} else {
			File folder = new File(input);
			File[] listOfFiles = folder.listFiles();
			try {
				List<String> listOfDirectories = new ArrayList();
				for (File innerFolder : listOfFiles) {
					if (innerFolder.isDirectory()) {
						listOfDirectories.add(innerFolder.getName());
					}
				}
				int size = listOfDirectories.size();
				switch (size) {
				case 0:
					System.out.println("The directory does not contain any sub directories");
					break;
				case 1:
					System.out.println(listOfDirectories.get(0));
					break;
				default:
					System.out.println("The directory contains more than one directories");
					break;
				}
			} catch (NullPointerException npl) {
				System.out.println("You have not entered a valid directory path");
			}
		}
	}
}
