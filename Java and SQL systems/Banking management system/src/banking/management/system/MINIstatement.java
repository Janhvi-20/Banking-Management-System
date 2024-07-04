
package banking.management.system;

import javax.swing.*;
import java.awt.*;

import java.sql.*;

public class MINIstatement extends JFrame {
    
    String pinnumber;
    MINIstatement(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel bank = new JLabel("Punjab National Bank");
        bank.setBounds(120,20,200,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,400);
        add(mini);
        
        JLabel bal = new JLabel();
        bal.setBounds(20,440,400,50);
        add(bal);
        
       
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select* from login where pin = '"+pinnumber+"';");
            while (rs.next())
            {
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4) + "XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select* from bank where pin = '"+pinnumber+"';");
             int balance = 0;
            while (rs.next())
            {
                 if (rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } 
                    else 
                        balance -= Integer.parseInt(rs.getString("amount"));
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }
            bal.setText("Your Current Account Balance is Rs."+balance);
        }
        catch ( Exception e)
        {
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main (String args[])
    {
        new MINIstatement("");
    }
}
