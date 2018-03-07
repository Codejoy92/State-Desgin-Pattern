package studentCoursePlanner.driver;

import java.io.FileNotFoundException;

import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;
import studentCoursePlanner.util.StateMachineUtility;

public class Driver {

	private static FileProcessor fileProcessor;
	private static StateMachineUtility plannerUtility;
	private static Results result;
	
	public static void main(String[] args) throws FileNotFoundException{
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || null == args) {
			System.err.println("Error: Incorrect number of arguments. Please Pass 2 argumnets.");
			System.exit(0);
		}
		String data ="";
		String inputFileName = args[0];
		fileProcessor = new FileProcessor();
		plannerUtility = new StateMachineUtility();
		result = new Results();
		
		while (null!=data) {
		data = fileProcessor.readLine(inputFileName);
		plannerUtility.parseCourses(data);
//		result.writeResult();
		}
		
		result.writeResult();
	}

}
