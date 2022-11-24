package Monitoring_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateprofile extends JFrame implements ActionListener {

    JLabel l1, l2 ,l3,l4;
    JTextField gr, data;
    JButton disp , submit;
    JComboBox fileds;
    JTable t1;
    JScrollPane sp1;
    String[] list = {"Name" , "Age" , "Addr" , "Dob" , "Adhaar" , "Contact" , "Gender" };

    updateprofile(){
        setSize(900,600);

        l1 = new JLabel(" GR number ");
        l1.setBounds(80,40,150,50);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setForeground(Color.black);
        add(l1);

        gr=new JTextField();
        gr.setBounds(250,40,150,40);
        add(gr);

        disp = new JButton("display ");
        disp.setBounds(450,40,100,40);
        disp.addActionListener(this);
        add(disp);

        sp1 = new JScrollPane();
        sp1.setBounds(50,160,770,60);
        add(sp1);

        t1= new JTable();
        sp1.setViewportView(t1);

        l2 = new JLabel("CHOOSE FIELDS ");
        l2.setBounds(80,300,150,50);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setForeground(Color.black);
        add(l2);

         fileds = new JComboBox(list);
         fileds.setBounds(300,300,150,40);
         add(fileds);

         l3=new JLabel("Updated Value");
         l3.setBounds(80,380,150,50);
         l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setForeground(Color.black);
         add(l3);

         data = new JTextField();
         data.setBounds(300,380,150,40);
         add(data);

         submit = new JButton( "UPDATE DATA");
         submit.setBounds(400,450,140,50);
         submit.addActionListener(this);
         add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/3.png"));
        JLabel im1 = new JLabel(i1);
        im1.setBounds(0,0,900,600);
        add(im1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==disp){
            String gr = this.gr.getText();
            conn c =new conn();
            try{
                String str = " select Name , Age , Addr , Dob , Adhaar , Contact , Gender from details where Gr = '"+gr+"';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource()==submit){
            String gr = this.gr.getText();
            String value = this.data.getText();
            String choice = fileds.getSelectedItem().toString();

           conn c = new conn();
           try{
               String str = "update details set "+choice+"= '"+value+"' where Gr = '"+gr+"';";
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"DATA UPDATED SUCCFULLY!!");
           }
           catch (Exception e){
               System.out.println(e);
           }

        }
    }

    public static void main(String[] args) {
        new updateprofile();
    }
}
