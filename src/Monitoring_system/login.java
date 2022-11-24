package Monitoring_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;



public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField username;
    JPasswordField password;
    JButton signin,login,cancel;
    Font f1 = new Font("Tahoma", Font.PLAIN, 16);

    login()
    {

        setSize(500,400);

        l1 =new JLabel("Username");
        l1.setBounds(40,50,100,40);
        l1.setFont(f1);
        add(l1);

         l2 =new JLabel("Password");
        l2.setBounds(40, 120, 100, 40);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l2);

        username = new JTextField();
        username.setBounds(150,50,150,40);
        add(username);

       password = new JPasswordField();
        password.setBounds(150,120,150,40);
        add(password);

        login = new JButton("log in");
        login.setBounds(100,260,120,50);
        login.setFont(f1);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("cancel");
        cancel.setBounds(280,260,120,50);
        cancel.setFont(f1);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/2.jpeg"));
        JLabel im1 = new JLabel(i1);
        im1.setBounds(0,0,500,400);
        add(im1);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource()==cancel)
        {
            setVisible(false);
        }
        if (ae.getSource()==login)
        {
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            conn c = new conn();

            try{
                String str1= "select * from loginid where USERNAME = '"+username+"' and PASSWORD  = '"+password+"';";
                ResultSet rs = c.s.executeQuery(str1);

                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Succfull!!!");
                    new firsttab();

                }
                else {
                    JOptionPane.showMessageDialog(null , "Invalid Login Credentials!!");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

    }



    public static void main(String []args)
    {
        new login();
    }


}
