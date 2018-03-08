package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class OngoingDegreeState implements CoursePlannerStateI {

	CoursePlannerContext context;
	
	public OngoingDegreeState(CoursePlannerContext contextIn) {
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
		if("graduated".equalsIgnoreCase(Course)) 
			context.setCurrentDegreeState(context.getCompletedDegree());
		
		if("NeverGraduate".equalsIgnoreCase(Course))
			context.setCurrentDegreeState(context.getNeverGraduateDegree());
	}
	
}
