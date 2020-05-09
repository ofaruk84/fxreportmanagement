/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseAccess;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Customer;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Faruk
 */
public class CustomerDal {


private Customer customer;
private DBHelper dbHelper;
private Connection connection;  



public CustomerDal(){
    
    customer = new Customer();
    dbHelper = new DBHelper();
    try {
        establishConnection();
    } catch (SQLException ex) {
       dbHelper.showErrorMessage(ex);
    }
         
        
  }

public void establishConnection() throws SQLException{
     
    try {
       connection = dbHelper.getConecConnection();
        System.out.println("Connection Established");
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    }

   
     
 }

//Add Customer
public void addCustomer(Customer customer){
        
    String sqlQuery ="insert into customer (customerName,customerCity,customerCountry) values(?,?,?)";
      
       try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1,customer.getCustomerName());
            statement.setString(2, customer.getCustomerCity());
            statement.setString(3,customer.getCustomerCountry());

            statement.executeUpdate();
      }catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
            } 
  
    }


//Delete Customer
public void delete(int id){
    
    String sqlQuery ="delete from customer where employeeId = ?";
      
    try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1,id);

        statement.executeUpdate();
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    } 


}

//Update Customer
public void update(int index,Customer customer){

   String sqlQuery ="update employee set customerName = ?,customerCity = ?,customerCountry = ? where customerId =?";
      
   try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1,customer.getCustomerName());
        statement.setString(2, customer.getCustomerCity());
        statement.setString(3,customer.getCustomerCountry());
        statement.setInt(4, index);
        
        statement.executeUpdate();
    }catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    }         
        
        
}


//Get Data from Customer Table
public ObservableList<Customer> getData(){
     
   ObservableList<Customer> oblist = FXCollections.observableArrayList();
   String sqlQuery ="select * from customer";
     
   try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            oblist.add(new Customer(Integer.parseInt(rs.getString("customerId")), rs.getString("customerName"), 
                    rs.getString("customerCity"), rs.getString("customerCountry")));
        }
        
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    }
    return oblist;    
        
    }

    //Get CustomerName
    public ObservableList<String> getCustomerName() {

        ObservableList<String> oblist = FXCollections.observableArrayList();
        String sqlQuery = "select customerName from customer";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                oblist.add(rs.getString("customerName"));
            }

        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }
        return oblist;

    }
    
    //Get Information Of Selected Customer
    public Customer getCustomerCity(String customerName) {

        String query = "select customerCity from customer where customerName = ?";

        Customer customer = null;
        PreparedStatement statement;
        try {

            statement = connection.prepareStatement(query);

            statement.setString(1, customerName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                customer = new Customer(rs.getString("customerCity"));}
            } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }

        return customer;
    }
    
    }  



