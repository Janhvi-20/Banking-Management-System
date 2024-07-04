
package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton exit, deposit, pinchange, ministatement, balance, fast, withdrawl;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(215, 300, 700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);
        
        //____________ buttons
        deposit = new JButton("Rs. 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl = new JButton("Rs. 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fast = new JButton("Rs. 1000");
        fast.setBounds(170,450,150,30);
        fast.addActionListener(this);
        image.add(fast);
        
         ministatement = new JButton("Rs. 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange = new JButton("Rs. 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balance = new JButton("Rs. 10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize (900,900);
        setLocation (300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else 
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            amount = amount.trim();
            Conn c  = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select* from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next())
                {
                    if (rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } 
                    else 
                        balance -= Integer.parseInt(rs.getString("amount"));
                }
                if (ae.getSource()!= exit && balance < Integer.parseInt(amount))
                {   JOptionPane.showMessageDialog(null,"Insufficent balance");
                return; }
                Date date = new Date();
                String withdraw ="Withdrawl";
                String query ="insert into bank values ( '"+pinnumber+"', '"+date+"', '"+withdraw+"', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[])
    {
        new FastCash("");
    }
}
