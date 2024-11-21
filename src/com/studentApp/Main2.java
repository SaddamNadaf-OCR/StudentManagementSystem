package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Main2 {

	private static List<Student> StudentList;

	public static void main(String[] args) {
		System.out.println("*********** Student Management System ***********");
		System.out.println("************* Welcome ************");

		StudentList = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Kajal Devgan", 20, "S-31");
		s1.enrollCourses("Java");
		s1.enrollCourses("JavaScripts");
		s1.enrollCourses("C#");

		Student s2 = new Student("Ronaldo", 25, "S-45");
		s2.enrollCourses("DSA");

		Student s3 = new Student("Messi", 35, "S-35");
		s3.enrollCourses("DevOps");

		StudentList.add(s1);
		StudentList.add(s2);
		StudentList.add(s3);

		Student result = findStudentByID("S-31");
		System.out.println("Result " + result);
		sortByName();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		/*
		 * new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { // we can use both one above and commented sections also
		 * method stub return o1.getName().compareTo(o2.getName()); } };
		 */
		Collections.sort(StudentList, studentNameComparator);
		System.out.println(StudentList);
	}

	public static Student findStudentByID(String studentId) {
		Student result = null;
		try {
			result = StudentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found :"));

		} catch (Exception e) {
			System.err.println("Student with ID " + studentId + " not found");
		}
		return result;
	}

}
