package studentCoursePlanner.util;

import java.io.FileReader;
import java.io.BufferedReader;

public class FileProcessor {

	BufferedReader bufferedReader = null;
	FileReader fileReader = null;
	
	/**
	 * This function is used to read contents of file line by line
	 * 
	 */
	public String readLine(String inputFileName) {
		String entry = null;
		try {
			fileReader = new FileReader(inputFileName);
			bufferedReader = new BufferedReader(fileReader);
			entry = bufferedReader.readLine();
			
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		return entry;
		
	}
	
}
