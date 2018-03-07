package studentCoursePlanner.util;

import java.io.File;
import java.util.Scanner;

public class FileProcessor {

	Scanner scan;
	File file;
	
	/**
	 * This function is used to read contents of file line by line
	 * 
	 */
	public String readLine(String inputFileName) {
		String entry = null;
		try {
			file = new File(inputFileName);
			scan = new Scanner(file);
		
			if(scan.hasNextLine()) {
			entry = scan.next();
			if(entry.isEmpty())
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		return entry;
		
	}
	
}
