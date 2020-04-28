/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Login.AdminLogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.CustomerDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class AdminCustomerPageFxmlController implements Initializable {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtCity;
    @FXML
    private JFXTextField txtCountry;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<Customer> tbvCustomer;
    @FXML
    private TableColumn<Customer,SimpleIntegerProperty> tcId;
    @FXML
    private TableColumn<Customer, SimpleStringProperty> tcName;
    @FXML
    private TableColumn<Customer,SimpleStringProperty> tcCity;
    @FXML
    private TableColumn<Customer, SimpleStringProperty> tcCountry;
    
    private static ObservableList<Customer> oblist;
    private CustomerDal customerDal;
    private Customer customer;
    private int index=0;
   
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        oblist = FXCollections.observableArrayList();
        customerDal = new CustomerDal();
        populateTable();
    }    
    
    //Add Customer
    @FXML
    private void handleBtnAdd(ActionEvent event) {
        
        customerDal.addCustomer(getCustomer());
        populateTable();
    }
    
    //Deşete Customer
    @FXML
    private void handleBtnUpdate(ActionEvent event) {
        
        customerDal.update(index, getCustomer());
        populateTable();
        
    }

    @FXML
    private void handleBtnDelete(ActionEvent event) {
        
        customerDal.delete(index);
        populateTable();
    }
    
    
    //Get Clicked Row Action
    @FXML
    private void handleGetClickedRow(MouseEvent event) {
        
        customer = tbvCustomer.getSelectionModel().getSelectedItem();
        
        txtName.setText(customer.getCustomerName());
        txtCity.setText(customer.getCustomerCity());
        txtCountry.setText(customer.getCustomerCountry());
        
        index = customer.getCustomerId();
    }
    
    //Get Customer
    public Customer getCustomer(){
        
        int id = index;
        String customerName = txtName.getText();
        String customerCity = txtCity.getText();
        String customerCountry = txtCountry.getText();
        
        return new Customer(id, customerName, customerCity, customerCountry);
        
    }
    
    
    //Populating Table
    
    public void populateTable(){
        
        tcId.setCellValueFactory(new PropertyValueFactory<Customer,SimpleIntegerProperty>("customerId"));
        tcName.setCellValueFactory(new PropertyValueFactory<Customer,SimpleStringProperty>("customerName"));
        tcCity.setCellValueFactory(new PropertyValueFactory<Customer,SimpleStringProperty>("customerCity"));
        tcCountry.setCellValueFactory(new PropertyValueFactory<Customer,SimpleStringProperty>("customerCountry"));
        
        oblist = customerDal.getData();
        tbvCustomer.setItems(oblist);
        
    }
    
}
