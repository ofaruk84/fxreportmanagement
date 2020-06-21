/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseAccess;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz
 * 170503014
 */
public class EmployeeDal {

    private Employee employee;
    private DBHelper dbHelper;
    private Connection connection;

    public EmployeeDal() {

        employee = new Employee();
        dbHelper = new DBHelper();
        try {
            establishConnection();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }
    //Establish Connection

    public void establishConnection() throws SQLException {

        try {
            connection = dbHelper.getConecConnection();
            System.out.println("Connection Established");
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }
    //Log In

    public ResultSet logIn(String username, String password) {

        ResultSet resultSet = null;
        String sqlQuery = "Select username,password From employee Where username = ? and password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

        return resultSet;
    }

    //Log In as Admin
    public ResultSet logInAsAdmin(String username, String password) {

        ResultSet resultSet = null;
        String sqlQuery = "Select username,password From employee Where username = ? and password = ? and isAdmin = 1";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

        return resultSet;
    }

    //Verify Login
    public boolean verifyLogin(ResultSet rs) throws SQLException {

        boolean result = true;

        if (!(rs.next())) {
            result = false;
        }

        return result;
    }

    //Add Employee
    public void addEmployee(Employee e) {

        String sqlQuery = "insert into employee (username,password,employeeName,employeeLastName,employeeLevel,isAdmin) values(?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, e.getUsername());
            statement.setString(2, e.getPassword());
            statement.setString(3, e.getEmployeeName());
            statement.setString(4, e.getUsername());
            statement.setString(5, e.getEmployeeLevel());
            statement.setString(6, e.getIsAdmin());

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Delete Employee
    public void delete(int id) {
        String sqlQuery = "delete from employee where employeeId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Update Employee
    public void update(int index, Employee e) {

        String sqlQuery = "update employee set username = ?,password = ?,employeeName = ?,employeeLastName = ?,employeeLevel = ?,isAdmin = ? where employeeId =?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, e.getUsername());
            statement.setString(2, e.getPassword());
            statement.setString(3, e.getEmployeeName());
            statement.setString(4, e.getUsername());
            statement.setString(5, e.getEmployeeLevel());
            statement.setString(6, e.getIsAdmin());
            statement.setInt(7, index);

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Get Data from Employee Table
    public ObservableList<Employee> getData() {

        ObservableList<Employee> oblist = FXCollections.observableArrayList();
        String sqlQuery = "select * from employee";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                oblist.add(new Employee(Integer.parseInt(rs.getString("employeeId")), rs.getString("username"),
                        rs.getString("password"), rs.getString("employeeName"), rs.getString("employeeLastName"),
                        rs.getString("employeeLevel"), rs.getString("isAdmin")));
            }

        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }
        return oblist;

    }

    //Get Employee Name
    public ObservableList<String> getEmployeeName() {

        String name;
        ObservableList<String> oblist = FXCollections.observableArrayList();;

        String sqlQuery = "SELECT employeeName,employeeLastName FROM employee";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                name = rs.getString("employeeName") + " " + rs.getString("employeeLastName");

                oblist.add(name);

            }

        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

        return oblist;

    }

    //Get Level
    public String getLevel(String name){

        String level = "";
        String sqlQuery = "SELECT employeeLevel FROM employee where employeeName = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                level = rs.getString("employeeLevel");

            }

        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

        return level;

    }
}