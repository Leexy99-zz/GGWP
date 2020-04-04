import java.sql.*;
import javax.swing.*;

public class DeleteData 
{
	@SuppressWarnings("deprecation")
	public static void StudentDelete() 
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
			
			String mysql = "DELETE FROM studentdatabase WHERE Student_FullName = ?";
			PreparedStatement pat = conn.prepareStatement(mysql);
			
			String FullName = JOptionPane.showInputDialog("Please enter the Student Full Name that you wish to delete.");
			pat.setString(1, FullName);
			
			int DataDeleted = pat.executeUpdate();
			if (DataDeleted > 0)
			{
				System.out.println("Data deleted.");
			}
			pat.close();
		}	
		catch(Exception e)
		{  	
			e.printStackTrace();
		}
	}

}
