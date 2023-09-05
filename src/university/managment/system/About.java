
package university.managment.system;
import javax.swing.*;
import java.awt.*;
public class About extends JFrame {
    About(){
        
        setSize(700,500);
        setLocation(400,150);
        setLayout(null);
     getContentPane().setBackground(Color.BLUE.decode("#87CEEB"));
     
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon./icons./icons/bha.jpg"));
        Image i2 =i1.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        image.setBounds(350,20,300,200);
        
     JLabel heading = new JLabel("<html> University<br/> Management System </html>");
            heading.setBounds(70,20,250,130);
            heading.setFont(new Font("tahoma",Font.BOLD,24));
            add(heading); 
            
             JLabel name = new JLabel("Developed By : Bhawna Mishra");
             name.setBounds(70,220,500,40);
             name.setFont(new Font("tahoma",Font.BOLD,24));
            add( name); 
            
            
            JLabel contect = new JLabel("Contect: 7817030982");
            contect.setBounds(70,270,500,40);
             contect.setFont(new Font("tahoma",Font.PLAIN,24));
            add( contect); 
            
             JLabel email= new JLabel("Email: mishrabhawna20031@gmail.com");
            email.setBounds(70,330,500,40);
             email.setFont(new Font("tahoma",Font.PLAIN,24));
            add( email); 
            
      
            
            
        setVisible(true);
    
    }
    
    public static void main(String []args){
    new About();
    }
}
