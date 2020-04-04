import javax.swing.*;
import java.awt.event.*;

public class ManagementLogin implements ActionListener
{
	private enum Actions
	{
		STUDENTLOGIN, LECTURERLOGIN, PARENTLOGIN, EXIT, ADMINLOGIN
	}
	
	public static void main(String [] args)
	{	
		ManagementLogin instance = new ManagementLogin();
		
		// Create frame
		JFrame frame = new JFrame("UMS Student Management System");
		frame.setTitle("UMS STUDENT MANAGEMENT SYSTEM"); // Set the JFrame Name
		frame.setSize(400, 200); // Set the JFrame Size
		frame.setLocationRelativeTo(null); // Set the JFrame to the center of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate the OPERATION
		
		// Create Student_Login button
		JButton Student_Login = new JButton ("STUDENT LOGIN");
		Student_Login.setActionCommand(Actions.STUDENTLOGIN.name());
		Student_Login.addActionListener(instance);
		
		// Create Lecturer_Login button		
		JButton Lecturer_Login = new JButton ("LECTURER LOGIN");
		Lecturer_Login.setActionCommand(Actions.LECTURERLOGIN.name());
		Lecturer_Login.addActionListener(instance);
	
		// Create Parent Login Button
		JButton Parent_Login = new JButton ("PARENT LOGIN");
		Parent_Login.setActionCommand(Actions.PARENTLOGIN.name());
		Parent_Login.addActionListener(instance);
		
		// Create Exit Button
		JButton Exit = new JButton ("EXIT PROGRAM");
		Exit.setActionCommand(Actions.EXIT.name());
		Exit.addActionListener(instance);
		
		// Create Admin Login Button
		JButton Admin_Login = new JButton ("ADMIN LOGIN");		
		Admin_Login.setActionCommand(Actions.EXIT.name());	
		Admin_Login.addActionListener(instance);
		
		// Create Panel
		JPanel panel = new JPanel();
		// Add button into panel
		panel.add(Student_Login);
		panel.add(Lecturer_Login);
		panel.add(Parent_Login);
		panel.add(Admin_Login);
		panel.add(Exit);
		
		// Add panel into frame
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		
		if (evt.getActionCommand() == Actions.STUDENTLOGIN.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.LECTURERLOGIN.name())
		{
			LecturerLogin.LecturerLog();
		}
		else if (evt.getActionCommand() == Actions.PARENTLOGIN.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.EXIT.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.ADMINLOGIN.name())
		{
			LecturerRegistration.LectRegister();
		}
	}
}
