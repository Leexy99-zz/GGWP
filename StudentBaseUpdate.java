import java.sql.*;    
import javax.swing.JOptionPane;

public class StudentBaseUpdate
{
	@SuppressWarnings("deprecation")
	public static void StudentDataUpdate ()
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
			
			String mysql = "UPDATE studentdatabase SET Student_FullName = ?, Student_Password = ?, Student_PhoneNumber = ?, Student_EmailAddress = ?, Student_City = ?, Student_Country = ?, Student_Description = ? "
					+ "WHERE Student_Fullname = ? ";    		
			String FullName = JOptionPane.showInputDialog("Please enter your Full Name.");
			String Password = JOptionPane.showInputDialog("Please enter your New Password.");
			String PhoneNumber = JOptionPane.showInputDialog("Please enter your New Phone Number.");
			String EmailAddress = JOptionPane.showInputDialog("Please enter your New Email Address.");
			String City = JOptionPane.showInputDialog("Please enter your current City you living.");
			String Country = JOptionPane.showInputDialog("Please enter your current Country you living.");
			String Description = JOptionPane.showInputDialog("Please enter your New Description.");
			
			PreparedStatement pat = conn.prepareStatement(mysql);
			pat.setString(1, FullName);
			pat.setString(2, Password);		
			pat.setString(3, PhoneNumber);
			pat.setString(4, EmailAddress);   						
			pat.setString(5, City);
			pat.setString(6, Country); 			   		
			pat.setString(7, Description);
			pat.setString(8, FullName);
			
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