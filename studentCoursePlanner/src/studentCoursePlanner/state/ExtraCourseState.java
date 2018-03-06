package studentCoursePlanner.state;

public class ExtraCourseState implements CoursePlannerStateI {

	CoursePlannerContext context;
	
	public ExtraCourseState(CoursePlannerContext contextIn) {
		context = contextIn;
	}
	
	@Override
	public void Core1(String Course) {
		int course = context.getCore1Status();
		context.setCore1Status(course++);
	}

	@Override
	public void Core2(String Course) {
		int course = context.getCore2Status();
		context.setCore2Status(course++);
	}

	@Override
	public void Core3(String Course) {
		int course = context.getCore3Status();
		context.setCore3Status(course++);
	}

	@Override
	public void Core4(String Course) {
		int course = context.getCore4Status();
		context.setCore4Status(course++);
	}

	@Override
	public void Elective(String Course) {
		int course = context.getElectiveCount();
		context.setElectiveCount(course++);
	}

	@Override
	public void Degree(String Course) {
		// TODO Auto-generated method stub
		
	}
}
