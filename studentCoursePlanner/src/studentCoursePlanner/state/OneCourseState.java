package studentCoursePlanner.state;

public class OneCourseState implements CoursePlannerStateI{

	CoursePlannerContext context;
	
	public OneCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	
	@Override
	public void Core1(String Course) {
		context.setCurrentCore1State(context.getTwoCourse());
		context.setCore1Status(2);
	}

	@Override
	public void Core2(String Course) {
		context.setCurrentCore2State(context.getTwoCourse());
		context.setCore2Status(2);
	}

	@Override
	public void Core3(String Course) {
		context.setCurrentCore3State(context.getTwoCourse());
		context.setCore3Status(2);
	}

	@Override
	public void Core4(String Course) {
		context.setCurrentCore4State(context.getTwoCourse());
		context.setCore4Status(2);
	}

	@Override
	public void Elective(String Course) {
		context.setCurrentElectiveState(context.getTwoCourse());
		context.setElectiveCount(2);
	}

	@Override
	public void Degree(String Course) {
		// TODO Auto-generated method stub
		
	}

}
