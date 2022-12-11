
package PhoneBook;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SearchNameForEdit extends JFrame implements ActionListener  {
    
    JLabel l1 ,l2 ;
    JPanel p1 ,p2; 
    JButton bt1 ,bt2 ;
    Font f1 ,f2 ;
    JTextField tf1 ;
    
    
   SearchNameForEdit (){
       
       super ("Edit");
        setLocation(450,300);
        setSize (400 ,200 );
        
        
        f1 = new Font ("Arial",Font.BOLD , 25  );
        f2 = new Font ("Arial " , Font.BOLD ,15 );
        
        l1 = new JLabel ("Search name for Edit  ");
        l1.setFont(f1);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l2 = new JLabel ("  Enter Name ");
        l2.setFont(f2);
        
        tf1 = new JTextField ();
        
        bt1 = new JButton ("Search contact" );
        bt1.setFont (f2);
        
        bt2 = new JButton ("Back ");
        bt2.setFont (f2);
        
        bt1.addActionListener(this );
        bt2.addActionListener (this );
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,2,10 ,20 )) ;
        
        p1.add(l2 );
        p1.add(tf1);
        p1.add(bt1);
        p1.add(bt2);
        
        p2 = new JPanel ();
        p2.setLayout (new GridLayout (1,1,10 ,20 ));
        p2.add(l1);
        
        setLayout (new BorderLayout (10 ,20 ));
        add(p1, "Center");
        add(p2 , "North");
       
   }
   
   public void actionPerformed ( ActionEvent e )
    {
        
        String name = tf1.getText();
        
        if (e.getSource() == bt1 )
        {
            try {
                
                ConnectionClass obj = new ConnectionClass ();
                String q = "SELECT name FROM add_contact WHERE name  = " + "'" + name + "'" ;
                ResultSet rest = obj.stm.executeQuery(q);
                
                if (rest.next())
                {
                    String name1 = rest.getString("name");
                    new SearchDataTableForEdit(name).setVisible(true);
                 
                }
                
                else 
                {
                    
                    JOptionPane.showMessageDialog(null ,"No such contact found ");
                    this.setVisible(false );
                    this.setVisible (true );
                    
                }
            }
            catch (Exception ex )
            {
                ex.printStackTrace();
            }
        }
        
        if (e.getSource() == bt2 )
        {
            this.setVisible (false );
            new Home().setVisible(true);
            
        }
    }
   
   public static void main(String [] args )
   {
       new SearchNameForEdit ().setVisible (true);
   }    
}
