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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import studentManagement.dao.CourseDao;
import studentManagement.dao.StudentDao;
import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.daoImpl.StudentDaoImpl;
import studentManagement.data.DBConnection;
import studentManagement.dto.Course;
import studentManagement.dto.Student;


public class InsertStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	Integer student_id;
	String student_name;
	Integer student_age;
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	

	JLabel label_id, label_name, label_age, label_course, no_courses_available;
	JButton btnInsert, backToHome;
	JTextField field_id, field_name, field_age;
	JComboBox<String> CourseNames;
	
	List<Course> courseList;
	List<String> Arlist;
	
	public InsertStudent() {
		label_id = new JLabel("Stundent ID");
		label_id.setBounds(20, 20, 100, 40);
		
		label_name = new JLabel("Student Name");
		label_name.setBounds(20, 50, 100, 40);
		
		label_age = new JLabel("Student Age");
		label_age.setBounds(20, 80, 100, 40);
		
		label_course = new JLabel("Select Course");
		label_course.setBounds(20, 110, 100, 40);
		
		btnInsert = new JButton("Insert Student");
		btnInsert.setBounds(100, 170, 100, 40);
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(20, 230, 120, 40);
		
		field_id = new JTextField();
		field_id.setBounds(100, 30, 100, 20);
		
		field_name = new JTextField();
		field_name.setBounds(100, 60, 100, 20);
		
		field_age = new JTextField();
		field_age.setBounds(100, 90, 100, 20);
		
		no_courses_available = new JLabel("No Courses Availale");
		no_courses_available.setBounds(110, 120, 100, 20);
		
		try {
			con = DBConnection.getConnection();	
		} catch (Exception e) {
			System.out.println("Connection Catch Message While Connecting from InsertStudent: " + e.getMessage());
		}
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from InsertStudent: " + e.getMessage());
		} 
		try {
			rs = stmt.executeQuery("select * from courses");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from InsertStudent: " + e.getMessage());
		} 


		Arlist = new ArrayList<>();
		try {
			while(rs.next()) {
				int course_id = rs.getInt(1);
				String course_name = rs.getString(2);
				String name = course_id + " " + course_name;
				Arlist.add(name);
			  }
		} catch (SQLException e) {
			System.out.println("Catch Message: " + e.getMessage());
		}
		try {
			boolean b = rs.last();
			if(b){
				CourseNames = new JComboBox<String>(Arlist.toArray(new String[Arlist.size()]));
				CourseNames.setBounds(100, 120, 100, 20);	
				add(CourseNames);
			}else {
				add(no_courses_available);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error Catch Message While Creating JComboBox from InsertStudent: " + e.getMessage());
		}
		
	}
	public void showForm() {
		add(label_id);
		add(label_name);
		add(label_age);
		add(label_course);
		add(btnInsert);
		add(backToHome);
		add(field_id);
		add(field_name);
		add(field_age);
		setLayout(null);		
		setVisible(true);
		setSize(400, 350);
		btnInsert.addActionListener(new StudentActionListener(this));
		backToHome.addActionListener(new NavHome(this));
	}
	
}
