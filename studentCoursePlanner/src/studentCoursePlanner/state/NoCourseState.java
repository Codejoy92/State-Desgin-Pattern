package studentCoursePlanner.state;

import studentCoursePlanner.util.StateMachineUtility;

public class NoCourseState implements CoursePlannerStateI {


	CoursePlannerContext context;
	
	public NoCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	@Override
	public void Core1(String Course) {
		if(!"D".equalsIgnoreCase(Course)) {
			context.setCurrentCore1State(context.getOneCourse());
		}
		else {
			context.setCurrentCore1State(context.getExitCourse());
		}
		
	}

	@Override
	public void Core2(String Course) {
		if(!"H".equalsIgnoreCase(Course)) {
			context.setCurrentCore2State(context.getOneCourse());
		}
		else {
			context.setCurrentCore2State(context.getExitCourse());
		}
		
	}

	@Override
	public void Core3(String Course) {
		if(!"L".equalsIgnoreCase(Course)) {
			context.setCurrentCore3State(context.getOneCourse());
		}
		else {
			context.setCurrentCore3State(context.getExitCourse());
		}
		
	}

	@Override
	public void Core4(String Course) {
		if(!"P".equalsIgnoreCase(Course)) {
			context.setCurrentCore4State(context.getOneCourse());
		}
		else {
			context.setCurrentCore4State(context.getExitCourse());
		}
		
	}

	@Override
	public void Elective(String Course) {
		context.setCurrentElectiveState(context.getOneCourse());
	}

	@Override
	public void Degree(String Course, StateMachineUtility machineUtility) {
		// TODO Auto-generated method stub
		
	}

	
}
