package studentCoursePlanner.state;

public class TwoCourseState implements CoursePlannerStateI {

	
	CoursePlannerContext context;
	
	public TwoCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	@Override
	public void Core1(String Course) {
		context.setCurrentCore1State(context.getExtraCourse());
		int course = context.getCore1Status();
		context.setCore1Status(course++);
	}

	@Override
	public void Core2(String Course) {
		context.setCurrentCore2State(context.getExtraCourse());
		int course = context.getCore2Status();
		context.setCore2Status(course++);
	}

	@Override
	public void Core3(String Course) {
		context.setCurrentCore3State(context.getExtraCourse());
		int course = context.getCore3Status();
		context.setCore3Status(course++);
	}

	@Override
	public void Core4(String Course) {
		context.setCurrentCore4State(context.getExtraCourse());
		int course = context.getCore4Status();
		context.setCore4Status(course++);
	}

	@Override
	public void Elective(String Course) {
		context.setCurrentElectiveState(context.getExtraCourse());
		int course = context.getElectiveCount();
		context.setElectiveCount(course++);
	}

	@Override
	public void Degree(String Course) {
		// TODO Auto-generated method stub
		
	}
	
}
