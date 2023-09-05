
package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
    
    Project(){
        setSize(1540,850);
               
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon./icons./icons/third.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1500,700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image); 
         
        JMenuBar mb = new  JMenuBar();
        // information
        JMenu newInformation = new JMenu("New information");
        newInformation.setFont(new Font("Tahoma",Font.BOLD, 16));
        newInformation.addActionListener(this);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new  JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem StudentInfo = new  JMenuItem("New Student Information");
        StudentInfo .setBackground(Color.WHITE);
        StudentInfo .addActionListener(this);
        newInformation.add(StudentInfo);
       
         // details
          
        JMenu details = new JMenu("view Details");
        details.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(details);

        JMenuItem facultydetails = new  JMenuItem("view Faculty Details");
       facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem Studentdetails  = new  JMenuItem("View Student Details");
        Studentdetails.setBackground(Color.WHITE);
        Studentdetails.addActionListener(this);
       details.add(Studentdetails);
       
       //Leave
       
         JMenu leave = new JMenu("Apply for Leave");
        leave.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(leave);

        JMenuItem facultyleave = new  JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
         facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem Studentleave = new  JMenuItem("Student Leave");
        Studentleave.setBackground(Color.WHITE);
        Studentleave.addActionListener(this);
       leave.add(Studentleave);
       
       //Leave details
       
         JMenu leaveDetails = new JMenu(" Leave Detalis");
        leaveDetails.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails = new  JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
       facultyleaveDetails.addActionListener(this);
      leaveDetails.add(facultyleaveDetails);
        
        JMenuItem StudentleaveDetails = new  JMenuItem(" Studet leave Details");
        StudentleaveDetails.setBackground(Color.WHITE);
        StudentleaveDetails.addActionListener(this);
       leaveDetails.add(StudentleaveDetails);
       
       //exam
       
        JMenu exam = new JMenu(" Examination");
        exam.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(exam);
        
          JMenuItem entermarks = new  JMenuItem("Enter marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
       exam.add(entermarks);

        JMenuItem ExaminationDetails = new  JMenuItem("Examination Details");
        ExaminationDetails.setBackground(Color.WHITE);
         ExaminationDetails.addActionListener(this);
       exam.add(ExaminationDetails);
        
      
       
       //update Informattion
         JMenu updateInfo= new JMenu(" Update Details");
        updateInfo.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(updateInfo);

        JMenuItem updatefacultyInfo= new  JMenuItem("Update Faculty Details");
        updatefacultyInfo.setBackground(Color.WHITE);
         updatefacultyInfo.addActionListener(this);
       updateInfo.add(updatefacultyInfo);
        
        JMenuItem updatestudentInfo = new  JMenuItem("Update Student Details");
        updatestudentInfo.setBackground(Color.WHITE);
        updatestudentInfo.addActionListener(this);
       updateInfo.add(updatestudentInfo);
       
       //fee stru*
         JMenu fee= new JMenu(" Fee Details");
        fee.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(fee);

       JMenuItem feestructure= new  JMenuItem("Fee Structure");
       feestructure.setBackground(Color.WHITE);
       feestructure.addActionListener(this);
       fee.add(feestructure);
        
        JMenuItem feeform = new  JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
       
       //utility
       
         JMenu utility= new JMenu("Utility");
        utility.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(utility);

       JMenuItem notepad= new  JMenuItem("Notepad");
       notepad.setBackground(Color.WHITE);
       notepad.addActionListener(this);
       utility.add(notepad);
        
        JMenuItem calce = new  JMenuItem("Calculator");
        calce.setBackground(Color.WHITE);
        calce.addActionListener(this);
        utility.add(calce);
        
        
           //about
       
         JMenu about= new JMenu("About");
       about.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(about);

       JMenuItem ab= new  JMenuItem("About");
       ab.setBackground(Color.WHITE);
       ab.addActionListener(this);
       about.add(ab);
        
         //exit
       
         JMenu exit= new JMenu("Exit");
       exit.setFont(new Font("Tahoma",Font.BOLD, 16));
        mb.add(exit);

       JMenuItem ex= new  JMenuItem("Exit");
       ex.setBackground(Color.WHITE);
       ex.addActionListener(this);
       exit.add(ex);
        
        
        
         
        setJMenuBar(mb);
        
        
       setVisible(true);
  
    
            } 
    public void actionPerformed(ActionEvent ae){
    String msg=ae.getActionCommand();
    
    if (msg.equals("Exit")){
       setVisible(false);
            }
    else if (msg.equals("Calculator")){
       try {
          Runtime.getRuntime().exec("calc.exe"); 
       }catch (Exception e){
           
       }
    }
    
     else if (msg.equals("Notepad")){
       try {
          Runtime.getRuntime().exec("notepad.exe"); 
       }catch (Exception e){
       }
     }
          else if (msg.equals("New Faculty Information")){
               new AddTeacher();
               
               }
        else if (msg.equals("New Student Information")){
               new AddStudent();
    }
        else if (msg.equals("view Faculty Details")){
               new TeacherDetails();
    }
        else if (msg.equals("View Student Details")){
               new StudentDetails();
    } else if (msg.equals("Faculty Leave")){
               new TeacherLeave();
    }
     else if (msg.equals("Student Leave")){
               new StudentLeave();
    }     else if (msg.equals("Faculty Leave Details")){
               new TeacherLeaveDetails();
    }
         else if (msg.equals(" Studet leave Details")){
               new StudentLeaveDetails();
    }  else if (msg.equals("Update Faculty Details")){
               new UpdateTeacher();
    }
         else if (msg.equals("Update Student Details")){
               new UpdateStudent();
    }
             else if (msg.equals("Enter marks")){
               new EnterMarks();
    }
     else if (msg.equals("Examination Details")){
               new ExaminationDetails();
    }
    else if (msg.equals("Fee Structure")){
               new FeeStructure();
    }
     else if (msg.equals("Student Fee Form")){
               new StudentFee();
    }
    else if (msg.equals("About")){
               new About();
    }
     
               
    }
    public static void main(String []args){
           new Project();
    }
    
}
