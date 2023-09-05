
package university.managment.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","bhawna@2003#");
        s=c.createStatement();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
}
