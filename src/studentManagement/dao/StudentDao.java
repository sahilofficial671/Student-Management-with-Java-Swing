package studentManagement.dao;

import java.util.List;

import studentManagement.dto.Student;

public interface StudentDao{
	Boolean add_student(Student student);
	Boolean update_student(Student student);
	Boolean delete_student(Integer student_id);
	Student getStudent(Integer student_id);
	List<String> getStudents();
}
