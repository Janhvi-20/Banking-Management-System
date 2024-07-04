
package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{
    
    String oldpin;
    JButton change, cancel;
    JPasswordField pin, repin,opin;
    
    pinchange(String changed)
    {
        oldpin = changed;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel ("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setBounds(250,300,500,35);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        
        pin = new JPasswordField();
        pin.setFont(new Font ("Raleway", Font.BOLD, 25));
        pin.setBounds(330,340,180,25);
        image.add(pin);
        
        JLabel pintext = new JLabel ("Enter New Pin:");
        pintext.setForeground(Color.white);
        pintext.setBounds(170,340,200,25);
        pintext.setFont(new Font("System", Font.BOLD,14));
        image.add(pintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font ("Raleway", Font.BOLD, 25));
        repin.setBounds(330,380,180,25);
        image.add(repin);
        
        JLabel reeneter = new JLabel ("Re-Enter New Pin:");
        reeneter.setForeground(Color.white);
        reeneter.setBounds(170,380,200,25);
        reeneter.setFont(new Font("System", Font.BOLD,14));
        image.add(reeneter);
        
        opin = new JPasswordField();
        opin.setFont(new Font ("Raleway", Font.BOLD, 25));
        opin.setBounds(330,420,180,25);
        image.add(opin);
        
        JLabel old = new JLabel ("Enter Old Pin:");
        old.setForeground(Color.white);
        old.setBounds(170,420,200,25);
        old.setFont(new Font("System", Font.BOLD,14));
        image.add(old);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        cancel = new JButton("BACK");
        cancel.setBounds(355,520,150,30);
        cancel.addActionListener(this);
        image.add(cancel);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated (true);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == change){
            try{
            String newpin = pin.getText();
            String renewpin = repin.getText();
            String old = opin.getText();
            if (old.equals(oldpin))
            {
                if(newpin.equals(renewpin)&& (!newpin.equals("")) && (!renewpin.equals("")))
                {
                    Conn conn = new Conn();
                    String query1 = "update bank set pin = '"+renewpin+"' where pin = '"+old+"' ;";
                    String query2 = "update login set pin = '"+renewpin+"' where pin = '"+old+"' ;";
                    String query3 = "update signup3 set pin = '"+renewpin+"' where pin = '"+old+"' ;";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null,"Pin changed Sucessfully");
                    setVisible(false);
                    new Transactions(newpin).setVisible(true);
                }  
                else
                {
                    JOptionPane.showMessageDialog(null,"Enter valid Pins");
                    return;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Enter correct pin");
                return;} 
            
            }
            
            
            
            
        catch(Exception e)
             {
              System.out.println(e);
             }
        
        }
        
        
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Transactions(oldpin).setVisible(true);
        }
        
    }
    public static void main (String args[])
    {
        new pinchange("").setVisible(true);
    }
    
}
