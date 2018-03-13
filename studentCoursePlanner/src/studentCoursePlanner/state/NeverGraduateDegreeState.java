package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;
import studentCoursePlanner.util.StateMachineUtility;

public class NeverGraduateDegreeState implements CoursePlannerStateI{

	Results results;
    CoursePlannerContext context;
	
	public NeverGraduateDegreeState(CoursePlannerContext contextIn) {
		context = contextIn;
	}

	@Override
	public void Core1(String Course) {
	}

	@Override
	public void Core2(String Course) {
	}

	@Override
	public void Core3(String Course) {
	}

	@Override
	public void Core4(String Course) {
	}

	@Override
	public void Elective(String Course) {
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		machineUtility.setStopSupply(true);
	}

}
