package studentManagement.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.data.DBConnection;

public class Course {
	Integer course_id;
	String course_name;
	Double course_fee;

	public Course() {
		
	}
	public Course(Integer course_id,String course_name,Double course_fee) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_fee = course_fee;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public Double getCourse_fee() {
		return course_fee;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setCourse_fee(Double course_fee) {
		this.course_fee = course_fee;
	}
	
	public List<Student> students() {
		return new CourseDaoImpl().getStudents(this.course_id);
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_fee=" + course_fee + "]";
	}
	
}
