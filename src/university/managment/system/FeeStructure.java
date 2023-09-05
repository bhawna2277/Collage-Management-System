
package university.managment.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    
    
    FeeStructure(){
    
    setSize(1000,600);
    setLocation(250,50);
    setLayout(null);
     getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
 
    JLabel heading = new JLabel("Fee Structure");
            heading.setBounds(50,10,400,30);
            heading.setFont(new Font("tahoma",Font.BOLD,30));
            add(heading); 
            
            JTable table = new JTable();
            
            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0,60,1000,700);
            add(jsp);
            
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
                e.printStackTrace();
            }
           
            
    setVisible(true);
    
    }
    
    public static void main(String args[]){
    new FeeStructure();
    
    
    }
}
