/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseEntitates;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faruk
 */
public class Employee {
    
    
    private SimpleIntegerProperty employeeId;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty employeeName;
    private SimpleStringProperty employeeLastName;
    private SimpleStringProperty employeeLevel;
    private SimpleStringProperty isAdmin;

    public Employee() {
    }

    
    
    public Employee(int id,String username, String password, String employeeName, String employeeLastName, String employeeLevel, String isAdmin) {
        this.employeeId = new SimpleIntegerProperty(id);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.employeeName = new SimpleStringProperty(employeeName);
        this.employeeLastName = new SimpleStringProperty(employeeLastName);
        this.employeeLevel = new SimpleStringProperty(employeeLevel);
        this.isAdmin = new SimpleStringProperty(isAdmin);
    }

    public int getEmployeeId() {
        return employeeId.get();
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmployeeName() {
        return employeeName.get();
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName.set(employeeName);
    }

    public String getEmployeeLastName() {
        return employeeLastName.get();
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName.set(employeeLastName);
    }

    public String getEmployeeLevel() {
        return employeeLevel.get();
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel.set(employeeLevel);
    }

    public String getIsAdmin() {
        return isAdmin.get();
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin.set(isAdmin);
    }
    
    
    
    
    
}
