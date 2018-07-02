package automationTestForFiles;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import seeburger.files2.CopyManager;
import seeburger.files2.CopyProcessor;

public class Main {

	private static Map<Integer, Boolean> tests = new LinkedHashMap<Integer, Boolean>();
	private static final String sourceFolderForTest = "C:\\Users\\a.dzhambazov\\Desktop\\filesTestFolder\\resource folder for test ";
	private static final String destination = "C:\\Users\\a.dzhambazov\\Desktop\\filesTestFolder\\folder1";
	private static final String finalDestination = "C:\\Users\\a.dzhambazov\\Desktop\\filesTestFolder\\folder2";

	
	
	public static void main(String[] args) {

		// Start of test 1 - loading X files into directory 1 and checking if these X
		// files are present in directory 2
		createTest(1);

		// Start of test 2 - loading X files and Y directories into directory 1 and
		// checking if these X files are present in directory 2
		//createTest(2);

		// Start of test 3 - loading Y directories into directory 1 and checking if
		// these X files are present in directory 2
		//createTest(3);

		// printing each test with its result - true if test is successful false if not
		for (Map.Entry<Integer, Boolean> entry : tests.entrySet()) {
			System.out.println("Test N:" + entry.getKey() + " finished as " + entry.getValue());
		}
	}
	
	

	private static void createTest(Integer i) {
		String sourceFolder = sourceFolderForTest + i;

		// moving the files from the resource folder to the testing initial folder
		CopyManager copyManager = new CopyManager(sourceFolder, destination);
		CopyProcessor copyThread = new CopyProcessor(copyManager);

		// creating a map holding all files with their size in order to compare them
		// later
		Map<String, Long> mapOfFilesAndSizeSourceFolder = new HashMap<String, Long>();
		fillMapWithFilesAndSizeOfFiles(mapOfFilesAndSizeSourceFolder, sourceFolder);

		// starting the thread moving the files from the test resource folder to the
		// destination folder
		copyThread.start();

		// sleeping the thread in order to give some time to OS to move the files
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		copyThread.shutdown();

		// filling a map with all the files present in the finalFolder
		Map<String, Long> mapOfFilesAndSizeDestinationFolder = new HashMap<String, Long>();
		fillMapWithFilesAndSizeOfFiles(mapOfFilesAndSizeDestinationFolder, finalDestination);

		// filling our resultMap with the number of the test and its true or false
		// result
		boolean result = checkIfTestCompleted(mapOfFilesAndSizeSourceFolder, mapOfFilesAndSizeDestinationFolder);
		tests.put(i, result);
	}

	private static boolean checkIfTestCompleted(Map<String, Long> mapOfFilesAndSizeSourceFolder,
			Map<String, Long> mapOfFilesAndSizeDestinationFolder) {

		int mapCounter = mapOfFilesAndSizeSourceFolder.size();
		int tempCounter = 0;
		for (Map.Entry<String, Long> entry : mapOfFilesAndSizeSourceFolder.entrySet()) {
			String currentSourceFileName = entry.getKey();
			if (!mapOfFilesAndSizeDestinationFolder.containsKey(currentSourceFileName)) {

				return false;
			}
			if (!entry.getValue().equals(mapOfFilesAndSizeDestinationFolder.get(currentSourceFileName))) {
				return false;
			}
			tempCounter++;			
		}
		if (mapCounter == tempCounter) {
			return true;
		}
		return false;
	}

	private static void fillMapWithFilesAndSizeOfFiles(Map<String, Long> mapOfFilesAndSizeSourceFolder,
			String destination) {

		File source = new File(destination);
		for (File file : source.listFiles()) {
			if (!file.isDirectory()) {
				mapOfFilesAndSizeSourceFolder.put(file.getName(), file.length());
			}
		}
	}
}
