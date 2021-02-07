package studentManagement.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NavHome implements ActionListener{
	JFrame jframe;
	
	public NavHome(Object obj) {
		jframe = (JFrame)obj;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jframe.setVisible(false);
		new HomePage().showHomePage();
		
	}

}
