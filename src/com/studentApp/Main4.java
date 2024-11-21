package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Main4 {

	private static List<Student> StudentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*********** Student Management System ***********");

		StudentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("************* Welcome ************");
			System.out.println("Please Select Option.......");
			System.out.println("1. Register a Student");
			System.out.println("2. Find Student with Student ID");
			System.out.println("3. List All Student Information");
			System.out.println("4. List Student Onformation in Sorted Order");
			System.out.println("5. Exit");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				enrollstudent(scanner);
				break;
			case 2:
				findStudentByID(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid option Selected.....Enter In Between 1 to 5");
			}
		}
	}

	private static void exit() {
		System.exit(0);
	}

	private static void printAllStudentData() {
		if (StudentList.size() > 0) {
			System.out.println("================= Print All Student Data =================");
			for (Student student : StudentList) {
				student.printStudentInfo();
			}
			System.out.println("===========================================================");
		} else {
			System.err.println("Student List is Empty..!! No Student Record Found....!!");
		}
	}

	private static void findStudentByID(Scanner scanner2) {
		Student studentFound = null;
		System.out.println("Enter the Student ID..");
		String studentID = scanner2.next();
		try {
			studentFound = StudentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(studentID)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found :"));

		} catch (Exception e) {
			System.err.println("Student with ID " + studentID + " not found");
		}
		studentFound.printStudentInfo();
	}

	private static void enrollstudent(Scanner scanner2) {
		System.out.println("Enter Student Name :");
		String StudentName = scanner2.next();

		System.out.println("Enter Student Age :");
		int StudentAge = scanner2.nextInt();

		System.out.println("Enter Student ID :");
		String StudentID = scanner2.next();

		Student newstudent = new Student(StudentName, StudentAge, StudentID);
		StudentList.add(newstudent);
		// System.out.println("Student Added Successfully ......!!!!");

		while (true) {
			System.out.println("Enter the Course to be Enrolled....!! Type Done to Exit");

			String CourseName = scanner2.next();
			if (CourseName.equalsIgnoreCase("Done")) {
				break;
			}
			newstudent.enrollCourses(CourseName);
		}
		newstudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		/*
		 * new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { // we can use both one
		 * above and commented sections also method stub return
		 * o1.getName().compareTo(o2.getName()); } };
		 */
		Collections.sort(StudentList, studentNameComparator);
		printAllStudentData();
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
