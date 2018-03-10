package studentCoursePlanner.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import studentCoursePlanner.state.CoursePlannerContext;

public class StateMachineUtility {
	String semester[];
	boolean stopSupply;
	int semesterCount = 0;
	String electives = "QRSTUVZXYW";
	ArrayList<String> semesterList;
	List<String> core1 = new ArrayList<String>();
	List<String> core2 = new ArrayList<String>();
	List<String> core3 = new ArrayList<String>();
	List<String> core4 = new ArrayList<String>();
	ArrayList<String> waitList = new ArrayList<String>();
	CoursePlannerContext plannerContext = new CoursePlannerContext();
	Hashtable<Integer, ArrayList<String>> semesterCourses = new Hashtable<Integer, ArrayList<String>>();

	/**
	 * This method serves as a tool for course allotment considering student's
	 * preferences and saves the ouput in Result class
	 * 
	 * @param String data
	 * @param Results result
	 * 
	 */
	public void parseCourses(String data, Results result) {
		StateMachineUtility utility = new StateMachineUtility();
		semesterList = new ArrayList<String>();
		int bNumber = 0;
		String[] list1 = new String[] { "A", "B", "C", "D" };
		core1.addAll(Arrays.asList(list1));
		String[] list2 = new String[] { "E", "F", "G", "H" };
		core2.addAll(Arrays.asList(list2));
		String[] list3 = new String[] { "I", "J", "K", "L" };
		core3.addAll(Arrays.asList(list3));
		String[] list4 = new String[] { "M", "N", "O", "P" };
		core4.addAll(Arrays.asList(list4));

		if (null != data && (!data.trim().isEmpty())) {
			String[] splitData = data.split(":");

			bNumber = Integer.parseInt(splitData[0]);
			splitData[1].trim();
			String[] course = splitData[1].split(" ");
			int noOfCourses = course.length;

			for (int i = 1; i < noOfCourses; i++) {
				if (!core1.isEmpty() && course[i].equalsIgnoreCase(core1.get(0))) {
					semesterList.add(course[i]);
					core1.remove(0);
					waitListCheck(core1);
				} else if (!core2.isEmpty() && course[i].equalsIgnoreCase(core2.get(0))) {
					semesterList.add(course[i]);
					core2.remove(0);
					waitListCheck(core2);
				} else if (!core3.isEmpty() && course[i].equalsIgnoreCase(core3.get(0))) {
					semesterList.add(course[i]);
					core3.remove(0);
					waitListCheck(core3);
				} else if (!core4.isEmpty() && course[i].equalsIgnoreCase(core4.get(0))) {
					semesterList.add(course[i]);
					core4.remove(0);
					waitListCheck(core4);
				} else if (electives.contains(course[i])) {
					semesterList.add(course[i]);
				} else {
					waitList.add(course[i]);
				}
			}

			Collections.sort(waitList);
			if (!waitList.isEmpty()) {
				for (String var : waitList) {
					semesterList.add(var);
					if (core1.contains(var)) {
						core1.remove(var);
					}
					if (core2.contains(var)) {
						core2.remove(var);
					}
					if (core3.contains(var)) {
						core3.remove(var);
					}
					if (core4.contains(var)) {
						core4.remove(var);
					}
					if (core1.size() <= 2 && core2.size() <= 2 && core3.size() <= 2 && core4.size() <= 2
							&& semesterList.size() >= 10) {
						break;
					}
				}
			}
			plannerContext.InitiliazeCoursePlanner();
			for (String finalList : semesterList) {
				if (!utility.isStopSupply())
					plannerContext.trackProgress(finalList, utility);
			}
		}
		result.finalResult.put(bNumber, plannerContext.getServedList());
	}

	/**
	 * This method is a helper function for parseCourses
	 * This method takes the list and checks index 0 element accross complete waitlist,
	 * if element found it adds that element in the semesterList and removes that element from the waitlist and from the list passed,
	 * so that next element in the list gets index 0 and checked recursively against the waitlist until no match found.
	 * 
	 * @param List<String> core
	 *
	 */
	private void waitListCheck(List<String> core) {
		if (!core.isEmpty() && waitList.contains(core.get(0))) {
			semesterList.add(core.get(0));
			waitList.remove(core.get(0));
			core.remove(0);
			waitListCheck(core);
		}
	}
	
	/**
	 * This method is used to calculate no semester a student have to take to 
	 * complete his graduation.
	 * 
	 * @param float course
	 */
	public int calculateSem(float course) {
		float sem = 0;
		if (course != 0) {
			sem = course / 3;
		}
		int totalSem = (int) Math.ceil(sem);
		return totalSem;
	}

	/**
	 * this is a getter method for stop supply
	 * which returns boolean value
	 * 
	 * @return stopSupply
	 */
	public boolean isStopSupply() {
		return stopSupply;
	}

	/**
	 * this is a setter method which sets stopSupply to boolean value
	 * 
	 * @param stopSupply
	 */
	public void setStopSupply(boolean stopSupply) {
		this.stopSupply = stopSupply;
	}

}
