package studentCoursePlanner.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results implements FileDisplayInterface {

	StateMachineUtility utility;
	ArrayList<String> storeResult = new ArrayList<String>();
	int bnumber;
	
	@Override
	public void writeResult(String outputFile ) {
		BufferedWriter out;
		
		StringBuffer result = new StringBuffer();
		try {
			out = new BufferedWriter(new FileWriter(outputFile));
			result.append(bnumber);
			result.append(": ");
			for (String output : storeResult) {
				result.append(output);
				result.append(" ");
			}
			utility = new StateMachineUtility();
			float listSize = storeResult.size();
			int totalSem = utility.calculateSem(listSize);
			result.append("::");
			result.append("Total number of sem:");
			result.append(totalSem);

			out.write(result.toString());
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

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}


}
