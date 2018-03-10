package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class OneCourseState implements CoursePlannerStateI{

	CoursePlannerContext context;
	
	public OneCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	
	@Override
	public void Core1(String Course) {
		context.setCurrentCore1State(context.getTwoCourse());
	}

	@Override
	public void Core2(String Course) {
		context.setCurrentCore2State(context.getTwoCourse());
	}

	@Override
	public void Core3(String Course) {
		context.setCurrentCore3State(context.getTwoCourse());
	}

	@Override
	public void Core4(String Course) {
		context.setCurrentCore4State(context.getTwoCourse());
	}

	@Override
	public void Elective(String Course) {
		context.setCurrentElectiveState(context.getTwoCourse());
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		System.out.println("Degree In Progress");
		
	}

}
