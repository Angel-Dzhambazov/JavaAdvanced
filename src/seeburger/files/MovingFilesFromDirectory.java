package seeburger.files;



import java.io.File;
import java.nio.file.Files;

public class MovingFilesFromDirectory {
	public static final String PATH1 = "C:/Users/a.dzhambazov/Desktop/deklaracii/";
	public static final String PATH2 = "C:/Users/a.dzhambazov/Desktop/deklaracii/premesten file/";
	public static final String OLD_FILE_NAME = "testFile.txt";
	public static final String NEW_FILE_NAME = "thisFileHasBeenMoved.txt";

	public static void main(String[] args) {
		String firstFilePath = PATH1 + OLD_FILE_NAME;
		String secondFilePath = PATH2 + NEW_FILE_NAME;

		try {
			copyDirectory(firstFilePath, secondFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void copyDirectory(String source, String dest) throws Exception {
		File oldFile = new File(source);
		File newFile = new File(dest);

		// Files.copy(oldFile.toPath(), newFile.toPath(),
		// StandardCopyOption.REPLACE_EXISTING);
		Files.move(oldFile.toPath(), newFile.toPath());
	}
}