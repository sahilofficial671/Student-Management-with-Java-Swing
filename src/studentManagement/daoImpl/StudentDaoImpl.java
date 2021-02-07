package studentManagement.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import studentManagement.dao.StudentDao;
import studentManagement.data.DBConnection;
import studentManagement.data.StudentsDetails;
import studentManagement.dto.Course;
import studentManagement.dto.Student;


public class StudentDaoImpl implements StudentDao{
	StudentsDetails studentsDetails;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;

	public StudentDaoImpl() {
		studentsDetails = StudentsDetails.getObj();

		try {
			con = DBConnection.getConnection();	
		} catch (Exception e) {
			System.out.println("Error Catch Message While Creating Connection from StudentDaoImpl: " + e.getMessage());
		}
	}

	public boolean checkIfExists(Integer student_id) {

		try {
			pstmt = con.prepareStatement("select * from students where student_id = ?");
			pstmt.setInt(1, student_id);
			rs = pstmt.executeQuery();
			if(rs.last()) {
				return true;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating ResultSet from StudentDaoImpl: " + e.getMessage());
		}
		return false;
	}
	@Override
	public Boolean add_student(Student student) {


		Integer student_id = student.getStudent_id();
		if(checkIfExists(student_id)) {
			return false;
		}
		String student_name = student.getStudent_name();
		Integer student_age = student.getStudent_age();
		Integer course_id = student.getStudent_course_id();
		try {
			pstmt = con.prepareStatement("insert into students values (?,?,?,?)");
			pstmt.setInt(1, student_id);
			pstmt.setString(2, student_name);
			pstmt.setInt(3, student_age);
			pstmt.setInt(4, course_id);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("Error while closing connection in StudentDaoIMPL: " + e.getMessage());
			}
		}
		return false;
	}

	@Override
	public Boolean update_student(Student student) {
		try {
			pstmt = con.prepareStatement("update students set student_name = ?, student_age = ? , course_id = ? where student_id = ?");
			pstmt.setString(1, student.getStudent_name());
			pstmt.setInt(2, student.getStudent_age());
			pstmt.setInt(3, student.getStudent_course_id());
			pstmt.setInt(4, student.getStudent_id());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Connection Catch Message Updating Course from CourseDaoImpl: " + e.getMessage());
		}
		
		return false;
	}

	@Override
	public Boolean delete_student(Integer student_id) {
		try {
		pstmt = con.prepareStatement("delete from students where student_id = ?");
		pstmt.setInt(1, student_id);
		pstmt.executeUpdate();
		pstmt.close();
		return true;
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from StudentDaoIMPL: " + e.getMessage());
		} 
		return false;
	}

	@Override
	public Student getStudent(Integer student_id) {
		Student student = new Student();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from StudentDaoIMPL: " + e.getMessage());
		}
		try {
			rs = stmt.executeQuery("select * from students where student_id = '"+student_id+"'");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Executing from getstudent in StudentDaoImpl: " + e.getMessage());
		} 

		try {
			while(rs.next()) {
				student.setStudent_id(rs.getInt(1));
				student.setStudent_name(rs.getString(2));
				student.setStudent_age(Integer.valueOf(rs.getInt(3)));
				student.setStudent_course_id(Integer.valueOf(rs.getInt(4)));
			  }
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Executing from getstudent in StudentDaoImpl: " + e.getMessage());
		}
		
		return student;
	}

	@Override
	public List<String> getStudents() {
		List<String> StudentList = new ArrayList<>();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from StudentDaoIMPL: " + e.getMessage());
		}
		try {
			rs = stmt.executeQuery("select * from students");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from StudentDaoIMPL: " + e.getMessage());
		} 
		int course_id;
		String course_name, name;
		try {
			while(rs.next()) {
				course_id = rs.getInt(1);
				course_name = rs.getString(2);
				name = course_id + " " + course_name;
				StudentList.add(name);
			  }
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating JComboBox from StudentDaoIMPL: " + e.getMessage());
		}
		
		return StudentList;
	}
	@Override
	public String toString() {
		return "StudentDaoImpl [studentsDetails=" + studentsDetails + "]";
	}

}
