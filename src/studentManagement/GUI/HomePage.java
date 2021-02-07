package studentManagement.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class HomePageActionListener implements ActionListener{
	JButton btnInsertStudent,
	btnDeleteStudent,
	btnUpdateStudent,
	btnInsertCourse, 
	btnDeleteCourse,
	btnUpdateCourse,
	btnViewListOfCourses, 
	btnViewListOfStudents,
	btnExit;
	InsertCourse insertCourse = new InsertCourse();
	DeleteCourse deleteCourse = new DeleteCourse();
	DeleteStudent deleteStudent = new DeleteStudent();
	UpdateStudent updateStudent = new UpdateStudent();
	InsertStudent insertStudent = new InsertStudent();
	ListCourse listCourse = new ListCourse();
	UpdateCourse updateCourse = new UpdateCourse();
	StudentCourse studentCourse = new StudentCourse();
	HomePage hp = new HomePage();
	public HomePageActionListener(HomePage hp) {
		this.hp = hp;
		btnInsertStudent = hp.btnInsertStudent;
		btnDeleteStudent = hp.btnDeleteStudent;
		btnUpdateStudent = hp.btnUpdateStudent;
		btnInsertCourse = hp.btnInsertCourse;
		btnDeleteCourse = hp.btnDeleteCourse;
		btnUpdateCourse = hp.btnUpdateCourse;
		btnViewListOfCourses = hp.btnViewListOfCourses;
		btnViewListOfStudents = hp.btnViewListOfStudents;
		btnExit = hp.btnExit;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInsertStudent) {
			insertStudent.showForm();
			insertStudent.setVisible(true);
			hp.setVisible(false);
		}
		if(e.getSource() == btnDeleteStudent) {
			deleteStudent.showForm();
			deleteStudent.setVisible(true);
			hp.setVisible(false);
		}
		if(e.getSource() == btnInsertCourse) {
			insertCourse.setVisible(true);
			insertCourse.showForm();
			hp.setVisible(false);
		}
		if(e.getSource() == btnDeleteCourse) {
			deleteCourse.setVisible(true);
			deleteCourse.showForm();
			hp.setVisible(false);
		}
		if(e.getSource() == btnUpdateStudent) {

			updateStudent.setVisible(true);
			updateStudent.showForm();
			hp.setVisible(false);
		}
		if(e.getSource() == btnUpdateCourse) {
			updateCourse.setVisible(true);
			updateCourse.showForm();
			hp.setVisible(false);
		}
		if(e.getSource() == btnViewListOfCourses) {
			listCourse.setVisible(true);
			listCourse.showTableData();
			hp.setVisible(false);
		}
		if(e.getSource() == btnViewListOfStudents) {
			studentCourse.setVisible(true);
			studentCourse.showTableData();
			hp.setVisible(false);
		}
		if(e.getSource() == btnExit) {
			insertCourse.setVisible(false);
			insertStudent.setVisible(false);
			listCourse.setVisible(false);
			studentCourse.setVisible(false);
			hp.setVisible(false);
			System.exit(0);
		}
		
	}
	
}

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton btnInsertStudent, 
	btnDeleteStudent,
	btnUpdateStudent,
	btnInsertCourse,
	btnDeleteCourse,
	btnUpdateCourse,
	btnViewListOfCourses, 
	btnViewListOfStudents, btnExit;
	
	
	public HomePage() {
		btnInsertStudent = new JButton("Insert Student");
		btnInsertStudent.setBounds(10, 20, 150, 40);
		
		btnInsertCourse = new JButton("Insert Course");
		btnInsertCourse.setBounds(200, 20, 150, 40);
		
		btnViewListOfCourses = new JButton("View Courses");
		btnViewListOfCourses.setBounds(10, 90, 150, 40);
		
		btnViewListOfStudents = new JButton("View Students");
		btnViewListOfStudents.setBounds(200, 90, 150, 40);
		
		btnDeleteStudent = new JButton("Delete Students");
		btnDeleteStudent.setBounds(10, 150, 150, 40);
		
		btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setBounds(200, 150, 150, 40);
		
		btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.setBounds(10, 200, 150, 40);
		
		btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.setBounds(200, 200, 150, 40);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(110, 250, 150, 40);
	}
	public void showHomePage() {
		add(btnInsertStudent);
		add(btnDeleteStudent);
		add(btnUpdateStudent);
		add(btnInsertCourse);
		add(btnUpdateCourse);
		add(btnDeleteCourse);
		add(btnViewListOfCourses);
		add(btnViewListOfStudents);
		add(btnExit);
		setLayout(null);		
		setVisible(true);
		setSize(400, 400);
		btnInsertStudent.addActionListener(new HomePageActionListener(this));
		btnDeleteStudent.addActionListener(new HomePageActionListener(this));
		btnUpdateStudent.addActionListener(new HomePageActionListener(this));
		btnInsertCourse.addActionListener(new HomePageActionListener(this));
		btnUpdateCourse.addActionListener(new HomePageActionListener(this));
		btnDeleteCourse.addActionListener(new HomePageActionListener(this));
		btnViewListOfCourses.addActionListener(new HomePageActionListener(this));
		btnViewListOfStudents.addActionListener(new HomePageActionListener(this));
		btnExit.addActionListener(new HomePageActionListener(this));
	}
	
//	btnInsert.addActionListener(new StudentActionListener(this));
}
