package studentCoursePlanner.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileProcessor {

	BufferedReader bufferedReader = null;
	FileReader fileReader = null;
	
	/**
	 * This function is used to validate arguments passed
	 * @param String[] args
	 * 
	 */
	
	public void fileCheck(String[] args) {
		try {
			if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || null == args) {
				System.err.println("Error: Incorrect number of arguments. Please Pass 2 argumnets.");
				System.exit(0);
			}
			fileReader = new FileReader(args[0]);
			bufferedReader = new BufferedReader(fileReader);
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			System.exit(1);
		}
		
	}
	
	/**
	 * This function is used to read contents of file and return them line by line 
	 * @return entry
	 */
	public String readLine() {
		String entry = null;
		try {
			entry = bufferedReader.readLine();
			if(null == entry)
				return null;
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
		return entry;
		
	}
	
}
