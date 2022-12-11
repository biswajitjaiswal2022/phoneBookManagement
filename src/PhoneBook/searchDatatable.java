
package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class searchDataTable extends JFrame  {
    
    String x[] =  { "Id " , "Name ", "Nick Name " , "Phone No " , "Mob No" , "Email Address" , "Home Address", "Company ", "Position", "Group Name"} ;
    String y[][] = new String [20][10];
    int i=0 , j=0;
    JTable t;
    Font f1 ;
    
    searchDataTable ()
    {
        
    }
    
    searchDataTable (String name1 )
    {
        super("Search Contact ");
        setLocation(400,170);
        setSize(800,400);
        
        f1 = new Font ("Arial" , Font.BOLD , 10);
        
        try 
        {
            ConnectionClass obj = new ConnectionClass ();
            String q = " SELECT  * FROM add_contact WHERE name = " + "'" + name1 +"'";
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
        catch (Exception e )
        {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane (t);
        add(sp);
        
    }
    
    public static void main (String [] args )
    {
        new searchDataTable().setVisible(true);
    }
    
}
