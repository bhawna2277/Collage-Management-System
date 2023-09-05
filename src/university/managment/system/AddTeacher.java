
package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar ;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbcourse;
     JComboBox cbbranchs;
     JButton submit;
     JButton cancle;
    Random ran= new Random();
    long first4 =Math.abs((ran.nextLong()%9000L)+1000L);
    
   
    
       AddTeacher(){
           
            
             setSize(900,700);
            setLocation(300,50);
            setLayout(null);
            getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
            
            JLabel heading = new JLabel("New Teacher Details");
            heading.setBounds(310,40,500,50);
            heading.setFont(new Font("serif",Font.BOLD,30));
            add(heading);
            
            JLabel lblname = new JLabel("Name");
            lblname.setBounds(50,150,100,30);
            lblname.setFont(new Font("serif",Font.BOLD,20));
            add(lblname );
            
            tfname = new JTextField();
            tfname.setBounds(200,150,150,30);
            add(tfname);
            
             JLabel lblfname = new JLabel(" Father Name");
            lblfname.setBounds(400,150,200,30);
            lblfname.setFont(new Font("serif",Font.BOLD,20));
            add(lblfname );
            
            tffname = new JTextField();
            tffname.setBounds(600,150,150,30);
            add(tffname);
            
             JLabel lblrollno = new JLabel("Emloyeement ID");
           lblrollno.setBounds(50,200,200,30);
             lblrollno .setFont(new Font("serif",Font.BOLD,20));
            add( lblrollno );
         
            labelempId = new JLabel("101"+first4);
          labelempId .setBounds(200,200,200,30);
            labelempId.setFont(new Font("serif",Font.BOLD,20));
            add(labelempId);
            
             JLabel lbldob= new JLabel("Date of Birth");
            lbldob.setBounds(400,200,200,30);
              lbldob.setFont(new Font("serif",Font.BOLD,20));
            add(lbldob);
            
            dcdob =new JDateChooser();
            dcdob.setBounds(600, 200, 150, 30);
            add(dcdob);
            
             JLabel lbladdress = new JLabel("Address");
            lbladdress.setBounds(50,250,100,30);
            lbladdress.setFont(new Font("serif",Font.BOLD,20));
            add(lbladdress );
            
            tfaddress = new JTextField();
            tfaddress.setBounds(200,250,150,30);
            add(tfaddress);
            
             JLabel lblphone= new JLabel("Phone number");
            lblphone.setBounds(400,250,200,30);
           lblphone.setFont(new Font("serif",Font.BOLD,20));
            add(lblphone );
            
            tfphone = new JTextField();
            tfphone.setBounds(600,250,150,30);
            add(tfphone);
            
               JLabel lblemail = new JLabel("Email Id");
           lblemail.setBounds(50,300,100,30);
            lblemail.setFont(new Font("serif",Font.BOLD,20));
            add(lblemail );
            
            tfemail = new JTextField();
             tfemail.setBounds(200,300,150,30);
            add (tfemail);
            
             JLabel lblx= new JLabel("Class X (%)");
            lblx.setBounds(400,300,200,30);
           lblx.setFont(new Font("serif",Font.BOLD,20));
            add(lblx );
            
            tfx= new JTextField();
            tfx.setBounds(600,300,150,30);
            add(tfx);
            
                JLabel lblxii= new JLabel("Class XII (%)");
            lblxii.setBounds(50,350,100,30);
            lblxii.setFont(new Font("serif",Font.BOLD,20));
            add(lblxii );
            
            tfxii = new JTextField();
            tfxii.setBounds(200,350,150,30);
            add(tfxii);
            
             JLabel lbaadhar= new JLabel("Aadhar Number");
            lbaadhar.setBounds(400,350,200,30);
           lbaadhar.setFont(new Font("serif",Font.BOLD,20));
            add(lbaadhar );
            
            tfaadhar= new JTextField();
            tfaadhar.setBounds(600,350,150,30);
            add(tfaadhar);
            
            JLabel lbcourse= new JLabel("Qualification");
            lbcourse.setBounds(50,400,200,30);
            lbcourse.setFont(new Font("serif",Font.BOLD,20));
            add(lbcourse );
            
            String course[]= {"B.tech","BBA","BSc","BA","BCA","BCom","MCom", "MCA","m.tech"};
            
            cbcourse =new JComboBox(course);
            cbcourse.setBounds(200, 400, 150, 30);
            cbcourse.setBackground(Color.white);
            add(cbcourse);
            
            JLabel lblbranch= new JLabel("Department");
            lblbranch.setBounds(400,400,200,30);
            lblbranch.setFont(new Font("serif",Font.BOLD,20));
            add(lblbranch );
            
            String Branch[]= {"Computer Science","IT","Mechanical","Civil","Electrical","Elctronic","Auto mobile Mechanical"};
            
            cbbranchs =new JComboBox(Branch);
            cbbranchs.setBounds(600, 400, 150, 30);
            cbbranchs.setBackground(Color.white);
            add(cbbranchs);
            
     submit=new JButton("Submit");
    submit.setBounds(250,550,120,30);
    add(submit);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    
    submit.addActionListener(this);
    submit.setFont(new Font("Tahoma",Font.BOLD, 18));
    
    cancle =new JButton("Cancle");
    cancle.setBounds(450,550,120,30);
    add(cancle);
   cancle.setBackground(Color.BLACK);
   cancle.setForeground(Color.WHITE);
  cancle.addActionListener(this);
   cancle.setFont(new Font("Tahoma",Font.BOLD, 18));
   
 
     
  
            setVisible(true);
        }
     
        
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
        
        String name= tfname.getText();
        String fname= tffname.getText();
        String rollno= labelempId.getText();
        String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String address= tfaddress.getText();
        String phone= tfphone.getText();
        String email= tfemail.getText();
        String x= tfx.getText();
        String xii= tfxii.getText();
        String aadhar= tfaadhar.getText();
        String course= (String)cbcourse.getSelectedItem();
         String branch= (String)cbbranchs.getSelectedItem();
        
         
         try{
         String query = "insert into teacher values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
         Conn con= new Conn();
         con.s.executeUpdate(query);
         
         
         if (name.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your name");
         }else if(fname.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your  father name");
         }
         else if(dob.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your  Date of birth");
         }
         else if(address.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your address");
         }
         else if(phone.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your phone number");
         }
         else if(phone.equals("11")){
         JOptionPane.showMessageDialog(this,"phone number must have 10 digit");
         }
         else if(email.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your  email Address");
         }
         else if(x.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your  10 parsentage");
         }
         else if(xii.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your  12 parsentage");
         }
         else if(aadhar.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese enter your  aadhar number");
         }
         else if(aadhar.equals("13")){
         JOptionPane.showMessageDialog(this,"invalid aadhar number");
         }
         else if(course.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese select your course");
         }
         else if(branch.equals(" ")){
         JOptionPane.showMessageDialog(this,"plese Select your branch");
         }
         else{
         JOptionPane.showMessageDialog(null, "Teacher Details Insert Sucessfully");
         }
          setVisible(false);
         }catch(Exception e){}
    }else{
    setVisible(false);
    }
    }
    public static void main(String args[]){
    
    new AddTeacher();
    }

    
}



