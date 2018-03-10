package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class ExitCourseState implements CoursePlannerStateI{

	CoursePlannerContext context;
	
	public ExitCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}

	@Override
	public void Core1(String Course) {
		System.out.println("Only Course D taken");
	}

	@Override
	public void Core2(String Course) {
		System.out.println("Only Course H taken");
	}

	@Override
	public void Core3(String Course) {
		System.out.println("Only Course L taken");
	}

	@Override
	public void Core4(String Course) {
		System.out.println("Only Course P taken");
	}

	@Override
	public void Elective(String Course) {
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		
	}
}
