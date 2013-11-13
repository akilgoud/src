/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sree harsha
 */
public class connection 
{
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
     static final String DB_URL = "jdbc:mysql://localhost/pcs";
     
     
     //  Database credentials
     static final String USER = "root";
     static final String PASS = "akil";
     public Connection getConnection()
     {
         Connection conn = null;
         Statement stmt = null;
         try
         {
             //STEP 2: Register JDBC driver
             Class.forName("com.mysql.jdbc.Driver");
             //STEP 3: Open a connection
             System.out.println("Connecting to database...");
             conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
             return conn;
         }
         catch(SQLException se)
         {
             //Handle errors for JDBC
             se.printStackTrace();
         }
         catch(Exception e)
         {
             //Handle errors for Class.forName
             e.printStackTrace();
         }
         //System.out.println("Goodbye!");
         return conn;
}//end main
    
}
