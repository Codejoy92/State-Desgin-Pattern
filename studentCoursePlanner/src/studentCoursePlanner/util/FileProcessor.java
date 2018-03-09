package studentCoursePlanner.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileProcessor {

	BufferedReader bufferedReader = null;
	FileReader fileReader = null;
	
	/**
	 * This function is used to read contents of file line by line
	 * 
	 */
	
	public void fileCheck(String inputFile) {
		try {
			fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		}
		
	}
	public String readLine() {
		String entry = null;
		try {
			entry = bufferedReader.readLine();
			if(null == entry)
				return null;
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		return entry;
		
	}
	
}
