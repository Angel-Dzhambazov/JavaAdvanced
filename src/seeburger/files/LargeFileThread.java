package seeburger.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;


//thread factory? How to do it
class LargeFileThread extends Thread {
    Path sourcePath;
    Path destinationPath;

    LargeFileThread(File file, Path sourcePath, Path destinationPath) throws IOException {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.moveLargeFile(file);
    }

    private void moveLargeFile(File file) throws IOException {
        try {
            System.out.println("We are in the private method of the additional thread");
            System.out.println("file name is: "  + file.getName());
            Files.move(sourcePath, destinationPath);
            System.out.println("Moving of " + file.getName()+" completed");
        }catch (FileAlreadyExistsException aee) {
            //Result of File.delete() is ignored => Zashto?
            file.delete();
        }
    }
}
