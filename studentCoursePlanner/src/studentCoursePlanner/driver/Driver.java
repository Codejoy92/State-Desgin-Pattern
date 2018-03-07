package studentCoursePlanner.driver;

import java.io.FileNotFoundException;

import studentCoursePlanner.state.CoursePlannerContext;
import studentCoursePlanner.util.FileProcessor;
import studentCoursePlanner.util.Results;

public class Driver {

	private static FileProcessor fileProcessor;
	private static CoursePlannerContext CoursePlanner;
	private static Results result;
	
	public static void main(String[] args) throws FileNotFoundException{
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || null == args) {
			System.err.println("Error: Incorrect number of arguments. Please Pass 2 argumnets.");
			System.exit(0);
		}
		String course ="";
		String inputFileName = args[0];
		fileProcessor = new FileProcessor();
		CoursePlanner = new CoursePlannerContext();
		result = new Results();
		
		while (null!=course) {
		course = fileProcessor.readLine(inputFileName);
		CoursePlanner.trackProgress(course);
		}
		
		result.writeResult();
	}

}
