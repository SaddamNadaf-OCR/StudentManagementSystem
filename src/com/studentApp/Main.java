package com.studentApp;

public class Main {

	public static void main(String[] args) {
		System.out.println("*********** Student Management System ***********");
		System.out.println("************* Welcome ************");
		
		Student s1;
		s1 = new Student("Kajal Devgan", 20, "S-31");
		s1.enrollCourses("Java");
		s1.enrollCourses("JavaScripts");
		s1.enrollCourses("Java");
		s1.enrollCourses("C#");
		s1.printStudentInfo();
		
		Student s2 = new Student("Ronaldo", 25, "S-45");
		s2.enrollCourses("DSA");
		s2.printStudentInfo();
		
		Student s3 = new Student("Messi", 35, "S-35");
		s3.enrollCourses("DevOps");
		s3.printStudentInfo();
	}

}
