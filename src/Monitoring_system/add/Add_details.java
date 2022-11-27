package Monitoring_system.add;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import Monitoring_system.Teach;
import Monitoring_system.conn;
import Monitoring_system.firsttab;
import com.toedter.calendar.JDateChooser;


public class Add_details  extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField name, adhaar, gr, addr, contact, college, age;
//    String gender;

    JRadioButton male, female;
    JDateChooser dob;
    JButton addData, cancel,back;


    //size variables
    int labX = 60;
    int labH = 50;
    int labW = 100;
    int textX = 200;
    int textH = 40;
    int textW = 150;
    Font f1 = new Font("Tahoma", Font.PLAIN, 16);

   public Add_details()
    {
        setSize(500, 800);

        l1 = new JLabel("Name");
        l1.setBounds(labX, 40, labW, labH);
        l1.setFont(f1);
        add(l1);

        l2 = new JLabel("DOB");
        l2.setBounds(labX, 100, labW, labH);
        l2.setFont(f1);
        add(l2);

        l3 = new JLabel("Age");
        l3.setBounds(labX, 160, labW, labH);
        l3.setFont(f1);
        add(l3);

        l4 = new JLabel("Gender");
        l4.setBounds(labX, 220, labW, labH);
        l4.setFont(f1);
        add(l4);

        l5 = new JLabel("Address");
        l5.setBounds(labX, 280, labW, labH);
        l5.setFont(f1);
        add(l5);

        l6 = new JLabel("Aadhaar");
        l6.setBounds(labX, 340, labW, labH);
        l6.setFont(f1);
        add(l6);

        l7 = new JLabel("Contact");
        l7.setBounds(labX, 400, labW, labH);
        l7.setFont(f1);
        add(l7);

        l8 = new JLabel("Gr No.");
        l8.setBounds(labX, 460, labW, labH);
        l8.setFont(f1);
        add(l8);



        //textfields


        name = new JTextField();
        name.setBounds(textX, 40, textW, textH);
        add(name);

        dob = new JDateChooser();
        dob.setBounds(textX, 100, textW, textH);
        add(dob);

        age = new JTextField();
        age.setBounds(textX, 160, textW, textH);
        add(age);

        addr = new JTextField();
        addr.setBounds(textX, 280, textW, textH);
        add(addr);

        adhaar = new JTextField();
        adhaar.setBounds(textX, 340, textW, textH);
        add(adhaar);

        contact = new JTextField();
        contact.setBounds(textX, 400, textW, textH);
        add(contact);

        gr = new JTextField();
        gr.setBounds(textX, 460, textW, textH);
        add(gr);

        //Jbutton

        ButtonGroup b1 = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(textX, 220, 60, textH);
        male.setFont(f1);
        this.add(male);
        b1.add(male);

        female = new JRadioButton("Female");
        female.setBounds(260, 220, textW, textH);
        female.setFont(f1);
        this.add(female);
        b1.add(female);

        //buttons

        addData = new JButton("Add Data");
        addData.setBounds(120, 620, 100, 40);
        addData.addActionListener(this);
        this.add(addData);


        cancel = new JButton("cancel");
        cancel.setBounds(280, 620, 100, 40);
        cancel.setFont(f1);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/7.png"));
        Image i4 = i2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i4);
        back = new JButton(i3);
        back.setBounds(0,0,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/4.jpeg"));
        JLabel im1 = new JLabel(i1);
        im1.setBounds(0,0,500,800);
        add(im1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void actionPerformed (ActionEvent ae)
    {

        if (ae.getSource() == cancel) {
            this.setVisible(false);


        } else if (ae.getSource() == addData) {
            String name = this.name.getText();
            String age = this.age.getText();
            String addr = this.addr.getText();
            String adhaar = this.adhaar.getText();
            String gr = this.gr.getText();
            String contact = this.contact.getText();
            //for storing date

            SimpleDateFormat dateformate = new SimpleDateFormat("dd-MM-yy");
            String dob = dateformate.format(this.dob.getDate());
            String gender = null;
            if (this.male.isSelected()) {
                gender = "Male";
            } else if (this.female.isSelected()) {
                gender = "Female";
            }

            conn c = new conn();

            String str = "insert into details (Name, Age, Addr, Adhaar, Gr, Contact, Dob, Gender) values ('"+name+"', '"+age+"', '"+addr+"', '"+adhaar+"', '"+gr+"', '"+contact+"', '"+dob+"', '"+gender+"');";

            try {

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"DATA ADDED SUCCESSFULLY!!");


            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==back){
            new firsttab();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Add_details();
    }
}

