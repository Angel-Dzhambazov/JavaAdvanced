package seeburger.files;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayDeque;

public class CopyManager {

    private File source;
    private File destination;
    private ArrayDeque<File> files = new ArrayDeque<>();

    public CopyManager(String source, String destination) {
        this.source = new File(source);
        this.destination = new File(destination);
    }
    Object test = new Object();

    public boolean checkEmptyDirectory() {

        boolean isDirectoryEmpty = source.listFiles().length <= 0;

        return isDirectoryEmpty;
    }

    public void copyFiles() throws IOException {

        for (File file : source.listFiles()) {
            files.add(file);
        }

        File currentFile = null;

        Path sourcePath;
        Path destinationPath;

        while (!files.isEmpty()) {

            currentFile = files.pop();

            sourcePath = Paths.get(currentFile.getPath());
            destinationPath = Paths.get(destination.getPath() + File.separator + currentFile.getName());

            Files.move(sourcePath, destinationPath, StandardCopyOption.ATOMIC_MOVE);


        }
    }

}