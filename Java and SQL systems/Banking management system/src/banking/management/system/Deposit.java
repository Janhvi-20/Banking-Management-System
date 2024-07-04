
package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    int var;
    String option;
    Deposit(String pinnumber, int var){
        this.var = var;
        this.pinnumber = pinnumber;
        setLayout(null);
        option = var == 1? "Deposit":"Withdrawl";
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount to "+option);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(235, 300, 400,20);
        image.add(text);
        
       amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        deposit = new JButton(option);
        deposit.setBounds(355, 455,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(355, 520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
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
        else if (ae.getSource() == deposit)
        {
           String number = amount.getText();
           Date date = new Date();
           if (number.equals(""))
               JOptionPane.showMessageDialog(null,"Please enter the amount");
           else 
           {
               try{
               Conn conn = new Conn();
               if (var == 2){
                   ResultSet rs = conn.s.executeQuery("select* from bank where pin = '"+pinnumber+"'");
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
                int n = Integer.parseInt(number);
                if (n>balance)
                    JOptionPane.showMessageDialog(null,"Insufficent Funds");
                else{
                    String query = "insert into bank values ( '"+pinnumber+"', '"+date+"', '"+option+"', '"+number+"' )";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" "+option+"ed Successfully");
                }
               }
               if (var ==1){
               String query = "insert into bank values ( '"+pinnumber+"', '"+date+"', '"+option+"', '"+number+"' )";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+number+" "+option+"ed Successfully");}
               
               
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }
           catch (Exception e)
           {
               System.out.println(e);}
               
           }
           
        }
    }
    
    public static void main(String args[])
    {
        new Deposit("",1);
    }
}
