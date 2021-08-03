package com.pro.selenium;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.sql.Connection;

import static com.pro.selenium.Base.*;

public class SeleniumDatabaseTesting extends Base {
    private static Connection con;
    static Connection connection = null;                                  // Connection object
    private static Statement statement;                                   // Statement object
    public static String DB_URL = "jdbc:mysql://localhost/spotify";       // Constant for Database URL

    @BeforeTest
    public Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");                   // Database connection
            // Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return con;
    }

    @Test(priority = 1)
    public void get_table_Data() {
        try{
            con = this.getConnection();
            Statement statement = con.createStatement();
            String query = "select * from user";     // Get the contents of userinfo table from DB
            ResultSet res = statement.executeQuery(query);
            System.out.println("*********RESULT********");
            while (res.next())
                {
                    System.out.print("user_id :" +res.getString(1));
                    System.out.print("  user_name :" + res.getString(2));
                    System.out.print("  user_email :" + res.getString(3));
                    System.out.print("  user_password :" + res.getString(3));
                }
        }
        catch(Exception e)
            {
                e.printStackTrace();
            }
    }

   @Test(priority = 2)
   public void insert_table_data() throws ClassNotFoundException, SQLException{
         con = this.getConnection();
         PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?)");
         pst.setInt(1,1900);
         pst.setString(2,"Ghesh");
         pst.setString(3,"mahesh@gmail.com");
         pst.setString(4,"Nag345");
         pst.executeUpdate();
         get_table_Data();
   }

    @Test
    public void update_values_into_table() throws ClassNotFoundException, SQLException{
        con = this.getConnection();
        PreparedStatement pst = con.prepareStatement("UPDATE user SET user_name = ? WHERE user_id = ?");
        pst.setString(1,"Mahesh");
        pst.setInt(2,1900);
        pst.executeUpdate();
        get_table_Data();
    }

    @Test
    public void delete_row_from_table() throws ClassNotFoundException, SQLException{
        con = this.getConnection();
        PreparedStatement pst = con.prepareStatement("DELETE FROM user where user_id = ?");
        pst.setInt(1,1900);
        pst.executeUpdate();
        get_table_Data();
    }


    @AfterTest
    public void tearDown() throws Exception {
        if (connection != null) {
            connection.close();          // Close DB connection
        }
    }
}
