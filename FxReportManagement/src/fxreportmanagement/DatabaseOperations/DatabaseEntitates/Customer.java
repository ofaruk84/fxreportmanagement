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
public class Customer {
    
    private SimpleIntegerProperty customerId;
    private SimpleStringProperty customerName;
    private SimpleStringProperty customerCity;
    private SimpleStringProperty customerCountry;

    public Customer() {
    }

    public Customer(int customerId,String customerName,String customerCity,String customerCountry){
        this.customerId =  new SimpleIntegerProperty(customerId);
        this.customerName = new SimpleStringProperty(customerName);
        this.customerCity = new  SimpleStringProperty(customerCity);
        this.customerCountry = new SimpleStringProperty(customerCountry);
    }

    public int getCustomerId() {
        return customerId.getValue();
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public String getCustomerName() {
        return customerName.getValue();
    }

    public void setCustomerName(String customerName) {
        this.customerName.setValue(customerName);
    }

    public String getCustomerCity() {
        return customerCity.getValue();
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity.setValue(customerCity);
    }

    public String getCustomerCountry() {
        return customerCountry.getValue();
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry.setValue(customerCountry);
    }
    
    
    
    
    









}


