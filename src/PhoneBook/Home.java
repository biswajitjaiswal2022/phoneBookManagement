
package PhoneBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Home extends JFrame implements ActionListener   {
    
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5;
    JPanel p1,p2,p3;
    Font f1,f2;
    
    Home ()
    {
        super("Home");
        setLocation(520,200);
        setSize(400,500);
        
        f1 = new Font ("Arial", Font.BOLD ,30 );
        f2 = new Font ("Arial" , Font.BOLD , 15);
        
        l1 = new JLabel("  Phone Book");
        l1.setFont(f1);
        
        
        
        b1 = new JButton("Entry");
        b2 = new JButton ("Search");
        b3 = new JButton ("Edit");
        b4 = new JButton("Delete");
        b5 = new JButton("Exit");
        
        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b5.setFont(f2);
            
        b1.addActionListener(this);
        b2.addActionListener (this);
        b3.addActionListener (this);
        b4.addActionListener (this);
        b5.addActionListener (this);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Images/PhoneBook.png.png"));
        Image img2  =  img.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT );
        ImageIcon img3 = new ImageIcon(img2);
        
        l2 = new JLabel(img3);
        
        p1 = new JPanel ();
        p1.setLayout(new GridLayout(5 ,1 ,10,10));
        p1.add(b1 );
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        
        p2 = new JPanel ();
        p2.setLayout (new GridLayout (1,1 , 10,10));
        p2.add(l1);
        
        p3 = new JPanel ();
        p3.setLayout (new GridLayout (1 , 1 , 10 , 10 ));
        p3.add(l2);
        
        setLayout(new BorderLayout (10 ,20));
                add(p1,"Center");
                add(p2,"North");
                add(p3,"East");
                
    }
    
    public void actionPerformed (ActionEvent e )
    {
        if (e.getSource() == b1)
        {
            this.setVisible (false);
            new EntryData().setVisible(true);
        }
        
        if (e.getSource() == b2)
        {
            this.setVisible (false);
            new searchData().setVisible(true); 
        }
        
        if (e.getSource() == b3)
        {
             this.setVisible (false);
            new SearchNameForEdit().setVisible(true);
        }
        
        if (e.getSource() == b4)
        {
             this.setVisible (false);
            new DeleteContact().setVisible(true);
        }
        
        if (e.getSource() == b5)
        {
             this.setVisible (false);
        }
    }
    
    public static void main(String [] args )
    {
        new Home().setVisible(true);
    }
}
