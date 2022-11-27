package Monitoring_system;

import Monitoring_system.add.Add_details;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class firsttab extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2, updatepr;

    public firsttab()
    {
        setSize(800,400);



        l1 = new JLabel("COLLEGE DATABASE MANAGEMENT ");
        l1.setBounds(175,10,500,100);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        l1.setForeground(Color.white);
        add(l1);

        b1 = new JButton("ADD NEW STUDENT DETAILS");
        b1.setBounds(250,100,250,50);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("MARKS SECTION");
        b2.setBounds(275,180,190,50);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        b2.addActionListener(this);
        add(b2);

        updatepr = new JButton(" EDIT / UPDATE PROFILE");
        updatepr.setBounds(250,250,250,50);
        updatepr.setFont(new Font("Tahoma", Font.PLAIN, 15));
        updatepr.addActionListener(this);
        add(updatepr);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/1.jpg"));
        JLabel im1 = new JLabel(i1);
        im1.setBounds(0,0,800,400);
        add(im1);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource()==b1)
        {
            new Add_details();
            setVisible(false);}

         if(ae.getSource()==b2)
        {
            new Teach();
            setVisible(false);
        }
        if (ae.getSource()==updatepr){
            new updateprofile();
            setVisible(false);
        }
    }




    public static void main(String []args)
    {
        new firsttab();
    }

}
