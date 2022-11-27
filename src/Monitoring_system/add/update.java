package Monitoring_system.add;

import javax.swing.*;

import Monitoring_system.Teach;
import Monitoring_system.conn;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class update extends JFrame implements ActionListener {

    JLabel l1,la1,la2,la3,la4,la5,la6,la7,la8,la9,la10;
    JTextField gr,p1,c1,m1,mech,bee,dr,cp,p2,c2,m2;
    JButton b1,b2,back;
    JScrollPane s1,s2;
    JTable t1,t2;
    JTabbedPane tab;

    public Font f1 = new Font("Tahoma", Font.PLAIN, 16);

    public update() {
        setSize(1050, 650);

        l1 = new JLabel("Enter GR No. ");
        l1.setBounds(60, 20, 100, 50);
        l1.setFont(f1);
        l1.setForeground(Color.white);
        add(l1);

        gr = new JTextField();
        gr.setBounds(170, 30, 100, 40);
        add(gr);

        //updation labels


        la1 = new JLabel("PHY-1 ");
        la1.setBounds(60, 200, 100, 50);
        la1.setFont(f1);
        la1.setForeground(Color.white);
        add(la1);

        la2 = new JLabel("CHEM-1 ");
        la2.setBounds(60, 250, 100, 50);
        la2.setFont(f1);
        la2.setForeground(Color.white);
        add(la2);

        la3 = new JLabel("MATH-1 ");
        la3.setBounds(60, 300, 100, 50);
        la3.setFont(f1);
        la3.setForeground(Color.white);
        add(la3);

        la4 = new JLabel("MECH ");
        la4.setBounds(60, 350, 100, 50);
        la4.setFont(f1);
        la4.setForeground(Color.white);
        add(la4);


        la5 = new JLabel("BEE ");
        la5.setBounds(60, 400, 100, 50);
        la5.setFont(f1);
        la5.setForeground(Color.white);
        add(la5);

        la6 = new JLabel("PHY-2 ");
        la6.setBounds(550, 200, 100, 50);
        la6.setFont(f1);
        la6.setForeground(Color.white);
        add(la6);

        la7 = new JLabel("CHEM-2 ");
        la7.setBounds(550, 250, 100, 50);
        la7.setFont(f1);
        la7.setForeground(Color.white);
        add(la7);

        la8 = new JLabel("MATH-2");
        la8.setBounds(550, 300, 100, 50);
        la8.setFont(f1);
        la8.setForeground(Color.white);
        add(la8);

        la9 = new JLabel("DRAWiNG ");
        la9.setBounds(550, 350, 100, 50);
        la9.setFont(f1);
        la9.setForeground(Color.white);
        add(la9);

        la10 = new JLabel("CP ");
        la10.setBounds(550, 400, 100, 50);
        la10.setFont(f1);
        la10.setForeground(Color.white);
        add(la10);

//upadtion text fields
        p1 = new JTextField();
        p1.setBounds(200, 200, 100, 40);
        add(p1);

        c1 = new JTextField();
        c1.setBounds(200, 250, 100, 40);
        add(c1);

        m1 = new JTextField();
        m1.setBounds(200, 300, 100, 40);
        add(m1);

        mech = new JTextField();
        mech.setBounds(200, 350, 100, 40);
        add(mech);

        bee = new JTextField();
        bee.setBounds(200, 400, 100, 40);
        add(bee);

        p2 = new JTextField();
        p2.setBounds(700, 200, 100, 40);
        add(p2);

        c2 = new JTextField();
        c2.setBounds(700, 250, 100, 40);
        add(c2);

        m2 = new JTextField();
        m2.setBounds(700, 300, 100, 40);
        add(m2);

        dr = new JTextField();
        dr.setBounds(700, 350, 100, 40);
        add(dr);

        cp = new JTextField();
        cp.setBounds(700, 400, 100, 40);
        add(cp);


        b1 = new JButton("DISPLAY");
        b1.setBounds(360, 30, 100, 40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("UPDATE");
        b2.setBounds(450, 500, 100, 40);
        b2.addActionListener(this);
        add(b2);

        s1 = new JScrollPane();
        s2 = new JScrollPane();

        tab = new JTabbedPane();
        tab.setBounds(65, 90, 900, 70);
        tab.add("SEM1", s1);
        tab.add("SEM2", s2);
        add(tab);

        t1 = new JTable();
        s1.setViewportView(t1);

        t2 = new JTable();
        s2.setViewportView(t2);


        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/7.png"));
        Image i4 = i2.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i4);
        back = new JButton(i3);
        back.setBounds(0,0,50,50);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/5.jpg"));
        JLabel im1 = new JLabel(i1);
        im1.setBounds(0,0,1050,650);
        add(im1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }




    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String gr = this.gr.getText();
            try{
                conn c = new conn();
                String str1 = "select  Gr, Name, P1, C1, M1, Mech, BEE  from details where Gr = '"+gr+"';";
                ResultSet rs1 = c.s.executeQuery(str1);
                t1.setModel(DbUtils.resultSetToTableModel(rs1));

                String str2 = "select  Gr, Name, P2, C2, M2, Drawing, CP from details  where Gr = '"+gr+"';";
                ResultSet rs2 = c.s.executeQuery(str2);
                t2.setModel(DbUtils.resultSetToTableModel(rs2));

            }catch (Exception e){
                System.out.println(e);
            }
        }
/////////////to get text in text box Already!!


        if(ae.getSource()==b1){
            String gr = this.gr.getText();
            try{
                conn c = new conn();
                String str1 = "select   P1 , C1 , M1 , Mech , BEE  from details where Gr = '"+gr+"';";
                ResultSet rs1 = c.s.executeQuery(str1);


                while (rs1.next()) {
//                    String s = rs1.getString("p1");
//                    int n = rs1.getInt("P1");
//                    System.out.println(s + "   " + n);
                    String p = rs1.getString("p1");
                    String C = rs1.getString("C1");
                    String m = rs1.getString("M1");
                    String me = rs1.getString("Mech");
                    String b = rs1.getString("BEE");
                    p1.setText(p);
                    c1.setText(C);
                    m1.setText(m);
                    mech.setText(me);
                    bee.setText(b);
                }


                String str2 = "select  Gr, Name, P2, C2, M2, Drawing, CP from details  where Gr = '"+gr+"';";
                ResultSet rs2 = c.s.executeQuery(str2);

                //pehelehi textbox me value add karne ke liye

                while (rs2.next()) {
                    String p = rs2.getString("P2");
                    String C = rs2.getString("C2");
                    String m = rs2.getString("M2");
                    String me = rs2.getString("Drawing");
                    String b = rs2.getString("CP");
                    p2.setText(p);
                    c2.setText(C);
                    m2.setText(m);
                    dr.setText(me);
                    cp.setText(b);
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }


        if(ae.getSource()==b2){
            String gr = this.gr.getText();
            String p1 = this.p1.getText();
            String c1 = this.c1.getText();
            String m1 = this.m1.getText();
            String p2 = this.p2.getText();
            String c2 = this.c2.getText();
            String m2 = this.m2.getText();
            String mech = this.mech.getText();
            String bee = this.bee.getText();
            String dr = this.dr.getText();
            String cp = this.cp.getText();
          //  String avg = (p1+c1+m1+bee+mech) / 5;


            try {
                conn c = new conn();
                String str1 = "update details set P1 = '" + p1 + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str1);

                String str2 = "update details set C1 = '" + c1 + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str2);

                String str3 = "update details set M1 = '" + m1 + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str3);

                String str4 = "update details set P2 = '" + p2 + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str4);

                String str5 = "update details set C2 = '" + c2 + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str5);

                String str6 = "update details set M2 = '" + m2 + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str6);

                String str7 = "update details set Mech = '" + mech + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str7);

                String str8 = "update details set Drawing = '" + dr + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str8);

                String str9 = "update details set BEE = '" + bee + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str9);

                String str10 = "update details set CP = '" + cp + "' where Gr = '" + gr + "';";
                c.s.executeUpdate(str10);
                int pe1 = 0;
                int ch1 = 0;
                int ma1 = 0;
                int mh = 0;
                int be = 0;
                pe1 = Integer.parseInt(p1);
                ma1 = Integer.parseInt(m1);
                ch1 = Integer.parseInt(c1);
                mh = Integer.parseInt(mech);
                be = Integer.parseInt(bee);
                int avg1 = (pe1 + ma1 + ch1+mh+be)/5;

                System.out.println(ma1);

           String stra = "update details set Average1 = '"+avg1+"' where Gr = '"+gr+"';";
           c.s.executeUpdate(stra);


                int pe2 = 0;
                int ch2 = 0;
                int ma2 = 0;
                int drw = 0;
                int cpp = 0;
                pe2 = Integer.parseInt(p2);
                ma2 = Integer.parseInt(m2);
                ch2 = Integer.parseInt(c2);
                drw = Integer.parseInt(dr);
                cpp = Integer.parseInt(cp);
                int avg2 = (pe2+ma2+ch2+drw+cpp)/5;

                System.out.println(ma1);

                String strb = "update details set Average2 = '"+avg2+"' where Gr = '"+gr+"';";
                c.s.executeUpdate(strb);


                JOptionPane.showMessageDialog(null, "DATA UPDATED SUCCFULLY!!");

            }catch (Exception e){
            System.out.println(e);
        }
        }
        if(ae.getSource()==back){
            new Teach();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new update();

    }

}
