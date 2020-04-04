import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class StudentRegistration
{
	@SuppressWarnings("deprecation")
	public static void StudentRegister ()
	  {
       System.out.println("***** MySQL JDBC Connection Testing *****");
       Connection conn = null;
       try
       {
		   Class.forName ("com.mysql.jdbc.Driver").newInstance();
		   String userName = "root";
		   String password = "Lee@990207";       
		   String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";        
	       conn = DriverManager.getConnection (url, userName, password);
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
      			String mysql = "INSERT INTO studentdatabase(Student_UserName, Student_FullName, Student_MatricNumber, Student_Password, Student_PhoneNumber, Student_EmailAddress, Student_City, Student_Country, Student_Description) "
      					+ "values(?,?,?,?,?,?,?,?,?)";
      			String Student_UserName = JOptionPane.showInputDialog("Please enter your username." + "\nThis username will be use for the login.");
      			String Student_FullName = JOptionPane.showInputDialog("Please enter your Full Name.");
      			String Student_MatricNumber = JOptionPane.showInputDialog("Please enter your Matric Number.");
      			String Student_Password = JOptionPane.showInputDialog("Please enter your Password.");
      			String Student_PhoneNumber =  JOptionPane.showInputDialog("Please enter your Phone Number.");
      			String Student_EmailAddress =  JOptionPane.showInputDialog("Please enter your Email Address.");
      			String Student_City =  JOptionPane.showInputDialog("Please enter the current city that you live.");
      			String Student_Country =  JOptionPane.showInputDialog("Please enter the current country that you live.");
      			String Student_Description = JOptionPane.showInputDialog("Describe yourself.");
      			
       	        PreparedStatement pst = conn.prepareStatement(mysql);
				pst.setString(1, Student_UserName);
      			pst.setString(2, Student_FullName);
      			pst.setString(3, Student_MatricNumber);
      			pst.setString(4, Student_Password);
      			pst.setString(5, Student_PhoneNumber);
      			pst.setString(6, Student_EmailAddress);
      			pst.setString(7, Student_City);
      			pst.setString(8, Student_Country);
      			pst.setString(9, Student_Description);
      			
      			int i = pst.executeUpdate(); 
      			if(i != 0)
      			{
      				System.out.println("All data has been added.");
      				
      				// Insert data into Student Results Database
      				try
      				{
      					mysql = "INSERT INTO studentresultsdatabase (Student_FullName, Student_MatricNumber, Student_EmailAddress) + values (?,?,?)";
      					pst.setString(1, Student_UserName);
      					pst.setString(2, Student_MatricNumber);
      					pst.setString(3, Student_EmailAddress);
      				}
      				catch (Exception ex)
      				{
      					 System.err.println ("Student Data could not added into the Student Results Database.");
      			      	 ex.printStackTrace();
      				}
      			}  
      			else
      			{
      		        System.out.println("Failed to add those data.");
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
