
package university.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class EnterMarks extends JFrame implements ActionListener{
    Choice Crollno;
    JComboBox cbsemester;
    JButton submit,cancel;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfsub6,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5,tfmarks6;
    EnterMarks(){
    
        
        setSize(1000,500);
        setLocation(300,150);
       
    setLayout(null);
   getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
    
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon./icons./icons/exam.jpg"));
        Image i2 =i1.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
      
        add(image);
        image.setBounds(550,40,400,300);
      
        
          JLabel heading = new JLabel("Enter marks of Student");
            heading.setBounds(50,0,500,50);
            heading.setFont(new Font("tahoma",Font.BOLD,20));
            add(heading); 
            
            JLabel lblrollno = new JLabel(" Search Roll Number");
           lblrollno.setBounds(50,70,150,20);
            add( lblrollno );
    Crollno = new Choice();
     Crollno.setBounds(200,70,150,20);
     add( Crollno);
    
     try{
    
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from student");
    while(rs.next()){ Crollno.add(rs.getString("rollno"));
    }
   
    
    }
     catch(Exception e){
             
       e.printStackTrace();
     }
     
      JLabel lblsemester = new JLabel(" Select Semester");
      lblsemester.setBounds(50,110,150,20);
      add( lblsemester );
      
       String semester[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
      cbsemester= new JComboBox(semester);
      cbsemester.setBounds(200,110,150,20);
      add(cbsemester);
      
      JLabel lblentersubject = new JLabel(" Enter Subject");
      lblentersubject.setBounds(100,150,200,40);
      add( lblentersubject );
      
      JLabel lblentermarks = new JLabel(" Enter Marks");
      lblentermarks.setBounds(320,150,200,40);
      add( lblentermarks );
      
      tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        
        tfsub2= new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        
         tfsub3= new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);
        
         tfsub4= new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        
         tfsub5= new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);
        
         tfsub6 = new JTextField();
        tfsub6.setBounds(50,350,200,20);
        add(tfsub6);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(260,200,200,20);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(260,230,200,20);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(260,260,200,20);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(260,290,200,20);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(260,320,200,20);
        add(tfmarks5);
        
        tfmarks6 = new JTextField();
        tfmarks6.setBounds(260,350,200,20);
        add(tfmarks6);
        
    submit=new JButton("Submit");
    submit.setBounds(70,400,150,25);
    add(submit);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    
    submit.addActionListener(this);
    submit.setFont(new Font("Tahoma",Font.BOLD, 18));
    
    cancel =new JButton("Cancle");
   cancel.setBounds(280,400,150,25);
   add(cancel);
   cancel.setBackground(Color.BLACK);
   cancel.setForeground(Color.WHITE);
   cancel.addActionListener(this);
   cancel.setFont(new Font("Tahoma",Font.BOLD, 18));
       
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
             
             String subject1= tfsub1.getText();
             String subject2= tfsub2.getText();
             String subject3= tfsub3.getText();
             String subject4= tfsub4.getText();
             String subject5= tfsub5.getText();
             String subject6= tfsub6.getText();
             String marks1= tfmarks1.getText();
             String marks2= tfmarks2.getText();
             String marks3= tfmarks3.getText();
             String marks4= tfmarks4.getText();
             String marks5= tfmarks5.getText();
             String marks6= tfmarks6.getText();
             String rollno= Crollno.getSelectedItem();
             String semester= (String)cbsemester.getSelectedItem();
          try{
           
              Conn c = new Conn();
              String query1="insert into subject values('"+rollno+"', '"+semester+"','"+subject1+"', '"+subject2+"', '"+subject3+"', '"+subject4+"', '"+subject5+"', '"+subject6+"')";
              String query2="insert into marks values('"+rollno+"', '"+semester+"','"+marks1+"', '"+marks2+"', '"+marks3+"', '"+marks4+"', '"+marks5+"', '"+marks6+"')";                                                                                                            
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null, "Marks sucessfull insrted");
              setVisible(false);
          }
            
             catch(Exception e){
             e.printStackTrace();
             }    
      
         }else{
         
         setVisible(false);
         }
    }
    public static void main(String []args){
    new EnterMarks();
    }
    
}
 
