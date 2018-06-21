package seeburger.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            long fileSize = currentFile.length();
            fileSize /= (1024 * 1024);
            //currentFile.length()
            //currentFile.canWrite()
            sourcePath = Paths.get(currentFile.getPath());
            destinationPath = Paths.get(destination.getPath() + File.separator + currentFile.getName());
            // Files.move(sourcePath, destinationPath , StandardCopyOption.ATOMIC_MOVE);
            //we should overwrite, not ignore the move command
            if (fileSize < 200) {
                try {
                    System.out.println("Starting moving of file: " + currentFile.getName());
                    Files.move(sourcePath, destinationPath);
                    System.out.println("Finishing moving of file: " + currentFile.getName());
                } catch (FileAlreadyExistsException aee) {
                    //Result of File.delete() is ignored => Zashto? (IntelliJ подчертава delete и казва че резултата е игнориран )
                    currentFile.delete();
                }
            } else {
                //tuk ideqta e ako file-a e nad 200MB da se zapo4ne nova nishka, koqto da si go prehvarhq na zaden plan,
                // oba4e az imam 4uvstvoto 4e dokato ne se prehvarli toq golemiq file nishto ne stava.
                // Taka kato sazdavam instanciq na tozi obekt
                System.out.println("Calling new single thread for a big file: " + currentFile.getName());
                LargeFileThread moveBigFile = new LargeFileThread(currentFile, sourcePath, destinationPath);
                System.out.println("Executing .start() command for file: "+ currentFile.getName());

                moveBigFile.start();
                try {
                    moveBigFile.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finishing of .start() command");
            }
        }
    }
}
