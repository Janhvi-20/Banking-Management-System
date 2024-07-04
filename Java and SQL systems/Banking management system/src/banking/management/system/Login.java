
package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, clear;
    JTextField cardtext; 
    JPasswordField pintext;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 =i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70/*from left*/, 10/*from top*/, 100/*height*/, 100/*width*/);
        add(label);
        
        //for text to display welcoming into atm
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font ("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400,40);
        add(text);
        
        
        JLabel cardno = new JLabel("Card No:"); //card text
        cardno.setFont(new Font ("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        cardtext = new JTextField();//card fill entry
        cardtext.setBounds(300, 150, 250, 30);
        cardtext.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardtext);
        
        JLabel pin = new JLabel("PIN:"); //pin text
        pin.setFont(new Font ("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250,30);
        add(pin);
        pintext = new JPasswordField();// pin entry
        pintext.setBounds(300, 220, 250, 30);
        add(pintext);
        
        
        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,210);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == login)
        {
            Conn conn = new Conn();
            String cardnumber = cardtext.getText();
            String number = pintext.getText();
            String query = "select* from login where cardnumber = '"+cardnumber+"' and pin = '"+number+"'";
            try 
            {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(number).setVisible(true);
                }
                else 
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin");
            }
            catch (Exception e)
            {    System.out.println(e);}
            
        }
        else if (ae.getSource() == clear)
        {
            cardtext.setText("");
            pintext.setText("");
        }
        else if (ae.getSource() == signup)
        {
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    public static void main (String args[])
    {
        new Login();
    }
}
