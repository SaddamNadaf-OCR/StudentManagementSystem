package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main3 {

	private static List<Student> StudentList;

	public static void main(String[] args) {
		System.out.println("*********** Student Management System ***********");
		System.out.println("************* Welcome ************");

		StudentList = new ArrayList<Student>();
		
		//Read Inpur from terminal
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student Name : ");
		String Name = scanner.next();	
		System.out.println("You have Entered The Name = "+Name);
		
		System.out.println("Enter Student Age : ");
		int Age = scanner.nextInt();	
		System.out.println("The Student Age = "+Age);
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
