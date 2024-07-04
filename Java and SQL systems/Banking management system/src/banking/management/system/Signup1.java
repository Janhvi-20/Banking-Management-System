package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener{
    
    JButton next;
    JTextField namet, fnamet, emailt, addresst, cityt, statet, pincodet, maritalt;
    long random;
    JDateChooser datepick;
    JRadioButton male, female, others, married, unmarried;
    
    Signup1 ()
    {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        //heading of the form 
        { 
        JLabel formno = new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds (140, 20, 600, 40);
        add(formno);
        
        //personal details 
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds (290, 80, 400, 30);
        add(personaldetails);
        
        
        /*____________________________*/
        //name label 
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds (100, 140, 100, 30);
        add(name);
        
        namet = new JTextField();
        namet.setFont(new Font("Raleway", Font.PLAIN, 16));
        namet.setBounds( 300, 140, 400, 30);
        add(namet);
        
        //____________
        
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds (100, 190, 200, 30);
        add(fname);
        
        fnamet = new JTextField();
        fnamet.setFont( new Font("Raleway", Font.PLAIN, 16));
        fnamet.setBounds(300, 190, 400, 30);
        add(fnamet);
        
        //_____________
        
        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds (100, 240, 150, 20);
        add(dob);
        
        datepick = new JDateChooser();
        datepick.setBounds(300, 240, 400, 30);
        datepick.setForeground(Color.black);
        add(datepick);
        
        //___________________
       
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds (100, 290, 150, 20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 120, 30);
        male.setBackground(Color.WHITE);
        add(male);//male
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);//female
        
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        
        //______________
        
        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds (100, 340, 150, 20);
        add(email);
        
        emailt = new JTextField();
        emailt.setFont( new Font("Raleway", Font.PLAIN, 16));
        emailt.setBounds(300, 340, 400, 30);
        add(emailt);
        
        //_____________
        
        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds (100, 390, 150, 20);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);//married
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);//unmarried
        others = new JRadioButton("Other");
        others.setBounds(600, 390, 120, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(unmarried);
        group2.add(married);
        group2.add(others);
        
        //______________
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds (100, 440, 100, 20);
        add(address);
        
        addresst = new JTextField();
        addresst.setFont( new Font("Raleway", Font.PLAIN, 16));
        addresst.setBounds(300, 440, 400, 30);
        add(addresst);
        
        //____________
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds (100, 540, 100, 20);
        add(city);
        
        cityt = new JTextField();
        cityt.setFont( new Font("Raleway", Font.PLAIN, 16));
        cityt.setBounds(300, 540, 400, 25);
        add(cityt);
        
        //_________
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds (100, 490, 100, 20);
        add(state);
        
        statet = new JTextField();
        statet.setFont( new Font("Raleway", Font.PLAIN, 16));
        statet.setBounds(300, 490, 400, 25);
        add(statet);
       
       //___________ 
        
        JLabel pincode = new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds (100, 590, 100, 20);
        add(pincode);
        
        pincodet = new JTextField();
        pincodet.setFont( new Font("Raleway", Font.PLAIN, 16));
        pincodet.setBounds(300, 590, 400, 25);
        add(pincodet);
    }
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setBounds(620, 660, 80, 30);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        add(next);
        next.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random; //long
        String name = namet.getText();
        String fname = fnamet.getText();
        String email = emailt.getText();
        String gender = null;
        String dob = ((JTextField)datepick.getDateEditor().getUiComponent()).getText();
        if(male.isSelected())
            gender = "male";
        else if (female.isSelected())
            gender ="female";
        
        String marital = null;
        if (married.isSelected())
            marital ="married";
        else if (unmarried.isSelected())
            marital ="unmarried";
        else if (others.isSelected())
            marital ="others";
        
        String city = cityt.getText();
        String state = statet.getText();
        String address = addresst.getText();
        String pin = pincodet.getText();
        
        try {
            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Name is Required");
            else if(email.equals(""))
                JOptionPane.showMessageDialog(null,"Email is Required");
            else if(city.equals(""))
                JOptionPane.showMessageDialog(null,"City is Required");
            else
            {
                Conn c = new Conn();
                String query ="insert into signup1 value('"+formno+"' ,'"+name+"' ,'"+fname+"' ,'"+dob+"' ,'"+gender+"' ,'"+email+"' ,'"+marital+"','"+state+"' ,'"+city+"' ,'"+address+"' ,'"+pin+"')";
                c.s.executeUpdate(query);
                
            
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
            
            
        }catch (Exception e)
        {System.out.println(e);}
    }
    
    public static void main (String args[])
    {
        new Signup1();
    }
}
