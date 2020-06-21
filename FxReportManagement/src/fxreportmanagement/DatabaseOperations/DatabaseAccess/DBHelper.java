/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz
 * 170503014
 */
public class DBHelper {

    private final String userName = "root";
    private final String password = "6642284";
    private final String dbUrl = "jdbc:mysql://localhost:3306/sql_report_management";
    
    
    //Get Connection
    public Connection getConecConnection() throws SQLException {

        return DriverManager.getConnection(dbUrl, userName, password);
    }
    
    //Show Error Message
    public static void showErrorMessage(SQLException exception) {

        System.out.println("Error: " + exception.getMessage());

        System.out.println("Error Code: " + exception.getErrorCode());
    }

}
