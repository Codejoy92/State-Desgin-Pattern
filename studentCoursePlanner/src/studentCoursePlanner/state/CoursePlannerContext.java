package studentCoursePlanner.state;

import java.util.ArrayList;

import studentCoursePlanner.util.Results;
import studentCoursePlanner.util.StateMachineUtility;

public class CoursePlannerContext {
	
	Results results;
	int countCourse;
	CoursePlannerStateI noCourse, oneCourse, twoCourse, extraCourse, exitCourse;
	CoursePlannerStateI	currentCore1State, currentCore2State, currentCore3State, currentCore4State, currentElectiveState, currentDegreeState;
	CoursePlannerStateI ongoingDegree, completedDegree, neverGraduateDegree;
	ArrayList<String> servedList = new ArrayList<String>();
	
	/**
	 * This method is used to initialize all the variables to its default states
	 * 
	 */
	public  void InitiliazeCoursePlanner() {
		noCourse = new NoCourseState(this);
		oneCourse = new OneCourseState(this);
		twoCourse = new TwoCourseState(this);
		extraCourse = new ExtraCourseState(this);
		exitCourse = new ExitCourseState(this);
		ongoingDegree = new OngoingDegreeState(this);
		completedDegree = new CompletedDegreeState(this);
		neverGraduateDegree = new NeverGraduateDegreeState(this);
		servedList = new ArrayList<String>();
		currentCore1State = noCourse;
		currentCore2State = noCourse;
		currentCore3State = noCourse;
		currentCore4State = noCourse;
		currentElectiveState = noCourse;
		currentDegreeState = ongoingDegree;
		countCourse = 0;
		results = new Results();
		
	}
	
	/**
	 * This method is used to parse all the input courses and change their catagory stages accordingly
	 * @param String CourseInput
	 * @param StateMachineUtility utilityIn
	 * 
	 */
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
			servedList.add(" :: Graduation status: Graduation Completed ");
		}
		if(currentCore1State == exitCourse || currentCore2State == exitCourse || currentCore3State == exitCourse || currentCore4State == exitCourse) {
			currentDegreeState.Degree("NeverGraduate", utilityIn);
			currentDegreeState.Degree("", utilityIn);
			servedList.add(" :: Graduation status: Never Graduate");
		}
	}
	
	/**
	 * This method gets value and return the value
	 * @return noCourse
	 * 
	 */
	public CoursePlannerStateI getNoCourse() {
		return noCourse;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI noCourse
	 * 
	 */
	public void setNoCourse(CoursePlannerStateI noCourse) {
		this.noCourse = noCourse;
	}

	/**
	 * This method gets value and return the value
	 * @return oneCourse
	 */
	public CoursePlannerStateI getOneCourse() {
		return oneCourse;
	}

	/**
	 * This method sets value 
	 * @param CoursePlannerStateI oneCourse
	 * 
	 */
	public void setOneCourse(CoursePlannerStateI oneCourse) {
		this.oneCourse = oneCourse;
	}

	/**
	 * This method gets value and return the value
	 * @return twoCourse
	 */
	public CoursePlannerStateI getTwoCourse() {
		return twoCourse;
	}

	/**
	 * This method sets value 
	 * @param CoursePlannerStateI twoCourse
	 * 
	 */
	public void setTwoCourse(CoursePlannerStateI twoCourse) {
		this.twoCourse = twoCourse;
	}
	/**
	 * This method gets value and return the value
	 * @return extraCourse
	 * 
	 */
	public CoursePlannerStateI getExtraCourse() {
		return extraCourse;
	}

	/**
	 * This method sets value 
	 * @param CoursePlannerStateI extraCourse
	 * 
	 */
	public void setExtraCourse(CoursePlannerStateI extraCourse) {
		this.extraCourse = extraCourse;
	}
	/**
	 * This method gets value and return the value
	 * @return exitCourse
	 * 
	 */
	public CoursePlannerStateI getExitCourse() {
		return exitCourse;
	}

	/**
	 * This method sets value 
	 * @param CoursePlannerStateI exitCourse
	 * 
	 */
	public void setExitCourse(CoursePlannerStateI exitCourse) {
		this.exitCourse = exitCourse;
	}

	/**
	 * This method gets value and return the value
	 * @return ongoingDegree
	 * 
	 */
	public CoursePlannerStateI getOngoingDegree() {
		return ongoingDegree;
	}

	/**
	 * This method sets value 
	 * @param CoursePlannerStateI ongoingDegree
	 * 
	 */
	public void setOngoingDegree(CoursePlannerStateI ongoingDegree) {
		this.ongoingDegree = ongoingDegree;
	}
	/**
	 * This method gets value and return the value
	 * @return completedDegree
	 * 
	 */
	public CoursePlannerStateI getCompletedDegree() {
		return completedDegree;
	}

	/**
	 * This method sets value 
	 * @param CoursePlannerStateI completedDegree
	 * 
	 */
	public void setCompletedDegree(CoursePlannerStateI completedDegree) {
		this.completedDegree = completedDegree;
	}
	/**
	 * This method gets value and return the value
	 * @return neverGraduateDegree
	 * 
	 */
	public CoursePlannerStateI getNeverGraduateDegree() {
		return neverGraduateDegree;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI neverGraduateDegree
	 * 
	 */
	public void setNeverGraduateDegree(CoursePlannerStateI neverGraduateDegree) {
		this.neverGraduateDegree = neverGraduateDegree;
	}
	/**
	 * This method gets value and return the value
	 * @return results
	 * 
	 */
	public Results getResults() {
		return results;
	}
	/**
	 * This method sets value 
	 * @param Results results
	 * 
	 */
	public void setResults(Results results) {
		this.results = results;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI currentCore1State
	 * 
	 */
	public void setCurrentCore1State(CoursePlannerStateI currentCore1State) {
		this.currentCore1State = currentCore1State;
	}
	/**
	 * This method gets value and return the value
	 * @return currentCore2State
	 * 
	 */
	public CoursePlannerStateI getCurrentCore2State() {
		return currentCore2State;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI currentCore2State
	 * 
	 */
	public void setCurrentCore2State(CoursePlannerStateI currentCore2State) {
		this.currentCore2State = currentCore2State;
	}
	/**
	 * This method gets value and return the value
	 * @return currentCore3State
	 * 
	 */
	public CoursePlannerStateI getCurrentCore3State() {
		return currentCore3State;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI currentCore3State
	 * 
	 */
	public void setCurrentCore3State(CoursePlannerStateI currentCore3State) {
		this.currentCore3State = currentCore3State;
	}
	/**
	 * This method gets value and return the value
	 * @return currentCore4State
	 * 
	 */
	public CoursePlannerStateI getCurrentCore4State() {
		return currentCore4State;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI currentCore4State
	 * 
	 */
	public void setCurrentCore4State(CoursePlannerStateI currentCore4State) {
		this.currentCore4State = currentCore4State;
	}
	/**
	 * This method gets value and return the value
	 * @return currentDegreeState
	 * 
	 */
	public CoursePlannerStateI getCurrentDegreeState() {
		return currentDegreeState;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI currentDegreeState
	 * 
	 */
	public void setCurrentDegreeState(CoursePlannerStateI currentDegreeState) {
		this.currentDegreeState = currentDegreeState;
	}
	/**
	 * This method gets value and return the value
	 * @return currentElectiveState
	 * 
	 */
	public CoursePlannerStateI getCurrentElectiveState() {
		return currentElectiveState;
	}
	/**
	 * This method sets value 
	 * @param CoursePlannerStateI currentElectiveState
	 * 
	 */
	public void setCurrentElectiveState(CoursePlannerStateI currentElectiveState) {
		this.currentElectiveState = currentElectiveState;
	}
	/**
	 * This method gets value and return the value
	 * @return servedList
	 * 
	 */
	public ArrayList<String> getServedList() {
		return servedList;
	}
	/**
	 * This method sets value 
	 * @param ArrayList<String> servedList
	 * 
	 */
	public void setServedList(ArrayList<String> servedList) {
		this.servedList = servedList;
	}
	
	
}
