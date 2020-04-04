import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import com.mysql.jdbc.*;

public class StudentLogin
{
	@SuppressWarnings("deprecation")
	public static void StudentLog () 
	{
		Connection conn = null;
		try	    
		{		
			Class.forName ("com.mysql.jdbc.Driver").newInstance();			
			String userName = "root";			
			String password = "Lee@990207";  			
			String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";        
			conn = (Connection) DriverManager.getConnection (url, userName, password);	    
			System.out.println ("\nDatabase Connection Established...");
	      
		}		
		catch (Exception ex)    
		{    
			System.err.println ("Cannot connect to database server");	      	
			ex.printStackTrace();
		}
		finally     		
		{       		
			if (conn != null)
			{
				try
				{
					String sql = "select email from users where email = ?";
					PreparedStatement stat = conn.prepareStatement(sql);
					stat.setString(1, "EmailAddress");
					ResultSet rs = (ResultSet) stat.executeQuery();
					JOptionPane.showInputDialog("Please enter your username.");
					JOptionPane.showInputDialog("Please enter your password.");
					
					if (rs.next())
					{
						System.out.println("Row with email found");
					}
					else
					{
						System.out.println("Email Address is missing.");
					}
				}
				catch (Exception ex)
	      		 {
	      			 System.out.println ("Error in connection termination!");					
	      		 }
			}
		}
	}
}
