Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt

-----------------------------------------------------------------------

## To create tarball for submission
tar -cvf sujoy_das_assign_2.tar sujoy_das_assign_2/
gzip sujoy_das_assign_2.tar

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

[Date: 03/10/2018]

-----------------------------------------------------------------------

Workflow of state Pattern for this project

State interface:CoursePlannerStateI
Core1(String Course); -[FOR UPDATING STATE OF Long Programming and Design]
Core2(String Course);-[FOR UPDATING STATE OF Data Structures and Algorithms]
Core3(String Course);-[FOR UPDATING STATE OF Hardware Sequence]
Core4(String Course);-[FOR UPDATING STATE OF Data Analytics]
Elective(String Course);-[FOR UPDATING STATE OF Electives]
Degree(String Course, StateMachineUtility utility);-[FOR UPDATING STATE OF Degree]

States with class: 
noCourse(default state for courses),
oneCourse,
twoCourse,
extraCourse,
exitCourse,
ongoingDegree(default state for Degree state),
completedDegree,
neverGraduateDegree

classes above implement CoursePlannerStateI and the methods are called depending on the course type and change the state of that particular course catagory

States reference for current status: 
currentCore1State(Long Programming and Design), 
currentCore2State(Data Structures and Algorithms), 
currentCore3State(Hardware Sequence), 
currentCore4State(Data Analytics), 
currentElectiveState(Electives), 
currentDegreeState;

this references are used to update the state of the catagory types 

RULES FOLLOWED:
1. Course prefernce is given in alphabetical order.
2. Courses taken in a semester should be higher than the course taken in the previous semester.
3. Electives do not have any pre-requisites.
4. Courses in Waitlist are released in Ascending order due to RULE 2.
5. As soon as we get 2 courses from each catagory and total number of courses are more than 10 we stop processing furthur.

IMPACT:
1. Due to rules mentioned above until we get 1st course of a particular catagory later course are added in waitlist.
   As soon as 1st course is found waitlist is searched for the next course in the catagory and then control goes back to sequence provided by the user and so on.
   
EXAMPLE:
input : 2232: P M O F I G N W C D X L K A J E S B U V H
output: 2232: M I N O P W X A J K L E F G S B :: Total no of sem: 6

