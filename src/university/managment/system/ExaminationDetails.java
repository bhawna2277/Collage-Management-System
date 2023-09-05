
package university.managment.system;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.*;

public class ExaminationDetails extends JFrame  implements ActionListener {
   JTextField search; 
   JButton result,Back;
   JTable table;
    
     ExaminationDetails(){
     
     setSize(1000,475);
     setLocation(300,100);
     setLayout(null);
     getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
     
     JLabel heading = new JLabel("Cheak Result");
            heading.setBounds(80,15,400,50);
            heading.setFont(new Font("tahoma",Font.BOLD,24));
            add(heading); 
            
        search = new JTextField();
        search .setBounds(80,90,200,30);
        search.setFont(new Font("tahoma",Font.PLAIN,18));
        add(search );
        
     result=new JButton("Result");
    result.setBounds(300,90,120,30);
    add(result);
    result.setBackground(Color.BLACK);
    result.setForeground(Color.WHITE);
    
   result.addActionListener(this);
    result.setFont(new Font("Tahoma",Font.BOLD, 18));
    
    Back =new JButton("Back");
   Back.setBounds(440,90,120,30);
   add(Back);
   Back.setBackground(Color.BLACK);
   Back.setForeground(Color.WHITE);
   Back.addActionListener(this);
   Back.setFont(new Font("Tahoma",Font.BOLD, 18));
   
   table=new JTable();
   table.setFont(new Font("Tahoma",Font.PLAIN, 16));
   
 
   
   try{
   Conn c = new Conn();
    ResultSet rs = c.s.executeQuery("select * from student");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
   }catch(Exception e){
   e.printStackTrace();
   }
   
   JScrollPane jsp= new JScrollPane(table);
   jsp.setBounds(0,130,1000,310);
   add(jsp);
   
   table.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent me){
     int row=table.getSelectedRow();
      search.setText(table.getModel().getValueAt(row, 2).toString());
     
     }
     
     });
   
     setVisible(true);
     
   
     }
      public void actionPerformed(ActionEvent ae){
      
      if(ae.getSource()==result){
           setVisible(false);
       new Marks(search.getText());
        
      }else{
      
      setVisible(false);
      }
      
      
      }
     public static void main(String[]args){
     new ExaminationDetails();
     }
    
}
