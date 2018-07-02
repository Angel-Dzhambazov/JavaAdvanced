
package seeburger.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlComparation {
	private static List<String> fileListInFirstFolder = new ArrayList<>();

	public static void main(String[] args) {
		final File folder = new File("C:\\Users\\a.dzhambazov\\Desktop\\deklaracii\\MT\\MessageTrackingInfo");

		listFilesForFolder(folder);
	}

	public static void listFilesForFolder(File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
				fileListInFirstFolder.add(fileEntry.getName().toLowerCase());

			}
		}
	}
}
