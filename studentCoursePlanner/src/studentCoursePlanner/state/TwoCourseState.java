package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class TwoCourseState implements CoursePlannerStateI {

	
	CoursePlannerContext context;
	
	public TwoCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	@Override
	public void Core1(String Course) {
		context.setCurrentCore1State(context.getExtraCourse());
	}

	@Override
	public void Core2(String Course) {
		context.setCurrentCore2State(context.getExtraCourse());
	}

	@Override
	public void Core3(String Course) {
		context.setCurrentCore3State(context.getExtraCourse());
	}

	@Override
	public void Core4(String Course) {
		context.setCurrentCore4State(context.getExtraCourse());
	}

	@Override
	public void Elective(String Course) {
		context.setCurrentElectiveState(context.getExtraCourse());
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		// TODO Auto-generated method stub
		
	}
	
}
