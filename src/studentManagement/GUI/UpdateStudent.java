package studentManagement.GUI;
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
import studentManagement.dto.Course;
import studentManagement.dto.Student;


public class UpdateStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	Integer student_id;
	String student_name;
	Integer student_age;
	

	JLabel label_id, label_name, label_age, label_course, no_courses_available, no_student_available;
	JButton btnUpdateStudent, btnStudentFill, backToHome;
	JTextField field_id, field_name, field_age;
	JComboBox<String> StudentNames, CourseNames;
	
	List<Course> courseList;
	List<String> StudentList, CourseList;
	
	CourseDao courseDao;
	StudentDao studentDao;
	
	public UpdateStudent() {
		
		courseDao = new CourseDaoImpl();
		studentDao = new StudentDaoImpl();
		
		
		label_id = new JLabel("Stundent ID");
		label_id.setBounds(20, 60, 100, 20);
		
		label_name = new JLabel("Student Name");
		label_name.setBounds(20, 90, 100, 20);
		
		label_age = new JLabel("Student Age");
		label_age.setBounds(20, 120, 100, 20);
		
		label_course = new JLabel("Select Course");
		label_course.setBounds(20, 150, 100, 20);
		
		btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.setBounds(100, 200, 170, 40);
		
		btnStudentFill = new JButton("Filter Details");
		btnStudentFill.setBounds(170, 20, 120, 25);
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(120, 250, 120, 40);
		
		field_id = new JTextField();
		field_id.setBounds(120, 60, 100, 20);
		field_id.setEnabled(false);
		field_name = new JTextField();
		field_name.setBounds(120, 90, 100, 20);
		
		field_age = new JTextField();
		field_age.setBounds(120, 120, 100, 20);
		
		no_courses_available = new JLabel("No Courses Availale");
		no_courses_available.setBounds(120, 120, 100, 20);
		
		CourseList = courseDao.getCourses();
		StudentList = studentDao.getStudents();		
	}
	public void showForm() {
		if(CourseList.size()>0){
			CourseNames = new JComboBox<String>(CourseList.toArray(new String[CourseList.size()]));
			CourseNames.setBounds(120, 150, 100, 20);
			add(CourseNames);
		} else {
			btnUpdateStudent.setEnabled(false);	
		}
		if(StudentList.size()>0){
			StudentNames = new JComboBox<String>(StudentList.toArray(new String[StudentList.size()]));
			StudentNames.setBounds(40, 20, 120, 25);
			add(StudentNames);
		} else {
			btnStudentFill.setEnabled(false);
			btnUpdateStudent.setEnabled(false);	
		}
		
		add(label_id);
		add(label_name);
		add(label_age);
		add(label_course);
		add(btnUpdateStudent);
		add(btnStudentFill);
		add(backToHome);
		add(field_id);
		add(field_name);
		add(field_age);
		setLayout(null);		
		setVisible(true);
		setSize(400, 350);
		btnUpdateStudent.addActionListener(new StudentActionListener(this));
		btnStudentFill.addActionListener(new StudentActionListener(this));
		backToHome.addActionListener(new NavHome(this));
	}
	
}
