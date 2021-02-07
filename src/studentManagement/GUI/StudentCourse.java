package studentManagement.GUI;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import studentManagement.dao.StudentDao;
import studentManagement.daoImpl.StudentDaoImpl;
import studentManagement.data.DBConnection;
import studentManagement.dto.Student;

public class StudentCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	String[] columnNames = { "student_id", "student_name", "student_age", "student_course" };
	JTable table;
	StudentDao studentDao;
	List<Student> studentList;
	JButton backToHome;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public StudentCourse() {
		studentDao = new StudentDaoImpl();
//		studentList = studentDao.getStudents();
		table = new JTable();
	}

	public void showTableData() {
		setTitle("Database Search Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(20, 100, 120, 40);
		backToHome.addActionListener(new NavHome(this));
		add(backToHome);

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columnNames);

		table.setModel(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		try {
			con = DBConnection.getConnection();	
		} catch (Exception e) {
			System.out.println("Connection Catch Message While Connecting from StudentCourse: " + e.getMessage());
		}
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating Statement from StudentCourse: " + e.getMessage());
		} 
		try {
			rs = stmt.executeQuery("select * from students");
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from StudentCourse: " + e.getMessage());
		} 
		
		String  name = ""; 
		Integer id, age, course_id;

		try {
			while(rs.next())  
			{
				id = rs.getInt(1);
				name = rs.getString(2);
				age = rs.getInt(3);
				course_id = rs.getInt(4);
			    model.addRow(new Object[]{id,name,age,course_id});
			}
		} catch (SQLException e) {
			System.out.println("Connection Catch Message While Creating ResultSet from StudentCourse: " + e.getMessage());
		} 

		add(scroll);

		setVisible(true);

		setSize(400, 300);

	}
}