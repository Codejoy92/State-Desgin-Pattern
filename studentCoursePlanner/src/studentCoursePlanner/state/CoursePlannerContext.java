package studentCoursePlanner.state;

import java.util.ArrayList;

import studentCoursePlanner.util.Results;
import studentCoursePlanner.util.StateMachineUtility;

public class CoursePlannerContext {
	
	CoursePlannerStateI noCourse, oneCourse, twoCourse, extraCourse, exitCourse, currentCore1State, currentCore2State,
			currentCore3State, currentCore4State, currentElectiveState, currentDegreeState;
	CoursePlannerStateI ongoingDegree, completedDegree, neverGraduateDegree;
	Results results;
	int countCourse;
	ArrayList<String> servedList = new ArrayList<String>();
	
	public ArrayList<String> getServedList() {
		return servedList;
	}

	public void setServedList(ArrayList<String> servedList) {
		this.servedList = servedList;
	}

	public  void InitiliazeCoursePlanner() {
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
		results = new Results();
		
	}
	
	public void trackProgress(String CourseInput, StateMachineUtility utilityIn) {
		
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

		servedList.add(CourseInput);
		
		if ((currentCore1State == twoCourse || currentCore1State == extraCourse)
				&& (currentCore2State == twoCourse || currentCore2State == extraCourse)
				&& (currentCore3State == twoCourse || currentCore3State == extraCourse)
				&& (currentCore4State == twoCourse || currentCore4State == extraCourse)
				&& (currentElectiveState == twoCourse || currentElectiveState == extraCourse)
				&& countCourse >= 10) {
			currentDegreeState.Degree("graduated", utilityIn);
			currentDegreeState.Degree("", utilityIn);
		}
		if(currentCore1State == exitCourse || currentCore2State == exitCourse || currentCore3State == exitCourse || currentCore4State == exitCourse) {
			currentDegreeState.Degree("NeverGraduate", utilityIn);
			currentDegreeState.Degree("", utilityIn);
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
