package studentManagement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import studentManagement.dao.CourseDao;
import studentManagement.data.DBConnection;
import studentManagement.data.StudentsDetails;
import studentManagement.dto.Course;
import studentManagement.dto.Student;
import studentManagement.daoImpl.StudentDaoImpl;

public class CourseDaoImpl implements CourseDao	 {
	StudentsDetails studentsDetails;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	
	public CourseDaoImpl() {
		studentsDetails = StudentsDetails.getObj();
		try {
			con = DBConnection.getConnection();	
		} catch (Exception e) {
			System.out.println("Connection Catch Message While Connecting from CourseDaoImpl: " + e.getMessage());
		}
	}
	@Override
	public Boolean checkIfExists(Integer course_id) {

		try {
			pstmt = con.prepareStatement("select * from courses where course_id = ?");
			pstmt.setInt(1, course_id);
			rs = pstmt.executeQuery();
			if(rs.last()) {
				return true;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from CourseDaoImpl: " + e.getMessage());
		}
		return false;
	}
	@Override
	public Boolean add_course(Course course) {
		
		Integer course_id = course.getCourse_id();
		
		if(checkIfExists(course_id)) {
			return false;
		}
			
		String course_name = course.getCourse_name();
		Double course_fee = course.getCourse_fee();
		
		try {
			pstmt = con.prepareStatement("insert into courses values (?,?,?)");
			pstmt.setInt(1, course_id);
			pstmt.setString(2, course_name);
			pstmt.setDouble(3, course_fee);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Executing Statement from CourseDaoImpl: " + e.getMessage());
		}

		return false;
	}

	@Override
	public Boolean update_course(Course course) {
		
		try {
			pstmt = con.prepareStatement("update courses set course_name = ?, course_fee = ? where course_id = ?");
			pstmt.setString(1, course.getCourse_name());
			pstmt.setDouble(2, Double.valueOf(course.getCourse_fee()));
			pstmt.setInt(3, course.getCourse_id());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Connection Catch Message Updating Course from CourseDaoImpl: " + e.getMessage());
		}
		
		return false;
	}

	@Override
	public Boolean delete_course(Integer course_id) {
		try {
		pstmt = con.prepareStatement("delete from courses where course_id = ?");
		pstmt.setInt(1, course_id);
		pstmt.executeUpdate();
		pstmt.close();
		return true;
		} catch (SQLException e) {
			System.out.println("Error Message While While Delete Statement Execution from CourseDaoImpl: " + e.getMessage());
		} 
		return false;
	}

	@Override
	public int getCourseElementIndex(Integer course_id) {
		for (Course c: studentsDetails.getCourseList()) {
			if(c.getCourse_id().equals(course_id)) {
				return studentsDetails.getCourseList().indexOf(c);
			}
		}
		return -1;
	}

	@Override
	public Course getcourse(Integer course_id) {
		Course course = new Course();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from CourseDaoImpl: " + e.getMessage());
		}
		try {
			rs = stmt.executeQuery("select * from courses where course_id = '"+course_id+"'");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from CourseDaoImpl: " + e.getMessage());
		} 

		try {
			while(rs.next()) {
				course.setCourse_id(rs.getInt(1));
				course.setCourse_name(rs.getString(2));
				course.setCourse_fee(Double.valueOf(rs.getInt(3)));
			  }
			rs.close();
			stmt.close();
			return course;
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating JComboBox from CourseDaoImpl: " + e.getMessage());
		}
		
		return null;
	}
	@Override
	public List<String> getCourses() {
		List<String> Arlist = new ArrayList<>();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from CourseDaoImpl: " + e.getMessage());
		}
		try {
			rs = stmt.executeQuery("select * from courses");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from CourseDaoImpl: " + e.getMessage());
		} 
		int course_id;
		String course_name, name;
		try {
			while(rs.next()) {
				course_id = rs.getInt(1);
				course_name = rs.getString(2);
				name = course_id + " " + course_name;
				Arlist.add(name);
			  }
			rs.close();
			stmt.close();
			return Arlist;
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating JComboBox from CourseDaoImpl: " + e.getMessage());
		}
		
		return null;
	}
	
	public List<Student> getStudents(Integer course_id) 
	{
		List<Student> studentList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement("select * from students where student_course_id = ?");
			pstmt.setInt(1, course_id);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from CourseDaoImpl: " + e.getMessage());
		} 
		try {
			while(rs.next()) {
				studentList.add(new StudentDaoImpl().getStudent(rs.getInt(4)));
			  }
			pstmt.close();
			return studentList;
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating JComboBox from CourseDaoImpl: " + e.getMessage());
		}
		
		return null;
	}

}
