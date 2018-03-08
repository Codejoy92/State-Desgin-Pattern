package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class ExtraCourseState implements CoursePlannerStateI {

	CoursePlannerContext context;
	
	public ExtraCourseState(CoursePlannerContext contextIn) {
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
		// TODO Auto-generated method stub
		
	}
}
