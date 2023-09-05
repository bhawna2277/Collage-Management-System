
package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice CEmpId,Ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave(){
        
    
        setSize(550,550);
        setLocation(600,100);
        setLayout(null);
        getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
     
        
        JLabel heading = new JLabel("Apply leave Teacher");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
         add(heading);
         
           
    JLabel lblrollno = new JLabel("Search by Employee Id");
    lblrollno.setBounds(60,100,200,20);
    lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lblrollno);
    
    CEmpId = new Choice();
     CEmpId.setBounds(60,130,200,20);
     add(CEmpId);

     try{
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from teacher");
    while(rs.next()){
        
       CEmpId.add(rs.getString("empId"));
    }
   
    
    }
     catch(Exception e){
             
             e.printStackTrace();}
     
        JLabel lbldate = new JLabel("Date");
  lbldate .setBounds(60,180,200,20);
    lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lbldate);
    
      dcdate =new JDateChooser();
            dcdate .setBounds(60, 210, 200, 25);
            add(dcdate );
            
    JLabel lbltime = new JLabel("Time Duration");
   lbltime .setBounds(60,260,200,20);
    lbltime .setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lbltime );
    
    Ctime = new Choice();
     Ctime.setBounds(60,290,200,20);
     Ctime.add("Full Day");
     Ctime.add("Half Day");
     add( Ctime);
     
       submit=new JButton("Submit");
    submit.setBounds(60,350,100,25);
    add(submit);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    
    submit.addActionListener(this);
    submit.setFont(new Font("Tahoma",Font.BOLD, 18));
    
    cancel =new JButton("Cancle");
    cancel.setBounds(200,350,100,25);
    add(cancel);
   cancel.setBackground(Color.BLACK);
   cancel.setForeground(Color.WHITE);
  cancel.addActionListener(this);
   cancel.setFont(new Font("Tahoma",Font.BOLD, 18));
            
            
     
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
if(ae.getSource()==submit){
    String rollno =CEmpId.getSelectedItem();
    String date=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
    String duration=Ctime.getSelectedItem();
    
    String query= "insert into teacherLeave values('"+rollno+"', '"+date+"', '"+duration+"')";
    
    try{
    Conn c= new Conn();
    c.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "leave Conform");
    setVisible(false);
    
    }
    catch(Exception e){
    e.printStackTrace();
    }
        
    
    }
else{
  setVisible(false);
            }
    }
    public static void main(String []arg){
    new TeacherLeave();
    
    }
}

