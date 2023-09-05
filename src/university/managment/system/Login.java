
package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
    
    JButton login,cancle;
    JTextField tfusername,tfpassword;
    Login(){
    setLayout(null);
    getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
    
    JLabel lblusername = new JLabel("username");
    lblusername.setFont(new Font("Tahoma",Font.BOLD,18));
    lblusername.setBounds(40, 20 ,100 ,20);
    add(lblusername);
    
     tfusername = new JTextField();
    tfusername.setBounds(150,20,150,20);
    add(tfusername);
    
    
     JLabel lblpassword= new JLabel("password");
    lblpassword.setFont(new Font("Tahoma",Font.BOLD,18));
    lblpassword.setBounds(40, 70 ,100 ,20);
    add(lblpassword);
    
     tfpassword = new  JPasswordField();
    tfpassword.setBounds(150,70,150,20);       
   add(tfpassword);
   
  
    
    login =new JButton("Login");
    login.setBounds(40,140,120,30);
    add(login);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    
    login.addActionListener(this);
    login.setFont(new Font("Tahoma",Font.BOLD, 18));
    
    cancle =new JButton("Cancle");
    cancle.setBounds(180,140,120,30); 
    add(cancle);
   cancle.setBackground(Color.BLACK);
   cancle.setForeground(Color.WHITE);
   cancle.addActionListener(this);
   cancle.setFont(new Font("Tahoma",Font.BOLD, 18));
   
   
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon./icons./icons/second.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        image.setBounds(350,0,200,200);
     
    setSize(600,300);
    setVisible(true);
    setLocation(500,250);
    
    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==login){
        String username= tfusername.getText();
         String password= tfpassword.getText();
         String query = "select * from login where username='"+username+"'and password='"+password+"'";
         
         try{
         Conn c =new Conn();
          ResultSet rs =c.s.executeQuery(query);
          
          if(rs.next()){
          setVisible(false);
          //new Frame
          new Project();
          
          }else{
              JOptionPane.showMessageDialog(null, "invalid username or password");
              setVisible(false);          
          }
          c.s.close();
         }catch(Exception e){
         
         e.printStackTrace();}
    
    }else if(ae.getSource()==cancle){
    
    setVisible(false);
    }
    }
    
    public static void main( String[] args){
        new Login();
    }
    
}
