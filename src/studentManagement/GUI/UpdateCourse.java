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
import javax.swing.JTextField;

import studentManagement.dao.CourseDao;
import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.data.DBConnection;

public class UpdateCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	JLabel label_id, label_name, label_fee, no_course_available, label1;
	JButton btnUpdateCourse, backToHome, btnCourseFill;
	JTextField field_id, field_name, field_fee;
	JComboBox<String> CoursesList;
	List<String> Arlist;
	CourseDao courseDao;
	
	public UpdateCourse() {
		courseDao = new CourseDaoImpl();
		
		label1 = new JLabel("");
		label1.setBounds(20, 50, 100, 20);
		
		label_id = new JLabel("Course ID");
		label_id.setBounds(20, 60, 100, 20);
		
		label_name = new JLabel("Course Name");
		label_name.setBounds(20, 90, 100, 20);
		
		label_fee = new JLabel("Course Fee");
		label_fee.setBounds(20, 120, 100, 20);
		
		btnCourseFill = new JButton("Filter Details");
		btnCourseFill.setBounds(170, 20, 120, 25);
		
		btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.setBounds(100, 170, 150, 40);
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(20, 230, 120, 40);
		
		field_id = new JTextField();
		field_id.setBounds(100, 60, 100, 20);	
		field_id.setEnabled(false);
		
		field_name = new JTextField();
		field_name.setBounds(100, 90, 100, 20);
		
		field_fee = new JTextField();
		field_fee.setBounds(100, 120, 100, 20);
		
		no_course_available = new JLabel("No Courses Availale");
		no_course_available.setBounds(40, 20, 120, 25);
		
		Arlist = courseDao.getCourses();
	}
	public void showForm() {	
		
		if(Arlist.size()>0){
			CoursesList = new JComboBox<String>(Arlist.toArray(new String[Arlist.size()]));
			CoursesList.setBounds(40, 20, 120, 25);
			add(CoursesList);
		} else {
			btnCourseFill.setEnabled(false);
			btnUpdateCourse.setEnabled(false);
			add(no_course_available);		
		}
		
		add(label_id);
		add(label_name);
		add(label_fee);
		add(btnCourseFill);
		add(btnUpdateCourse);
		add(backToHome);
		add(field_id);
		add(field_name);
		add(field_fee);
		setLayout(null);
		setVisible(true);
		setSize(400, 350);
		btnCourseFill.addActionListener(new StudentActionListener(this));
		btnUpdateCourse.addActionListener(new StudentActionListener(this));
		backToHome.addActionListener(new NavHome(this));
	}
	
}
