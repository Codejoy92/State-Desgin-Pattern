package studentCoursePlanner.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results implements FileDisplayInterface {

	StateMachineUtility utility;
	ArrayList<String> storeResult = new ArrayList<String>();
	
	@Override
	public void writeResult(String outputFile ) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(outputFile));
			for (String output : storeResult) {
				out.write(output);
				out.newLine();
			}
			utility = new StateMachineUtility();
			int totalSem = utility.calculateSem(storeResult.size());
			out.write(totalSem);
			out.newLine();
			
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
