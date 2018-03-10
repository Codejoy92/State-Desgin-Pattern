package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class ExtraCourseState implements CoursePlannerStateI {

	CoursePlannerContext context;
	
	public ExtraCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	
	@Override
	public void Core1(String Course) {
		System.out.println("More than 2 Courses taken from Long Programming and Design catagory");
	}

	@Override
	public void Core2(String Course) {
		System.out.println("More than 2 Courses taken from Data Structures and Algorithms catagory");
	}

	@Override
	public void Core3(String Course) {
		System.out.println("More than 2 Courses taken from Hardware Sequence catagory");
	}

	@Override
	public void Core4(String Course) {
		System.out.println("More than 2 Courses taken from Data Analytics catagory");
	}

	@Override
	public void Elective(String Course) {
		System.out.println("More than 2 Courses taken from Electives catagory");
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		System.out.println("Degree In Progress");
		
	}
}
