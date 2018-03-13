package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class TwoCourseState implements CoursePlannerStateI {

	
	CoursePlannerContext context;
	
	public TwoCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	@Override
	public void Core1(String course) {
		context.setCurrentCore1State(context.getExtraCourse());
//		System.out.println("Course Taken from Long Programming and Design: "+ course);
	}

	@Override
	public void Core2(String course) {
		context.setCurrentCore2State(context.getExtraCourse());
//		System.out.println("Course Taken from Data Structures and Algorithms: "+ course);
	}

	@Override
	public void Core3(String course) {
		context.setCurrentCore3State(context.getExtraCourse());
//		System.out.println("Course Taken from Hardware Sequence: "+ course);
	}

	@Override
	public void Core4(String course) {
		context.setCurrentCore4State(context.getExtraCourse());
//		System.out.println("Course Taken from Data Analytics: "+ course);
	}

	@Override
	public void Elective(String course) {
		context.setCurrentElectiveState(context.getExtraCourse());
//		System.out.println("Course Taken from Electives: "+ course);
	}

	@Override
	public void Degree(String course, StateMachineUtility machineUtility) {
		System.out.println("Degree In Progress");
		
	}
	
}
