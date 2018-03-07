package studentCoursePlanner.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import studentCoursePlanner.state.CoursePlannerContext;

public class StateMachineUtility {
	String semester[];
	CoursePlannerContext plannerContext = new CoursePlannerContext();
	ArrayList<String> waitList = new ArrayList<String>();
	Hashtable<Integer, ArrayList<String>> semesterCourses = new Hashtable<Integer, ArrayList<String>>();
	int semesterCount = 0;
	String electives = "QRSTUVZXYW";
	List<String> core1 = new ArrayList<String>();
	List<String> core2 = new ArrayList<String>();
	List<String> core3 = new ArrayList<String>();
	List<String> core4 = new ArrayList<String>();

	ArrayList<String> semesterList = new ArrayList<String>();

	public void parseCourses(String data) {
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

			int bNumber = Integer.parseInt(splitData[0]);
			splitData[1].trim();
			String[] course = splitData[1].split(" ");
			int noOfCourses = course.length;

			for (int i = 1; i < noOfCourses; i++) {
				// filling up courses for 1st sem
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
//courses from waitList will be released in Alphabetical order
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
			for (String finalList : semesterList) {
				plannerContext.trackProgress(finalList);
			}

		}

	}

	private void waitListCheck(List<String> core) {
		if (!core.isEmpty() && waitList.contains(core.get(0))) {
			semesterList.add(core.get(0));
			waitList.remove(core.get(0));
			core.remove(0);
			waitListCheck(core);
		}
	}
}
