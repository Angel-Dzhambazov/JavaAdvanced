package seeburger.files;

import java.io.File;

public class Tests {

	public static void main(String[] args) {
		File whatDoYouHold = new File("C:\\Users\\a.dzhambazov\\Desktop\\deklaracii");
		System.out.println(whatDoYouHold.isDirectory());
		System.out.println(whatDoYouHold.isFile());
		System.out.println(whatDoYouHold.isHidden());
		System.out.println();
		for (File file : whatDoYouHold.listFiles()) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}
}











