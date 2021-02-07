package studentManagement.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InsertCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel label_id, label_name, label_fee;
	JButton btnInsert, backToHome;
	JTextField field_id, field_name, field_fee;

	public InsertCourse() {

		label_id = new JLabel("Course ID");
		label_id.setBounds(20, 20, 100, 40);
		
		label_name = new JLabel("Course Name");
		label_name.setBounds(20, 50, 100, 40);
		
		label_fee = new JLabel("Course Fee");
		label_fee.setBounds(20, 80, 100, 40);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBounds(100, 130, 100, 40);
		
		backToHome = new JButton("Back to Home");
		backToHome.setBounds(20, 230, 120, 40);
		
		field_id = new JTextField();
		field_id.setBounds(100, 30, 100, 20);
		
		field_name = new JTextField();
		field_name.setBounds(100, 60, 100, 20);
		
		field_fee = new JTextField();
		field_fee.setBounds(100, 90, 100, 20);
		
	}
	public void showForm() {	
		add(label_id);
		add(label_name);
		add(label_fee);
		add(btnInsert);
		add(backToHome);
		add(field_id);
		add(field_name);
		add(field_fee);
		setLayout(null);
		setVisible(true);
		setSize(400, 300);
		btnInsert.addActionListener(new StudentActionListener(this));
		backToHome.addActionListener(new NavHome(this));
	}
	
}
