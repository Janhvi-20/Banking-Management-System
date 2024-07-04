package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JButton confirm, cancel;
    JRadioButton saving, current, fixed, recurring;
    String formno;
    JCheckBox c7, atm, internet, mobile, sms, Cheque, statement;
    Signup3(String formno)
    {
        this.formno =formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Accont Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 30));
        l1.setBounds(270, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel ("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,120,200,30);
        add(type);
        
        
        saving = new JRadioButton("Saving Account");
        saving.setBounds(100, 160, 250, 30);
        saving.setBackground(Color.white);
        saving.setFont(new Font("Raleway", Font.BOLD, 18));
        add(saving);
        
        current = new JRadioButton("Current Account");
        current.setBounds(400, 160, 250, 30);
        current.setBackground(Color.white);
        current.setFont(new Font("Raleway", Font.BOLD, 18));
        add(current);
        
        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(100, 200, 250, 30);
        fixed.setBackground(Color.white);
        fixed.setFont(new Font("Raleway", Font.BOLD, 18));
        add(fixed);
        
        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(400, 200, 280, 30);
        recurring.setBackground(Color.white);
        recurring.setFont(new Font("Raleway", Font.BOLD, 18));
        add(recurring);
        
        ButtonGroup accounts = new ButtonGroup();
        accounts.add(current);
        accounts.add(saving);
        accounts.add(fixed);
        accounts.add(recurring);
        
        
        JLabel cdn = new JLabel ("Card Number :");
        cdn.setFont(new Font("Raleway", Font.BOLD, 22));
        cdn.setBounds(100,280,200,30);
        add(cdn);
        
        JLabel cdns = new JLabel ("Your 16 Digit Card Number");
        cdns.setFont(new Font("Raleway", Font.PLAIN, 14));
        cdns.setBounds(100,310,200,20);
        add(cdns);
        
        JLabel cn = new JLabel (" XXXX-XXXX-XXXX-5720 ");
        cn.setFont(new Font("Raleway", Font.BOLD, 23));
        cn.setBounds(330,280,300,30);
        add(cn);
        
        
        
        JLabel pin = new JLabel ("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pins = new JLabel ("Your 4 Digit Password");
        pins.setFont(new Font("Raleway", Font.PLAIN, 14));
        pins.setBounds(100,400,200,20);
        add(pins);
        
        JLabel pn = new JLabel (" X X X X ");
        pn.setFont(new Font("Raleway", Font.BOLD, 23));
        pn.setBounds(330,370,300,30);
        add(pn);
        
        JLabel Service = new JLabel ("Services Required");
        Service.setFont(new Font("Raleway", Font.BOLD, 22));
        Service.setBounds(100,450,200,40);
        add(Service);
        
        atm = new JCheckBox("ATM Card");
        atm.setBackground(Color.white);
        atm.setBounds(100, 500, 250, 30);
        atm.setFont(new Font("Raleway", Font.BOLD, 18));
        add(atm);
        
        internet = new JCheckBox("Internet Banking");
        internet.setBounds(400, 500, 250, 30);
        internet.setBackground(Color.white);
        internet.setFont(new Font("Raleway", Font.BOLD, 18));
        add(internet);
        
        mobile = new JCheckBox("Mobile Banking");
        mobile.setBounds(100, 550, 250, 30);
        mobile.setBackground(Color.white);
        mobile.setFont(new Font("Raleway", Font.BOLD, 18));
        add(mobile);
        
        sms = new JCheckBox("Current Account");
        sms.setBounds(400, 550, 250, 30);
        sms.setBackground(Color.white);
        sms.setFont(new Font("Raleway", Font.BOLD, 18));
        add(sms);
        
        Cheque = new JCheckBox("Saving Account");
        Cheque.setBounds(100, 600, 250, 30);
        Cheque.setBackground(Color.white);
        Cheque.setFont(new Font("Raleway", Font.BOLD, 18));
        add(Cheque);
        
        statement = new JCheckBox("SMS Statement");
        statement.setBounds(400, 600, 250, 30);
        statement.setBackground(Color.white);
        statement.setFont(new Font("Raleway", Font.BOLD, 18));
        add(statement);
        
        
        c7 = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge");
        c7.setBounds(80, 670, 650, 30);
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        add(c7);
        
        confirm = new JButton("SUBMIT");
        confirm.setBackground(Color.black);
        confirm.setForeground(Color.white);
        confirm.setFont(new Font("Raleway", Font.BOLD, 16));
        confirm.setBounds(230, 720, 100, 30 );
        confirm.addActionListener(this);
        add(confirm);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(430, 720, 100, 30 );
        cancel.addActionListener(this);
        add(cancel);
       
        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == confirm)
        {
            String account = "";
            if(saving.isSelected())
                account = "Saving";
            else if (current.isSelected())
               account ="Current Deposit";
            else if (fixed.isSelected())
               account ="Fixed Deposit";
            else if (recurring.isSelected())
               account ="Recurring Deposit";
            
            Random random = new Random();
            
            String pin = ""+ Math.abs(random.nextLong() %9000L +1000L);
            String cardnumber = ""+ Math.abs(random.nextLong() % 9000000L +5085460000000000L);
            
            String check ="";
            if(atm.isSelected())
                check = check +" ATM Card";
            else if(internet.isSelected())
                check = check + " Internet Banking";
            else if(mobile.isSelected())
                check = check + " Mobile Banking";
            else if(sms.isSelected())
                check = check + " Email and SMS";
            else if(Cheque.isSelected())
                check = check + " Cheque Book";
            else if(statement.isSelected())
                check = check + "  E-Statement";
        
            try {
                if (account.equals(""))
                    JOptionPane.showMessageDialog(null,"Account tpye required");
                else 
                {
                    Conn con = new Conn();
                    
                    String query ="insert into signup3 value('"+formno+"' ,'"+account+"' ,'"+cardnumber+"' ,'"+pin+"' ,'"+check+"')";        
                    String query2 = "insert into login values ('"+formno+"' , '"+cardnumber+"' ,'"+pin+"')";
                    con.s.executeUpdate(query);
                    con.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+pin);
                    
                    
                    setVisible(false);
                    new Deposit(pin,1).setVisible(true);
                    
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        
        else if (ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Signup3("");
    }
}
