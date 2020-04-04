import java.sql.*;
import javax.swing.*;

public class LecturerRegistration 
{
	@SuppressWarnings("deprecation")
	public static void LectRegister ()
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
      			String mysql = "INSERT INTO admindatabase(Lecturer_UserName, Lecturer_FullName, Lecturer_StaffID, Lecturer_Password, Lecturer_PhoneNumber, Lecturer_EmailAddress, Lecturer_City, Lecturer_Country, Lecturer_Description) values(?,?,?,?,?,?,?,?,?)";
      			String Lecturer_UserName = JOptionPane.showInputDialog("Please enter your username." + "\nThis username will be use for the login.");
      			String Lecturer_FullName = JOptionPane.showInputDialog("Please enter your Full Name.");
      			String Lecturer_StaffID = JOptionPane.showInputDialog("Please enter your Staff ID.");
      			String Lecturer_Password = JOptionPane.showInputDialog("Please enter your Password.");
      			String Lecturer_PhoneNumber =  JOptionPane.showInputDialog("Please enter your Phone Number.");
      			String Lecturer_EmailAddress =  JOptionPane.showInputDialog("Please enter your Email Address.");
      			String Lecturer_City =  JOptionPane.showInputDialog("Please enter the current city that you live.");
      			String Lecturer_Country =  JOptionPane.showInputDialog("Please enter the current country that you live.");
      			String Lecturer_Description = JOptionPane.showInputDialog("Describe yourself.");
      			
       	        PreparedStatement pst = conn.prepareStatement(mysql);
				pst.setString(1, Lecturer_UserName);
      			pst.setString(2, Lecturer_FullName);
      			pst.setString(3, Lecturer_StaffID);
      			pst.setString(4, Lecturer_Password);
      			pst.setString(5, Lecturer_PhoneNumber);
      			pst.setString(6, Lecturer_EmailAddress);
      			pst.setString(7, Lecturer_City);
      			pst.setString(8, Lecturer_Country);
      			pst.setString(9, Lecturer_Description);
      			
      			int i = pst.executeUpdate(); 
      			if(i != 0)
      			{
      				System.out.println("All data has been added.");  
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
