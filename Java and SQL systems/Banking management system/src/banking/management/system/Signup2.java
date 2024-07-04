package banking.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JButton next;
    JTextField  pannumber, aadhar;
    JRadioButton syes, sno, eayes, eano;
    JComboBox income,religion, category, occupation, education;
    String formno;
    
    Signup2 (String formno)
    {
        this.formno = formno;
        
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        
        //heading of the form 
        {
        //personal details 
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds (290, 80, 400, 30);
        add(additionaldetails);
        
        
        /*____________________________*/
        //religion label 
        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds (100, 140, 100, 30);
        add(name);
        
        String valreligion[] ={"Hindu", "Muslim", "Sikh", "Christian", "Jain", "Buddhism", "Others"};
        religion = new JComboBox(valreligion);
        religion.setFont(new Font("Raleway", Font.PLAIN, 16));
        religion.setBounds( 300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
   
        //____________
        
        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds (100, 190, 200, 30);
        add(fname);
        
        String valcast[] ={"General","OBC","SC", "ST", "EWS-General","EWS-OBC","Others"};
        category = new JComboBox(valcast);
        category.setFont(new Font("Raleway", Font.PLAIN, 16));
        category.setBounds( 300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        //_____________
        
        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds (100, 240, 150, 20);
        add(dob);
        
        String valincome[] ={"Null","<1,50,000","< 2,50,000", "< 5,00,000", "< 10,00,000"," Greater than 10,00,000"};
        income = new JComboBox(valincome);
        income.setFont(new Font("Raleway", Font.PLAIN, 16));
        income.setBounds( 300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        //___________________
       
        JLabel gender = new JLabel("Educational -");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds (100, 290, 150, 20);
        add(gender);
        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds (100, 315, 150, 20);
        add(email);
        
        String valeducation[] ={"Upto 10th","Upto 12th","Non-Graduate", "Graduate", "Post-Graduate","Doctorate", "Others"};
        education = new JComboBox(valeducation);
        education.setFont(new Font("Raleway", Font.PLAIN, 16));
        education.setBounds( 300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        
        //_____________
        
        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds (100, 390, 150, 20);
        add(marital);
        
        String valoccupation[] ={"Self-Employeed","Public sector","Government Employee", "Private Sector", "Bussiness","Retired", "Student","PSU","Others"};
        occupation = new JComboBox(valoccupation);
        occupation.setFont(new Font("Raleway", Font.PLAIN, 16));
        occupation.setBounds( 300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        
        //______________
        
        JLabel address = new JLabel("PAN Number :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds (100, 440, 150, 20);
        add(address);
        
        pannumber = new JTextField();
        pannumber.setFont( new Font("Raleway", Font.PLAIN, 16));
        pannumber.setBounds(300, 440, 400, 30);
        add(pannumber);
        
        //____________
        
        JLabel city = new JLabel("Aadhar :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds (100, 540, 150, 20);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont( new Font("Raleway", Font.PLAIN, 16));
        aadhar.setBounds(300, 540, 400, 25);
        add(aadhar);
        
        //_________
        
        JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds (100, 490, 150, 25);
        add(state);
        
        syes = new JRadioButton ("YES");
        syes.setBounds(300,490,120,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton ("NO");
         sno.setBounds(450,490,120,30);
         sno.setBackground(Color.white);
        add( sno);
        
        ButtonGroup seniority = new ButtonGroup();
        seniority.add(syes);
        seniority.add(sno);
       //___________ 
        
        JLabel pincode = new JLabel("Existing Account :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds (100, 590, 180, 25);
        add(pincode);
        
        eayes = new JRadioButton ("YES");
        eayes.setBounds(300,590,120,30);
        eayes.setBackground(Color.white);
        add(eayes);
        
        eano = new JRadioButton ("NO");
         eano.setBounds(450,590,120,30);
         eano.setBackground(Color.white);
        add( eano);
        
        ButtonGroup exisitingaccount = new ButtonGroup();
        exisitingaccount.add(eano);
        exisitingaccount.add(eayes);
      
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
    
        String sreligion = (String)religion.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String Senior = null;
        
        if(syes.isSelected())
            Senior = "Yes";
        else if (sno.isSelected())
            Senior ="No";
        
        String exisiting = null;
        if (eayes.isSelected())
             exisiting="Yes";
        else if (eano.isSelected())
            exisiting ="No";
        
        String span = pannumber.getText();
        String saadhar = aadhar.getText();
        
        
        try {
                Conn c = new Conn();
                String query ="insert into signup2 value('"+formno+"' ,'"+sreligion+"' ,'"+scategory+"' ,'"+sincome+"' ,'"+seducation+"' ,'"+soccupation+"' ,'"+Senior+"','"+saadhar+"' ,'"+span+"' ,'"+exisiting+"')";
                c.s.executeUpdate(query); 
            
        }catch (Exception e)
        {System.out.println(e);}
         if (ae.getSource() == next)
        {
            setVisible(false);
            new Signup3(formno).setVisible(true);
        }
    }
    
    public static void main (String args[])
    {
        new Signup2("");
    }
}

