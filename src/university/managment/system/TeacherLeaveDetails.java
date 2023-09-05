
package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class  TeacherLeaveDetails extends JFrame implements ActionListener {
    
    Choice CEmpId;
    JTable table;
    JButton search,print,cancel;
    
    TeacherLeaveDetails(){
     getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
    setLayout(null);
    
    
    JLabel heading = new JLabel("Search by Employee ID");
    heading.setBounds(20,20,150,20);
    add(heading);
    
    CEmpId = new Choice();
     CEmpId.setBounds(180,20,150,20);
     add(CEmpId);
     
     
     
     try{
    
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from teacher");
    while(rs.next()){ CEmpId.add(rs.getString("empId"));
    }
   
    
    }
     catch(Exception e){
             
       e.printStackTrace();}
     
    table= new JTable();
    table.setBackground(Color.BLUE.decode("#87CEEB"));
    
     try{
    
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from teacherLeave");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
     catch(Exception e){
             
             e.printStackTrace();} 
    
    JScrollPane jsp = new JScrollPane(table);
    jsp.setBounds(0,100,900,600);
    add(jsp);
    
    search =new JButton("Search");
    search.setBounds(20,70,80,20);
    search.addActionListener(this);
    add(search);
    
    print =new JButton("Print");
   print.setBounds(120,70,80,20);
   print.addActionListener(this);
    add(print);
    
 
    
    cancel=new JButton("Cancel");
    cancel.setBounds(220,70,80,20);
    cancel.addActionListener(this);
    add(cancel);
     
    setSize(900,600);
    setLocation(300,100);
    setVisible(true);
    
    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==search){
    String query="select * from teacherLeave where empId='"+CEmpId.getSelectedItem()+"'";
    
    try{
    Conn c=new Conn();
    ResultSet rs= c.s.executeQuery(query);
    table.setModel(DbUtils.resultSetToTableModel(rs));
            
    }catch(Exception e){
        e.printStackTrace();}
    }else if(ae.getSource()== print){
    try{
       table.print();
    }catch(Exception e){
        e.printStackTrace();
    }
    }else{
    setVisible(false);
    }
    
    }
    
    public static void main(String []args){
    
       new TeacherLeaveDetails();
    
    } 
    
}

