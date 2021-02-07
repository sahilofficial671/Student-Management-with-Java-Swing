package studentManagement.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import studentManagement.dao.CourseDao;
import studentManagement.dao.StudentDao;
import studentManagement.daoImpl.CourseDaoImpl;
import studentManagement.daoImpl.StudentDaoImpl;
import studentManagement.dto.Course;
import studentManagement.dto.Student;


public class StudentActionListener implements ActionListener {
	InsertStudent insertStudent;
	DeleteStudent deleteStudent;
	UpdateStudent updateStudent;
	InsertCourse insertCourse;
	DeleteCourse deleteCourse;
	UpdateCourse updateCourse;
	JButton btnInsertStudent, 
	btnInsertCourse, btnDeleteStudent,
	btnUpdateStudent, btnStudentFill,
	btnDeleteCourse, btnUpdateCourse, btnCourseFill;
	
	JTextField field_id, field_name, field_fee, field_age;
	
	CourseDao courseDao = new CourseDaoImpl();
	StudentDao studentDao = new StudentDaoImpl();
	
	public StudentActionListener(InsertStudent insertStudent) {
		this.insertStudent = insertStudent;
		this.btnInsertStudent = insertStudent.btnInsert;
	}
	public StudentActionListener(DeleteStudent deleteStudent) {
		this.deleteStudent = deleteStudent;
		this.btnDeleteStudent = deleteStudent.btnDeleteStudent;
	}
	public StudentActionListener(UpdateStudent updateStudent) {
		this.updateStudent = updateStudent;
		this.btnUpdateStudent = updateStudent.btnUpdateStudent;
		this.btnStudentFill = updateStudent.btnStudentFill;
	}
	public StudentActionListener(DeleteCourse deleteCourse) {
		this.deleteCourse = deleteCourse;
		this.btnDeleteCourse = deleteCourse.btnDeleteCourse;
	}
	public StudentActionListener(UpdateCourse updateCourse) {
		this.updateCourse = updateCourse;
		this.btnUpdateCourse = updateCourse.btnUpdateCourse;
		this.btnCourseFill = updateCourse.btnCourseFill;
	}
	public StudentActionListener(InsertCourse insertCourse) {
		this.insertCourse = insertCourse;
		this.btnInsertCourse = insertCourse.btnInsert;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnInsertStudent) {
			
			String course_choice = String.valueOf(insertStudent.CourseNames.getSelectedItem());
			course_choice = course_choice.split(" ")[0];
			System.out.println("Course Choice is: " + course_choice);
			
			Boolean stmt = studentDao.add_student(new Student(
					Integer.valueOf(insertStudent.field_id.getText()),
					insertStudent.field_name.getText(), 
					Integer.valueOf(insertStudent.field_age.getText()),
					Integer.valueOf(course_choice)
					));
		
			if(stmt) {
				System.out.println("Student Added");
			}else {
				System.out.println("Student ID Already Exists");
			}
		}
		if(e.getSource() == btnDeleteStudent) {
			
			String student_selected = String.valueOf(deleteStudent.StudentsList.getSelectedItem());
			student_selected = student_selected.split(" ")[0];
			System.out.println("Student Selected is: " + student_selected);
			
			Boolean result = studentDao.delete_student(Integer.valueOf(student_selected));
			
			System.out.println(result ? "Selected Student Deleted" : "Student Not Deleted");
		}
		if(e.getSource() == btnInsertCourse) {
			Boolean stmt = courseDao.add_course(new Course(
					Integer.valueOf(insertCourse.field_id.getText()),
					insertCourse.field_name.getText(), 
					Double.parseDouble(insertCourse.field_fee.getText())
					));
			if(stmt) {
				System.out.println("Course Added");
			}else {
				System.out.println("Course ID Already Exists");
			}
			
		}
		if(e.getSource() == btnUpdateStudent) {
			
			String course_selected = String.valueOf(updateStudent.CourseNames.getSelectedItem());
			course_selected = course_selected.split(" ")[0];
			
			Student student = new Student(
					Integer.valueOf(updateStudent.field_id.getText()), 
					updateStudent.field_name.getText(), 
					Integer.valueOf(updateStudent.field_age.getText()),
					Integer.valueOf(course_selected)
					);
			Boolean stmt = studentDao.update_student(student);

			if(stmt) {
				System.out.println("Student Updated");
			}else {
				System.out.println("Student Not Udated");
			}
			
		}
			
		if(e.getSource() == btnUpdateCourse) {
			Course course = new Course(
					Integer.valueOf(updateCourse.field_id.getText()), 
					updateCourse.field_name.getText(), 
					Double.valueOf(updateCourse.field_fee.getText())  
					);
			Boolean stmt = courseDao.update_course(course);

			if(stmt) {
				System.out.println("Course Updated");
			}else {
				System.out.println("Course Not Udated");
			}
		}
		if(e.getSource() == btnCourseFill) {
			
			String course_selected = String.valueOf(updateCourse.CoursesList.getSelectedItem());
			course_selected = course_selected.split(" ")[0];
			System.out.println("Course Selected is: " + course_selected);
			
			Course course = courseDao.getcourse(Integer.valueOf(course_selected));			
			updateCourse.field_id.setText(String.valueOf(course.getCourse_id()));
			updateCourse.field_name.setText(course.getCourse_name());
			updateCourse.field_fee.setText(String.valueOf(course.getCourse_fee()));
			
		}
		if(e.getSource() == btnStudentFill) {
			
			String student_selected = String.valueOf(updateStudent.StudentNames.getSelectedItem());
			student_selected = student_selected.split(" ")[0];
			System.out.println("Student Selected is: " + student_selected);
			
			Student student = studentDao.getStudent(Integer.valueOf(student_selected));			
			
			updateStudent.field_id.setText(String.valueOf(student.getStudent_id()));
			updateStudent.field_name.setText(student.getStudent_name());
			updateStudent.field_age.setText(String.valueOf(student.getStudent_age()));
			
			for (int i = 0; i < updateStudent.CourseNames.getItemCount(); i++) {
				String course_selected = String.valueOf(updateStudent.CourseNames.getItemAt(i));
				course_selected = course_selected.split(" ")[0];
				if(student.getStudent_course_id()==Integer.valueOf(course_selected)) {
					updateStudent.CourseNames.setSelectedIndex(i);
				}
			}
			
		}
		if(e.getSource() == btnDeleteCourse) {
			
			String course_selected = String.valueOf(deleteCourse.CoursesList.getSelectedItem());
			course_selected = course_selected.split(" ")[0];
//			System.out.println("Course Selected is: " + course_selected);
			
			Boolean result = courseDao.delete_course(Integer.valueOf(course_selected));
		
			if(result) {
				System.out.println("Course Student Deleted");
			}else {
				System.out.println("Course Not Deleted");
			}
		}
		
	}

}
