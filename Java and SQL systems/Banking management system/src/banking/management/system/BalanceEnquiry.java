
package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("BALANCE RECORD");
        text.setBounds(280, 300, 700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);
        
        int balance = 0;
         try{
             Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select* from bank where pin = '"+pinnumber+"'");
                
                while (rs.next())
                {
                    if (rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } 
                    else 
                        balance -= Integer.parseInt(rs.getString("amount"));
                }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         
         JLabel state = new JLabel("Your Current Account have Rs. "+balance);
         state.setBounds(170,350,400,30);
         state.setForeground(Color.white);
         state.setFont(new Font("System", Font.BOLD, 15));
         image.add(state);
         
        back = new JButton("Back");
        back.setBounds(355, 520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize (900,900);
        setLocation (300,0);
        setUndecorated(true);
        setVisible(true);
    }
      public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}
