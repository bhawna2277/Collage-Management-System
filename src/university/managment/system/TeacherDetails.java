
package university.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class  TeacherDetails extends JFrame implements ActionListener {
    
    Choice CempId;
    JTable table;
    JButton search,print, update,add,cancel;
    
    TeacherDetails(){
    
    setSize(900,700);
    setLocation(300,100);
    setLayout(null);
   getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
   
    JLabel heading = new JLabel("Search by Empolyee ID");
    heading.setBounds(20,20,150,20);
    add(heading);
    
    CempId = new Choice();
     CempId.setBounds(180,20,150,20);
     add( CempId);
     
     
     
     try{
    
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from teacher");
    while(rs.next()){ CempId.add(rs.getString("empId"));
    }
   
    
    }
     catch(Exception e){
             
             e.printStackTrace();}
     
    table= new JTable();
    
     try{
    
    Conn c= new Conn();
    ResultSet rs = c.s.executeQuery("select * from Teacher");
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
    
    update =new JButton("Update");
    update.setBounds(220,70,80,20);
  update.addActionListener(this);
    add(update);
    
    add=new JButton("Add");
    add.setBounds(320,70,80,20);
    add.addActionListener(this);
    add(add);
    
    cancel=new JButton("Cancel");
    cancel.setBounds(420,70,80,20);
    cancel.addActionListener(this);
    add(cancel);
     
   
    setVisible(true);
    
    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==search){
    String query="select * from teacher where empId='"+CempId.getSelectedItem()+"'";
    
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
    }else if(ae.getSource()== update){
        setVisible(false);
       new UpdateTeacher();
    }else if(ae.getSource()== add){
        setVisible(false);
        new AddTeacher();
    
    }else{
    setVisible(false);
    }
    
    }
    
    public static void main(String []args){
    
       new TeacherDetails();
    
    } 
    
}
