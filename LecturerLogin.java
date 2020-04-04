import javax.swing.*;
import java.awt.event.*;


public class LecturerLogin implements ActionListener
{
	private enum Actions
	{
		UPDATELECTURERDATA, UPDATESTUDENTDATA, UPDATEPARENTDATA, 
		VIEWSTUDENTRESULTS, EDITSTUDENTRESULTS, UPDATENEWS, SENDEMAIL,
		STUDENTREGISTRATION
	}
	
	public static void LecturerLog ()
	{
		LecturerLogin instance = new LecturerLogin();
		
		// Create New Frame for Lecturer
		JFrame frame = new JFrame("Lecturer Edit");
		frame.setTitle("ADMIN LEVEL");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null); // Set the JFrame to the center of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate the OPERATION
		
		// Create UPDATE LECTURER DATA Button
		JButton UPDATELECTURERDATA = new JButton ("UPDATE LECTURER DATA");
		UPDATELECTURERDATA.setActionCommand(Actions.UPDATELECTURERDATA.name());
		UPDATELECTURERDATA.addActionListener(instance);
		
		// Create UPDATE STUDENT DATA Button
		JButton UPDATESTUDENTDATA = new JButton ("UPDATE STUDENT DATA");
		UPDATESTUDENTDATA.setActionCommand(Actions.UPDATESTUDENTDATA.name());		
		UPDATESTUDENTDATA.addActionListener(instance);
		
		// Create UPDATE PARENT DATA Button
		JButton UPDATEPARENTDATA = new JButton ("UPDATE PARENT DATA");
		UPDATEPARENTDATA.setActionCommand(Actions.UPDATEPARENTDATA.name());		
		UPDATEPARENTDATA.addActionListener(instance);
	
		// Create VIEW STUDENT RESULTS Button
		JButton VIEWSTUDENTRESULTS = new JButton ("VIEW STUDENT RESULTS");
		VIEWSTUDENTRESULTS.setActionCommand(Actions.VIEWSTUDENTRESULTS.name());		
		VIEWSTUDENTRESULTS.addActionListener(instance);
		
		// Create EDIT STUDENT RESULTS
		JButton EDITSTUDENTRESULTS = new JButton ("EDIT STUDENT RESULTS.");
		EDITSTUDENTRESULTS.setActionCommand(Actions.EDITSTUDENTRESULTS.name());
		EDITSTUDENTRESULTS.addActionListener(instance);
		
		// Create UPDATE NEWS Button			
		JButton UPDATENEWS = new JButton ("UPDATE NEWS");		
		UPDATENEWS.setActionCommand(Actions.UPDATENEWS.name());				
		UPDATENEWS.addActionListener(instance);
		
		// Create SEND EMAIL Button
		JButton SENDEMAIL = new JButton ("SEND EMAIL");		 
		SENDEMAIL.setActionCommand(Actions.SENDEMAIL.name());				
		SENDEMAIL.addActionListener(instance);
		
		// Create STUDENT REGISTRATION Button
		JButton STUDENTREGISTRATION = new JButton ("STUDENT REGISTRATION");
		STUDENTREGISTRATION.setActionCommand(Actions.STUDENTREGISTRATION.name());
		STUDENTREGISTRATION.addActionListener(instance);
		
		// Create panel
		JPanel panel = new JPanel();
		// Add button into panel
		panel.add(UPDATELECTURERDATA);
		panel.add(UPDATESTUDENTDATA);
		panel.add(UPDATEPARENTDATA);
		panel.add(VIEWSTUDENTRESULTS);
		panel.add(UPDATENEWS);
		panel.add(SENDEMAIL);
		panel.add(STUDENTREGISTRATION);
		
		// Add panel into frame	
		frame.add(panel);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getActionCommand() == Actions.UPDATELECTURERDATA.name())
		{
			LecturerBaseUpdate.LecturerDataUpdate();
		}
		else if (evt.getActionCommand() == Actions.UPDATESTUDENTDATA.name())
		{
			StudentBaseUpdate.StudentDataUpdate();
		}
		else if (evt.getActionCommand() == Actions.UPDATEPARENTDATA.name())
		{
			ParentBaseUpdate.ParentDataUpdate();
		}
		else if (evt.getActionCommand() == Actions.VIEWSTUDENTRESULTS.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.UPDATENEWS.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.EDITSTUDENTRESULTS.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.SENDEMAIL.name())
		{
			
		}
		else if (evt.getActionCommand() == Actions.STUDENTREGISTRATION.name())
		{
			StudentRegistration.StudentRegister();
		}
	}
}
