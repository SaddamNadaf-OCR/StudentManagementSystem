package com.studentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	
	private String name;
	private int age;
	private String studentID;
	private List<String> courses;
	
	
	public Student(String name, int age, String studentID) {
		super();
		if(validateAge(age) && validateName(name) && validateStudentID(studentID)) {
			this.name = name;
			this.age = age;
			this.studentID = studentID;
			courses = new ArrayList<String>();
		}
	} 
	
	private boolean validateStudentID(String studentID) {
		String studentRegex ="S-[0-9]+$";		//"S-\\d+$"
		Pattern studentIDPattern = Pattern.compile(studentRegex);
		Matcher studentIdMatchers = studentIDPattern.matcher(studentID);
		if(studentIdMatchers.matches()) {
			return true;
		}else {
			System.err.println("Invalid Student Id ....Use the Format Eg. S-1234");
		}
		return false;
	}

	public void enrollCourses(String course) {
		if(validateCourseName(course)) {
		if(!courses.contains(course)) {
			courses.add(course);
			System.out.println("Student Enrolled to " +course+ " Successfully ");
		}else {
			System.err.println("Student is already enrolled the course "+course);
		}
	}
	}
	
	public void printStudentInfo() {
		System.out.println("=============== Student Information ===============");
		System.out.println("Student Name :"+name);
		System.out.println("Student Age :"+age);
		System.out.println("Student StudentID :"+studentID);
		System.out.println("Enrolled For :"+courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentID=" + studentID + ", courses=" + courses + "]";
	}
	
	//Validation Methods
	public boolean validateAge (int age) {
		if(age>=19 && age<=35) {
			return true;
		}else {
			System.err.println("Student Age Needs to be Between 19 to 35");
			return false;
		}
	}
	
	//Validate Name
	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if(nameMatcher.matches()) {
			return true;
		}else {
			System.out.println("Invalid Name !!! Please Enter Aplhabets Only");
			return false;
		}
	}
	
	//validate Course Name
	public boolean validateCourseName(String course) {
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;
		}
		else {
			System.err.println("Invalid course Name !!! Please Select Course From the List [Java,DSA,DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return studentID;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	

}
