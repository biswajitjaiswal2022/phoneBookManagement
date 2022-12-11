
package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;



public class DeleteContact extends JFrame implements ActionListener  {
    
    String x[] =  { "Id " , "Name ", "Nick Name " , "Phone No " , "Mob No" , "Email Address" , "Home Address", "Company ", "Position", "Group Name"} ;
    String y[][] = new String [20][10];
    int i=0 , j=0;
    JTable t;
    Font f1 ;
    JButton bt1 ;
    JTextField tf1 ;
    JPanel p1 ;
    JLabel l1;
    
    DeleteContact ()
    {
        super ("Contact Informarion ");
        setSize (800,400);
        setLocation(400,170);
        
         f1 = new Font ("Arial" , Font.BOLD , 10);
        
        try 
        {
            ConnectionClass obj = new ConnectionClass ();
            String q = " SELECT  * FROM add_contact ";
            ResultSet rest =  obj.stm.executeQuery(q);
            
            while (rest.next())
            {
                y[i][j++] = rest.getString("Id");
                y[i][j++] = rest.getString ("name");
                y[i][j++] = rest.getString ("nickName");
                y[i][j++] = rest.getString ("phoneNo");
                y[i][j++] = rest.getString ("mobNo");
                y[i][j++] = rest.getString ("emailAddress");
                y[i][j++] = rest.getString ("homeaddress");
                y[i][j++] = rest.getString ("company");
                y[i][j++] = rest.getString ("position");
                y[i][j++] = rest.getString ("groupName");
                
                i++;
                j =0;
                
            }
            
            t = new JTable (y ,x );
            t.setFont(f1);
            
            
        }
        catch (Exception ex )
        {
            ex.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane (t);
        
        l1 = new JLabel("Enter contact Id : ");
          tf1 = new JTextField ();
          bt1 = new JButton ("Delete");
          
          bt1.addActionListener(this);
          
          p1 = new JPanel ();
          p1.setLayout(new GridLayout(1 , 3 , 10 ,10 ));
        
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"South");
        add(sp,"Center");
        
         
    }
    
    public void actionPerformed (ActionEvent e )
    {
        
        if (e.getSource() == bt1 )
        {   
            int idNo = Integer.parseInt(tf1.getText());
            try {
                ConnectionClass obj = new ConnectionClass ();
                String q =  " DELETE FROM add_contact WHERE Id = '" + idNo + "'";
               int aa = obj.stm.executeUpdate(q);
            
          if (aa == 1 )
          {
              JOptionPane.showMessageDialog(null , "Your contact has been Deleted ");
              this.setVisible (false );
              new DeleteContact().setVisible (true);
              
          }
          
          else 
          {
              JOptionPane.showMessageDialog(null ," No such data Found ");
              this.setVisible (false );
              new DeleteContact().setVisible (true);
              
          }
          
              
        }
            catch(Exception ex )
            {
                ex.printStackTrace();
            }
        
    }
}
    
    public static void main(String [] args )
    {
        new DeleteContact().setVisible(true);
    }
}
