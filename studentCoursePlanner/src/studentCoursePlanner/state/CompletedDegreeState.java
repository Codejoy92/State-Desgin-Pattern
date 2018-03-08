package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;
import studentCoursePlanner.util.StateMachineUtility;

public class CompletedDegreeState implements CoursePlannerStateI {

	Results results;
	CoursePlannerContext context;
	
	public CompletedDegreeState(CoursePlannerContext contextIn) {
		context = contextIn;
	}

	@Override
	public void Core1(String Course) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Core2(String Course) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Core3(String Course) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Core4(String Course) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Elective(String Course) {
		// TODO Auto-generated method stub
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		results = new Results();
		results.setStoreResult(context.getServedList());
		machineUtility.setStopSupply(true);
	}
	
}
