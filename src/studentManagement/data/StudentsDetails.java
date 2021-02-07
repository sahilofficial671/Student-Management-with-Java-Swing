package studentManagement.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentManagement.dto.Course;
import studentManagement.dto.Student;

public class StudentsDetails {
	private static StudentsDetails StudentsDetails = null;
	List<Student> studentList;
	List<Course> courseList;
	StudentsDetails studentsDetails;
	
	
	private StudentsDetails() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
	}
	public static StudentsDetails getObj() {
		if(StudentsDetails != null) {
			return StudentsDetails;
		}
		StudentsDetails = new StudentsDetails();

		return StudentsDetails;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
}