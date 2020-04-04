import java.sql.*;  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;    
import javax.swing.JOptionPane;
public class LecturerBase{
   public static void main(String [] args){
   JButton.lectSave=new JButton("Save");
   lectSave.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0){
      try{
      String info= :"Insert into LecturerInfo (FullName, Password ,PhoneNumber, EmailAddress, City ,Country, Description)";
       PreparedStatement pat=connection.prepareStatement(info);
       pat.setString(1,textFieldFullName.getText() );
       pat.setString(2,textFieldPassword.getText() );
       pat.setString(3,textFieldPhoneNumber.getText() );
       pat.setString(4,textFieldEmailAddress.getText() );
       pat.setString(5,textFieldCity.getText() );
       pat.setString(6,textFieldCountry.getText() );
       pat.setString(7,textFieldDescription.getText() );
       pat.execute();
       JOptionPane.showMessageDialog(null, "Data Saved!");
       pat.close();
       }
       catch(Exception e){
       e.printStackTrace()
       }
      }
     }};
     lectSave.setFont(new Font ("Tahoma", Font.BOLD,18));
     lectSave.setBound(10,244,89,31);
     
     JButton.lectSave=new JButton("Update");
   lectUpdate.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0){
      try{
      String info= :("Update LecturerInfo set Fullname= '"+textFieldFullName.getText()++"', Password='"+textFieldPassword.getText() +"' , PhoneNumber='"+textFieldPhoneNumber.getText()+"', EmailAddress='"+textFieldEmailAddress.getText()+"',City='"+textFieldCity.getText()+"' ,Country='"+textFieldCountry.getText() +"', Description='"+textFieldDescription.getText()+"' );
       PreparedStatement pat=connection.prepareStatement(info);
        pat.execute();
       JOptionPane.showMessageDialog(null, "Data Saved!");
       pat.close();
       }
       catch(Exception e){
       e.printStackTrace()
       }
      }
     }};

     
     
     
             