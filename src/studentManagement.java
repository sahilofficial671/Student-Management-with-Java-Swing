import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import studentManagement.GUI.HomePage;

import studentManagement.dao.CourseDao;
import studentManagement.dao.StudentDao;
import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.daoImpl.StudentDaoImpl;
import studentManagement.dto.Course;
import studentManagement.dto.Student;

public class studentManagement {

	public static void main(String[] args) {
		new HomePage().showHomePage();
	}
}
