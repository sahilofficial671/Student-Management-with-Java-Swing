package studentManagement.GUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


import studentManagement.dao.CourseDao;
import studentManagement.dao.StudentDao;
import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.daoImpl.StudentDaoImpl;
import studentManagement.data.DBConnection;

import studentManagement.dto.Course;
import studentManagement.dto.Student;


public class DeleteStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	Integer student_id;
	String student_name;
	Integer student_age;
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	

	JLabel no_student_available, label;
	JButton btnDeleteStudent, backToHome;
	JComboBox<String> StudentsList;
	
	Student stundent;
	StudentDao studentDao;
	Course course;
	List<Course> courseList;
	List<String> Arlist;
	CourseDao courseDao = new CourseDaoImpl();
	
	public DeleteStudent() {

		stundent = new Student();
		studentDao = new StudentDaoImpl();
		
		label = new JLabel("Select Student");
		label.setBounds(20, 20, 100, 40);
		
		btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setBounds(100, 150, 150, 40);
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(115, 200, 120, 40);
		
		
		no_student_available = new JLabel("No Students Availale");
		no_student_available.setBounds(130, 30, 150, 20);
		
		try {
			con = DBConnection.getConnection();	
		} catch (Exception e) {
			System.out.println("Connection Catch Message While Connecting from DeleteStudent: " + e.getMessage());
		}
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from DeleteStudent: " + e.getMessage());
		}
		try {
			rs = stmt.executeQuery("select * from students");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from DeleteStudent: " + e.getMessage());
		} 

		Arlist = new ArrayList<>();
		try {
			while(rs.next()) {
				int student_id = rs.getInt(1);
				String student_name = rs.getString(2);
				String name = student_id + " " + student_name;
				Arlist.add(name);
			  }
		} catch (SQLException e) {
			System.out.println("Catch Message: " + e.getMessage());
		}
		try {
			boolean b = rs.last();
			if(b){
			    StudentsList = new JComboBox<String>(Arlist.toArray(new String[Arlist.size()]));
			    StudentsList.setBounds(130, 30, 100, 20);
				add(StudentsList);
			}else {
				btnDeleteStudent.setEnabled(false);
				add(no_student_available);
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating JComboBox from InsertStudent: " + e.getMessage());
		}
		
	}
	public void showForm() {
		add(label);
		add(btnDeleteStudent);
		add(backToHome);
		setLayout(null);		
		setVisible(true);
		setSize(400, 350);
		btnDeleteStudent.addActionListener(new StudentActionListener(this));
		backToHome.addActionListener(new NavHome(this));
	}
	
}
