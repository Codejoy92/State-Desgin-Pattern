package studentCoursePlanner.state;

import studentCoursePlanner.util.Results;

public class CoursePlannerContext {
	
	CoursePlannerStateI noCourse, oneCourse, twoCourse, extraCourse, exitCourse, currentCore1State, currentCore2State,
			currentCore3State, currentCore4State, currentElectiveState, currentDegreeState;
	CoursePlannerStateI ongoingDegree, completedDegree, neverGraduateDegree;
	Results results;
	int countCourse;
	int core1Status;
	int core2Status;
	int core3Status;
	int core4Status;
	int electiveCount;
	
	private  void InitiliazeCoursePlanner() {
		noCourse = new NoCourseState(this);
		oneCourse = new OneCourseState(this);
		twoCourse = new TwoCourseState(this);
		extraCourse = new ExtraCourseState(this);
		exitCourse = new ExitCourseState(this);
		ongoingDegree = new OngoingDegreeState(this);
		completedDegree = new CompletedDegreeState(this);
		neverGraduateDegree = new NeverGraduateDegreeState(this);
		currentCore1State = noCourse;
		currentCore2State = noCourse;
		currentCore3State = noCourse;
		currentCore4State = noCourse;
		currentElectiveState = noCourse;
		currentDegreeState = ongoingDegree;
		
		countCourse = 0;
		core1Status = 0;
		core2Status = 0;
		core3Status = 0;
		core4Status = 0;
		electiveCount = 0;
		results = new Results();
		
	}
	
	public void trackProgress(String CourseInput) {
		
		InitiliazeCoursePlanner();
		countCourse++;
		
		switch(CourseInput){
			case "A":
			case "B":
			case "C":
			case "D":
				currentCore1State.Core1(CourseInput);
				break;
			case "E":
			case "F":
			case "G":
			case "H":
				currentCore2State.Core2(CourseInput);
				break;
			case "I":
			case "J":
			case "K":
			case "L":
				currentCore3State.Core3(CourseInput);
				break;
			case "M":
			case "N":
			case "O":
			case "P":
				currentCore4State.Core4(CourseInput);
				break;
			default:
				currentElectiveState.Elective(CourseInput);
				break;
		}
//		results.addCourseToResult(CourseInput);
		
		if (core1Status >= 2 && core2Status >= 2 && core3Status >= 2 && core4Status >= 2 && countCourse >= 10) {
			currentDegreeState.Degree("graduated");
//			results.addCourseToResult(CourseInput);
		}
		if(core1Status == 5 || core2Status == 5 || core3Status == 5 || core4Status == 5) {
			currentDegreeState.Degree("NeverGraduate");
//			results.addCourseToResult(CourseInput);
		}
	}
	

	public CoursePlannerStateI getNoCourse() {
		return noCourse;
	}

	public void setNoCourse(CoursePlannerStateI noCourse) {
		this.noCourse = noCourse;
	}

	public CoursePlannerStateI getOneCourse() {
		return oneCourse;
	}

	public void setOneCourse(CoursePlannerStateI oneCourse) {
		this.oneCourse = oneCourse;
	}

	public CoursePlannerStateI getTwoCourse() {
		return twoCourse;
	}

	public void setTwoCourse(CoursePlannerStateI twoCourse) {
		this.twoCourse = twoCourse;
	}

	public CoursePlannerStateI getExtraCourse() {
		return extraCourse;
	}

	public void setExtraCourse(CoursePlannerStateI extraCourse) {
		this.extraCourse = extraCourse;
	}

	public CoursePlannerStateI getExitCourse() {
		return exitCourse;
	}

	public void setExitCourse(CoursePlannerStateI exitCourse) {
		this.exitCourse = exitCourse;
	}

	public CoursePlannerStateI getOngoingDegree() {
		return ongoingDegree;
	}

	public void setOngoingDegree(CoursePlannerStateI ongoingDegree) {
		this.ongoingDegree = ongoingDegree;
	}

	public CoursePlannerStateI getCompletedDegree() {
		return completedDegree;
	}

	public void setCompletedDegree(CoursePlannerStateI completedDegree) {
		this.completedDegree = completedDegree;
	}

	public CoursePlannerStateI getNeverGraduateDegree() {
		return neverGraduateDegree;
	}

	public void setNeverGraduateDegree(CoursePlannerStateI neverGraduateDegree) {
		this.neverGraduateDegree = neverGraduateDegree;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public int getCore1Status() {
		return core1Status;
	}

	public void setCore1Status(int core1Status) {
		this.core1Status = core1Status;
	}

	public int getCore2Status() {
		return core2Status;
	}

	public void setCore2Status(int core2Status) {
		this.core2Status = core2Status;
	}

	public int getCore3Status() {
		return core3Status;
	}

	public void setCore3Status(int core3Status) {
		this.core3Status = core3Status;
	}

	public int getCore4Status() {
		return core4Status;
	}

	public void setCore4Status(int core4Status) {
		this.core4Status = core4Status;
	}

	public int getElectiveCount() {
		return electiveCount;
	}

	public void setElectiveCount(int electiveCount) {
		this.electiveCount = electiveCount;
	}

	public CoursePlannerStateI getCurrentCore1State() {
		return currentCore1State;
	}

	public void setCurrentCore1State(CoursePlannerStateI currentCore1State) {
		this.currentCore1State = currentCore1State;
	}

	public CoursePlannerStateI getCurrentCore2State() {
		return currentCore2State;
	}

	public void setCurrentCore2State(CoursePlannerStateI currentCore2State) {
		this.currentCore2State = currentCore2State;
	}

	public CoursePlannerStateI getCurrentCore3State() {
		return currentCore3State;
	}

	public void setCurrentCore3State(CoursePlannerStateI currentCore3State) {
		this.currentCore3State = currentCore3State;
	}

	public CoursePlannerStateI getCurrentCore4State() {
		return currentCore4State;
	}

	public void setCurrentCore4State(CoursePlannerStateI currentCore4State) {
		this.currentCore4State = currentCore4State;
	}

	public CoursePlannerStateI getCurrentDegreeState() {
		return currentDegreeState;
	}

	public void setCurrentDegreeState(CoursePlannerStateI currentDegreeState) {
		this.currentDegreeState = currentDegreeState;
	}

	public CoursePlannerStateI getCurrentElectiveState() {
		return currentElectiveState;
	}

	public void setCurrentElectiveState(CoursePlannerStateI currentElectiveState) {
		this.currentElectiveState = currentElectiveState;
	}
	
	
}
