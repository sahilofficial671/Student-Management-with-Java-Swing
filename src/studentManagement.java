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
class Swing{
	JFrame jf;
	JTextField t1;
	JButton b1;
	Swing(){
		jf = new JFrame();
		b1 = new JButton("ADD");	
		t1 = new JTextField();
		b1.setBounds(100, 150, 80, 20);
		t1.setBounds(150, 50, 80, 20);
		jf.add(t1);
		jf.add(b1);
		jf.setSize(300, 300);
		jf.setLayout(null);
		jf.setVisible(true);
	}
}

public class studentManagement {

	public static void main(String[] args) {
//		CourseDao courseDao = new CourseDaoImpl();
//		StudentDao studentDao = new StudentDaoImpl();
//		courseDao.add_course(new Course(101,"C++",5000.0));
//		courseDao.add_course(new Course(102,"C",3000.0));
//		courseDao.add_course(new Course(103,"Course 1",3000.0));
//		courseDao.add_course(new Course(104,"COurse 3",3000.0));
//		courseDao.add_course(new Course(105,"Course 3",3000.0));
//		System.out.println(courseDao.getCourses());
//		StudentDao studentDao = new StudentDaoImpl();
//		studentDao.add_student(new Student(11,"Komal",25,courseDao.getCourses().get(0)));
//		System.out.println(studentDao.getStudents());
//		Course c = courseDao.getcourse(102);
//		c.setCourse_name("Java");
//		courseDao.update_course(c);
//		courseDao.delete_course(102);
//		System.out.println(courseDao.getCourses());
//		new Swing();
//		new ListCourse().showTableData();
//		new StudentCourse().showTableData();
//		new InsertCourse().showForm();
//		new InsertStudent().showForm();
		CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//		;
//		System.out.println(courseDaoImpl.getcourse(1).students());
//		System.out.println(courseDaoImpl.getStudents(1));
//		System.out.println(new courseDaoImpl.getStudent());
		System.out.println(studentDaoImpl.getStudent(2).delete());
		new HomePage().showHomePage();
	}

}
