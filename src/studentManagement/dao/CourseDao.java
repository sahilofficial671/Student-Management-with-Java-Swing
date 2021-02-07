package studentManagement.dao;

import studentManagement.dto.Student;

import java.util.List;

import studentManagement.dto.Course;

public interface CourseDao {
	Boolean add_course(Course course);
	Boolean update_course(Course course);
	Boolean delete_course(Integer course_id);
	Boolean checkIfExists(Integer course_id);
	Course getcourse(Integer course_id);
	int getCourseElementIndex(Integer course_id);
	List<String> getCourses();
}
