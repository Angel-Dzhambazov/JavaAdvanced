package seeburger.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayDeque;

//File obsolete? deprecated

public class CopyManager {

	private File source;
	private File destination;
	private ArrayDeque<File> files = new ArrayDeque<>();


	public CopyManager(String source, String destination) {
		this.source = new File(source);
		this.destination = new File(destination);
	}

	public boolean checkEmptyDirectory() {
		return source.listFiles().length <= 0;
	}

	public void copyFiles() throws IOException {

		/*
		 * this method used to add both files and directories to the Queue now it adds
		 * only files without directories!
		 */

		for (File file : source.listFiles()) {
//			tova palni samo failove!
//			if (file.isFile()) {
//				files.add(file);
//			}
			files.add(file);
		}

		File currentFile = null;

		Path sourcePath;
		Path destinationPath;

		while (!files.isEmpty()) {

			currentFile = files.pop();

			//currentFile.length()
			//currentFile.canWrite()

			sourcePath = Paths.get(currentFile.getPath());
			destinationPath = Paths.get(destination.getPath() + File.separator + currentFile.getName());

			// Files.move(sourcePath, destinationPath , StandardCopyOption.ATOMIC_MOVE);


			//overwrite
			try {
				Files.move(sourcePath, destinationPath);

			} catch (FileAlreadyExistsException aee) {
				currentFile.delete();
			}
		}
	}
}