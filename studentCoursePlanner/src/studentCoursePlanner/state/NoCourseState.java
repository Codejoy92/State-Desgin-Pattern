package studentCoursePlanner.state;

public class NoCourseState implements CoursePlannerStateI {


	CoursePlannerContext context;
	
	public NoCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	@Override
	public void Core1(String Course) {
		if(!"D".equalsIgnoreCase(Course)) {
			context.setCurrentCore1State(context.getOneCourse());
			context.setCore1Status(1);
		}
		else {
			context.setCurrentCore1State(context.getExitCourse());
			context.setCore1Status(5);
		}
		
	}

	@Override
	public void Core2(String Course) {
		if(!"H".equalsIgnoreCase(Course)) {
			context.setCurrentCore2State(context.getOneCourse());
			context.setCore2Status(1);
		}
		else {
			context.setCurrentCore2State(context.getExitCourse());
			context.setCore2Status(5);
		}
		
	}

	@Override
	public void Core3(String Course) {
		if(!"L".equalsIgnoreCase(Course)) {
			context.setCurrentCore3State(context.getOneCourse());
			context.setCore3Status(1);
		}
		else {
			context.setCurrentCore3State(context.getExitCourse());
			context.setCore3Status(5);
		}
		
	}

	@Override
	public void Core4(String Course) {
		if(!"P".equalsIgnoreCase(Course)) {
			context.setCurrentCore4State(context.getOneCourse());
			context.setCore4Status(1);
		}
		else {
			context.setCurrentCore4State(context.getExitCourse());
			context.setCore4Status(5);
		}
		
	}

	@Override
	public void Elective(String Course) {
		context.setCurrentElectiveState(context.getOneCourse());
		context.setElectiveCount(1);
	}

	@Override
	public void Degree(String Course) {
		// TODO Auto-generated method stub
		
	}

	
}
