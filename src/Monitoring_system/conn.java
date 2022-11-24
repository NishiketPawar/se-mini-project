package Monitoring_system;

import java.sql.*;


public class conn
{
    Connection c;
    public Statement s;
    public conn()
    {
        String url = "jdbc:mysql://localhost:3306/stddata";
        String username = "root";
        String pasword = "Mangekyosharingan";


        try{
            c = DriverManager.getConnection(url,username,pasword);
            s = c.createStatement();

        }
        catch (Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args) {
        new conn();
    }

}
