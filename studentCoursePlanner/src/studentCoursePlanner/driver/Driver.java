package studentCoursePlanner.driver;

import java.io.FileNotFoundException;

import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;
import studentCoursePlanner.util.StateMachineUtility;

public class Driver {

	private static FileProcessor fileProcessor;
	private static StateMachineUtility plannerUtility;
	private static Results results;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		String data ="";
		results = new Results();
		fileProcessor = new FileProcessor();
		plannerUtility = new StateMachineUtility();

		fileProcessor.fileCheck(args);
		String outputFileName = args[1];
		while ((data = fileProcessor.readLine()) != null) {
		plannerUtility.parseCourses(data, results);
		}
		results.writeResult(outputFileName);
	}

}
