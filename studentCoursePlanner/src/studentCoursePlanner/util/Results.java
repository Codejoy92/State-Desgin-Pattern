package studentCoursePlanner.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Results implements FileDisplayInterface {

	StateMachineUtility utility;
	ArrayList<String> storeResult = new ArrayList<String>();
	int bnumber;
	
	Hashtable<Integer, ArrayList<String>> finalResult = new Hashtable<Integer, ArrayList<String>>();
	@Override
	public void writeResult(String outputFile ) {
		BufferedWriter out;
		
		
		try {
			out = new BufferedWriter(new FileWriter(outputFile));
			
			List<Integer> bnumbers = new ArrayList<Integer>(finalResult.keySet());
			for(int studentId : bnumbers) {
				StringBuffer result = new StringBuffer();
				result.append(studentId);
				result.append(": ");
				
				List<String> coursePref = finalResult.get(studentId);
				for (String output : coursePref) {
					result.append(output);
					result.append(" ");
				}
				
				utility = new StateMachineUtility();
				float listSize = coursePref.size();
				int totalSem = utility.calculateSem(listSize);
				result.append(" :: ");
				result.append("Total number of sem:");
				result.append(totalSem);
				
				out.write(result.toString());
				out.newLine();
				
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("output file does not exisits");
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.out.println("error while writing into file");
			System.exit(1);
		}
		
	}

	public ArrayList<String> getStoreResult() {
		return storeResult;
	}

	public void setStoreResult(ArrayList<String> storeResult) {
		this.storeResult = storeResult;
	}

}
