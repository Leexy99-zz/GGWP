import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class ParentBaseUpdate 
{
	@SuppressWarnings("deprecation")
	public static void ParentDataUpdate ()
	{ 	
		Connection conn = null;
		try
		{
			Class.forName ("com.mysql.jdbc.Driver").newInstance();
			String userName = "root";
			String password = "Lee@990207";       
			String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";        
			conn = DriverManager.getConnection (url, userName, password);
			System.out.println ("\nDatabase Connection Established...");
			
			String mysql = "UPDATE parentdatabase SET Parent_FullName = ?, Parent_Password = ?, Parent_PhoneNumber = ?, Parent_EmailAddress = ?"
					+ "WHERE Parent_Fullname = ? ";    		
			String FullName = JOptionPane.showInputDialog("Please enter your Full Name.");
			String Password = JOptionPane.showInputDialog("Please enter your New Password.");
			String PhoneNumber = JOptionPane.showInputDialog("Please enter your New Phone Number.");
			String EmailAddress = JOptionPane.showInputDialog("Please enter your New Email Address.");
			
			PreparedStatement pat = conn.prepareStatement(mysql);
			pat.setString(1, FullName);
			pat.setString(2, Password);		
			pat.setString(3, PhoneNumber);
			pat.setString(4, EmailAddress);
			pat.setString(5, FullName);
			
			int DataUpdated = pat.executeUpdate();
			if (DataUpdated > 0)
			{
				System.out.println("Data Updated!");
			} 		
			pat.close();
		}
		catch(Exception e)
		{  	
			e.printStackTrace();
		}
	}

}
