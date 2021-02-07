package studentManagement.dto;
import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.daoImpl.StudentDaoImpl;
public class Student {
	Integer student_id;
	String student_name;
	Integer student_age;
	Integer student_course_id;
	public Student() {
		
	}
	public Student(Integer student_id,String studnet_name,Integer student_age,Integer student_course_id) {
		this.student_course_id = student_course_id;
		this.student_age = student_age;
		this.student_id = student_id;
		this.student_name = studnet_name;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getStudent_age() {
		return student_age;
	}
	public void setStudent_age(Integer student_age) {
		this.student_age = student_age;
	}
	public Integer course_selected() {
		return student_course_id;
	}
	public void setStudent_course_id(Integer student_course_id) {
		this.student_course_id = student_course_id;
	}
	
	public Course course() {
		return new CourseDaoImpl().getcourse(this.student_course_id);
	}
	public Boolean delete() 
	{
		return new StudentDaoImpl().delete_student(this.student_id);
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_age=" + student_age
				+ ", student_course_id=" + student_course_id + "]";
	}
	public Integer getStudent_course_id() {
		return student_course_id;
	}
}