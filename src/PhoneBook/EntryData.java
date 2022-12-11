
package PhoneBook;

import  java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class EntryData extends JFrame implements ActionListener  {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JButton bt1 , bt2 ;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    JPanel p1,p2;
    Font f1,f2;
    
    
    EntryData()
    {
        super("Add Contact");
        setLocation(450,150);
        setSize(500,600);
        
        f1 = new Font ("Areial" ,Font.BOLD , 30 );
        f2  = new Font ("Areial " , Font.BOLD , 15 );
        
        l1 = new JLabel ("Add Contact ");
        l1.setHorizontalAlignment (JLabel.CENTER );
        l2 = new JLabel ("  Name");
        l3 = new JLabel ("  Nick Name ");
        l5 = new JLabel ("  Mob No");
        l6 = new JLabel ("  Email Address");
        l7 = new JLabel ("  Home Address ");
        l8 = new JLabel ("  Company");
        l9 = new JLabel ("  Position");
        l10 = new JLabel ("  Group Name ");
        l4 =new JLabel("  Phone No");
        
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        
        bt1 = new JButton ("Add Contact ");
        bt2 = new JButton ("Back");
        bt1.setFont(f2);
        bt2.setFont(f2);
        bt1.addActionListener(this);
        bt2.addActionListener (this );
        
        tf1 = new JTextField ();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField ();
        tf5 = new JTextField ();
        tf6 = new JTextField();
        tf7 = new JTextField ();
        tf8 = new JTextField ();
        tf9 = new JTextField ();
        
        p1 = new JPanel ();
        p1.setLayout(new GridLayout (10 , 2 , 20 ,20));
        p1.add(l2);
        p1.add(tf1);
        p1.add(l3);
        p1.add(tf2);
        p1.add(l4);
        p1.add(tf3);
        p1.add(l5);
        p1.add(tf4);
        p1.add(l6);
        p1.add(tf5);
        p1.add(l7);
        p1.add(tf6);
        p1.add(l8);
        p1.add(tf7);
        p1.add(l9);
        p1.add(tf8);
        p1.add(l10);
        p1.add(tf9);
        
        p1.add(bt1);
        p1.add(bt2);
        
        
        
        p2 = new JPanel ();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l1);
        
        
        setLayout(new BorderLayout (10 ,20 ));
        add(p1,"Center");
        add(p2, "North");
        
        
    }
    
    public void actionPerformed (ActionEvent e )
    {
        String name = tf1.getText();
        String  nickName     = tf2.getText();
        String  phoneNo    = tf3.getText();
       String   mobNo   = tf4.getText();
       String  emailAddress    = tf5.getText();
       String   homeAddress   = tf6.getText();
       String   company    = tf7.getText();
       String   position   = tf8.getText();
       String  groupName     = tf9.getText();
       
       if (e.getSource() == bt1 )
        {
            try 
            {
                ConnectionClass obj = new ConnectionClass();    
                String q = " INSERT INTO add_contact (name , nickName , phoneNo , mobNo , emailAddress ,homeAddress ,company ,position ,groupName ) VALUE "
                        + "('" + name + "','" + nickName + "','" + phoneNo + "','" + mobNo + "','" + emailAddress + "','" + homeAddress + "','" + company 
                        +"','" + position + "','" + groupName + "')" ;
                       
                int aa  = obj.stm.executeUpdate (q);
                
                if ( aa == 1 )
                {
                   JOptionPane.showMessageDialog(null , "Data enterd  succesFully ");
                   this.setVisible (false );
                   new Home().setVisible(true);
                   
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Incorrect data enterd" );
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
    
    public static void main (String[] args )
    {
        new EntryData().setVisible(true);
    }
}
