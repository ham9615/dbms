/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms.SQLConnectionFile;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADI
 */
public class sqlConnection {
    

        
        Connection conn=null;
        static Connection database_conn;
        public static Connection ConnectDb1() throws SQLException{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
                System.out.println("Connection Completed");
                return conn;
                
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(sqlConnection.class.getName()).log(Level.SEVERE, null, ex);
               return null;
           }

    /*public static void main(String[] argv) {

	makeconn();
           
        
    }
   static void makeconn(){
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}

	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;

	try {
		connection = (Connection) DriverManager
		.getConnection("jdbc:mysql://localhost:3306/f1db","root", "akshatrai");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }*/
   
}
}
 

    
    

