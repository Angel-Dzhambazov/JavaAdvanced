package seeburger.files;



import java.io.File;
import java.nio.file.Files;

public class MovingFilesFromDirectory {
	public static final String PATH1 = "F:\\TRASH\\";
	public static final String PATH2 = "G:\\Softuni\\untitled\\";
	public static final String OLD_FILE_NAME = "IMG_20170503_174056.jpg";
	public static final String NEW_FILE_NAME = "IMG_20170503_174056.jpg";

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