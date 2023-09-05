

package university.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentFee extends JFrame implements ActionListener{
     Choice Crollno;
     JComboBox cbcourse,cbbranchs, cbsemester;
     JLabel labeltotal;
     JButton update,pay,Back;
    StudentFee(){
        setSize(900,500);
        setLocation(300,100);
         
    setLayout(null);
  getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
    
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon./icons./icons/fee.jpg"));
        Image i2 =i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        image.setBounds(500,40,350,250);
        
    JLabel lblrollnumber = new JLabel("Select Roll Number");
    lblrollnumber .setBounds(40,60,160,20);
    lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
    add(lblrollnumber );
    
    Crollno = new Choice();
     Crollno.setBounds(210,60,160,20);
     add( Crollno);
    
     try{
    
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from student");
    while(rs.next()){ 
        Crollno.add(rs.getString("rollno"));
    }
   
    
    }
     catch(Exception e){
             
       e.printStackTrace();}
            
            JLabel lblname = new JLabel("Name");
            lblname.setBounds(40,100,160,20);
            lblname.setFont(new Font("Tahoma",Font.BOLD,16));
            add(lblname );
            
            JLabel labelname = new JLabel();
            labelname.setBounds(200,100,160,30);
            labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
            add(labelname);
            
             JLabel lblfname = new JLabel(" Father Name");
            lblfname.setBounds(40,140,160,30);
           lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
            add(lblfname );
            JLabel labelfname = new JLabel();
            labelfname.setBounds(200,140,160,20);
             labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
            add(labelfname);
            
              try{
            Conn c=new Conn();
            String query= "select * from student where rollno='"+Crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
            labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
            
            }
            }catch(Exception e){
            e.printStackTrace();
            }
              
                         Crollno.addItemListener(new ItemListener(){
       public void itemStateChanged(ItemEvent ie){
       
               try{
            Conn c=new Conn();
            String query= "select * from student where rollno='"+Crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
            labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
           
            }
            }catch(Exception e){
            e.printStackTrace();
            }
       }
       
       });
                         
            JLabel lbcourse= new JLabel("Course");
            lbcourse.setBounds(40,180,160,20);
            lbcourse.setFont(new Font("Tahoma",Font.BOLD,16));
            add(lbcourse );
            
            String course[]= {"BTech","BSC","BCA", "MTech","MSC"," MCA"};
            
            cbcourse =new JComboBox(course);
            cbcourse.setBounds(200, 180, 160, 20);
            cbcourse.setBackground(Color.white);
            add(cbcourse);
            
            JLabel lblbranch= new JLabel("Branchs");
            lblbranch.setBounds(40,220,160,20);
            lblbranch.setFont(new Font("Tahoma",Font.BOLD,16));
            add(lblbranch );
            
            String Branch[]= {"Computer Science","IT","Mechanical","Civil","Electrical","Elctronic","Auto mobile Mechanical"};
            
            cbbranchs =new JComboBox(Branch);
            cbbranchs.setBounds(200, 220, 160, 20);
            cbbranchs.setBackground(Color.white);
            add(cbbranchs);
            
       JLabel lblsemester = new JLabel(" Semester");
      lblsemester.setBounds(40,260,160,20);
       lblsemester.setFont(new Font("Tahoma",Font.BOLD,16));
      add( lblsemester );
      
       String semester[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
      cbsemester= new JComboBox(semester);
      cbsemester.setBounds(200,260,160,20);
      add(cbsemester);
            
      JLabel lbltotal = new JLabel("total payable");
       lbltotal.setBounds(40,300,160,20);
       lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
      add(  lbltotal );
      
      labeltotal = new JLabel();
      labeltotal.setBounds(200,300,160,20);
      labeltotal.setFont(new Font("Tahoma",Font.BOLD,16));
      add( labeltotal );
      
      
      
    update=new JButton("Update");
    update.setBounds(30,380,100,25);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    update.setFont(new Font("Tahoma",Font.BOLD,16));
    add(update);
    
   pay =new JButton("Pay Fee");
   pay .setBounds(150,380,100,25);
   pay .setBackground(Color.BLACK);
   pay .setForeground(Color.WHITE);
   pay.setFont(new Font("Tahoma",Font.BOLD,16));
   pay .addActionListener(this);
   add(pay );
  
    Back =new JButton("Back");
   Back.setBounds(270,380,100,25);
   Back.setBackground(Color.BLACK);
   Back.setForeground(Color.WHITE);
   Back.setFont(new Font("Tahoma",Font.BOLD,16));
   Back.addActionListener(this);
   add(Back);   

   
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==update){
        String course = (String)cbcourse.getSelectedItem();
        String semester = (String)cbsemester.getSelectedItem();
        try{
        Conn c = new Conn();
        ResultSet rs= c.s.executeQuery("select * from fee where course='"+course+"'");
        while(rs.next()){
        labeltotal.setText(rs.getString(semester));
        }
        }catch(Exception e){
        
        }
    }else if (ae.getSource()==pay){
        
        String rollno = Crollno.getSelectedItem();
         String course = (String)cbcourse.getSelectedItem();
        String semester = (String)cbsemester.getSelectedItem();
        String branch = (String)cbbranchs.getSelectedItem();
        String total  = labeltotal.getText();
        
        try{
        Conn c = new Conn();
       String query =("insert into collegefee  values ('"+rollno+"','"+course+"','"+semester+"','"+branch+"','"+total+"')");
       c.s.executeUpdate(query);
       
       JOptionPane.showMessageDialog(null,"college fee submitted succesfully");
        setVisible(false);
        }catch(Exception e){
        e.printStackTrace();
        }
    
    }else{
    setVisible(false);
    }
    
    }
    public static void main (String []args){
    new StudentFee();
    }
    
}
