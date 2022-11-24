package Monitoring_system;


import Monitoring_system.add.update;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


public class Teach extends JFrame implements ActionListener  {
    JLabel instr;
    JButton edit,search,refresh,marks;
    JScrollPane sp1,sp2;
    JTable sem1,sem2;
    JTabbedPane tabs;

   public Font f1 = new Font("Tahoma", Font.PLAIN, 16);
    Font f2 = new Font("Tahoma", Font.PLAIN, 14 );


    public Teach(){
        setSize(1050,500);

//        instr = new JLabel("DOUBLE TAP ON THE COLUMN TO SELECT THE ROW AND PRESS UPDATE TO UPDATE IT!!");
//        instr.setBounds(150,290,650,80);
//        instr.setFont(f1);
//        add(instr);

        edit = new JButton("Edit / Update");
        edit.setBounds(60 , 370 , 150,50);
        edit.setFont(f2);
        edit.addActionListener(this);
        add(edit);

//        marks = new JButton("PASS / FAIL");
//        marks.setBounds(450,370,150,50);
//        marks.setFont(f2);
//        add(marks);

        refresh =new JButton("REFRESH");
        refresh.setBounds(850 ,370, 100 ,50);
        refresh.setFont(f2);
        refresh.addActionListener(this);
        add(refresh);

        sp1 = new JScrollPane();
        sp2 = new JScrollPane();

        tabs = new JTabbedPane();
        tabs.setBounds(45,40,950,250);
        tabs.add("SEM 1", sp1);
        tabs.add("SEM 2", sp2);
        add(tabs);

        sem1 = new JTable();
        sp1.setViewportView(sem1);

        sem2 = new JTable();
        sp2.setViewportView(sem2);

        try{
            conn c = new conn();
            String str1 = "select  Gr, Name, Dob, P1, C1, M1, Mech, BEE from details;";
            ResultSet rs1 = c.s.executeQuery(str1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs1));

            String str2 = "select  Gr, Name, P2, C2, M2, Drawing, CP from details;";
            ResultSet rs2 = c.s.executeQuery(str2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs2));

        }catch (Exception e){
            System.out.println(e);
        }



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/6.jpg"));
        JLabel im1 = new JLabel(i1);
        im1.setBounds(0,0,1050,500);
        add(im1);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==edit){
            new update();
        }
        if(ae.getSource()==refresh){
            try{
                conn c = new conn();
                String str1 = "select  Gr, Name, Dob, P1, C1, M1, Mech, BEE from details;";
                ResultSet rs1 = c.s.executeQuery(str1);
                sem1.setModel(DbUtils.resultSetToTableModel(rs1));

                String str2 = "select  Gr, Name, P2, C2, M2, Drawing, CP from details;";
                ResultSet rs2 = c.s.executeQuery(str2);
                sem2.setModel(DbUtils.resultSetToTableModel(rs2));

            }catch (Exception e){
                System.out.println(e);
            }
        }


   }
    public static void main(String[] args) {
        new Teach();
    }



}
