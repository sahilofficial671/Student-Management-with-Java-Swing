package studentManagement.GUI;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import studentManagement.dao.CourseDao;
import studentManagement.daoImpl.CourseDaoImpl;


public class DeleteCourse extends JFrame {

	private static final long serialVersionUID = 1;
	
	JLabel no_course_available, label, label2, label3;
	JButton btnDeleteCourse, backToHome;
	JComboBox<String> CoursesList;
	List<String> Arlist;
	
	CourseDao courseDao;
	public DeleteCourse() {
		courseDao = new CourseDaoImpl();
		
		label = new JLabel("Select Course");
		label.setBounds(20, 20, 100, 40);
		
		btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setBounds(100, 150, 150, 40);
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(115, 200, 120, 40);
				
		no_course_available = new JLabel("No Courses Availale");
		no_course_available.setBounds(130, 30, 151, 21);

		Arlist = courseDao.getCourses();	
		
	}
	public void showForm() {
		if(Arlist.size()>0){
			CoursesList = new JComboBox<String>(Arlist.toArray(new String[Arlist.size()]));
			CoursesList.setBounds(130, 30, 100, 20);
			add(CoursesList);
		} else {
			add(no_course_available);
			btnDeleteCourse.setEnabled(false);			
		}	
		add(label);
		add(btnDeleteCourse);
		add(backToHome);
		setLayout(null);		
		setVisible(true);
		setSize(400, 350);
		btnDeleteCourse.addActionListener(new StudentActionListener(this));
		backToHome.addActionListener(new NavHome(this));
	}
}
