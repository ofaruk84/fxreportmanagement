/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Login.AdminLogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EmployeeDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Employee;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class AdminEmployeePageFxmlController implements Initializable {

    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private JFXTextField txtLastName;
    @FXML
    private JFXTextField txtLevel;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXTextField txtAdmin;
    
    @FXML
    private TableView<Employee> tbvEmployee;
    @FXML
    private TableColumn<Employee,SimpleIntegerProperty> tcId;
    @FXML
    private TableColumn<Employee,SimpleStringProperty>  tcUsername;
    @FXML
    private TableColumn<Employee,SimpleStringProperty> tcPassword;
    @FXML
    private TableColumn<Employee,SimpleStringProperty> tcFirstName;
    @FXML
    private TableColumn<Employee,SimpleStringProperty> tcLastName;
    @FXML
    private TableColumn<Employee,SimpleStringProperty> tcLevel;
    @FXML
    private TableColumn<Employee,SimpleStringProperty> tcAdminStatus;
 
    private EmployeeDal employeeDal;
    
    private Employee employee;
    
    private static ObservableList<Employee> oblist; 
    
    private int index=0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        employeeDal = new EmployeeDal();
        populateTable();
        
    }    
    
    //Add Button
    @FXML
    private void handleBtnAdd(ActionEvent event) {
        
        employeeDal.addEmployee(getEmployee());
        populateTable();
        
        
        
    }
    //Delete Button
    @FXML
    private void handleBtnDelete(ActionEvent event) {
        
        employeeDal.delete(index);
        populateTable();
        
        
    }
    //Update Button
    @FXML
    private void handleBtnUpdate(ActionEvent event) {
        employee = getEmployee();
        employeeDal.update(index, employee);
        populateTable();
        
    }
    
    
    //Get Clicked Row Action
    @FXML
    private void handleGetClickedRow(MouseEvent event) {
        
        employee = tbvEmployee.getSelectionModel().getSelectedItem();
        
        txtUsername.setText(employee.getUsername());
        txtPassword.setText(employee.getPassword());
        txtFirstName.setText(employee.getEmployeeName());
        txtLastName.setText(employee.getEmployeeLastName());
        txtLevel.setText(employee.getEmployeeLevel());
        txtAdmin.setText(employee.getIsAdmin());
        
        
        
        index = employee.getEmployeeId();
    }
    
    
    
    //Get Employee From GUI
    public Employee getEmployee(){
     
     int id=index;
     String username = txtUsername.getText();
     String password = txtPassword.getText();
     String employeeName = txtFirstName.getText();
     String employeeLastName = txtLastName.getText();
     String employeeLevel =txtLevel.getText();
     String isAdmin = txtAdmin.getText();
     
     return new Employee(id,username, password, employeeName, employeeLastName, employeeLevel, isAdmin);
        
    }
    
    
    
    
 
    
    //Populating Table
    public void populateTable(){
        
     tcId.setCellValueFactory(new PropertyValueFactory<Employee,SimpleIntegerProperty>("employeeId"));
     tcUsername.setCellValueFactory(new PropertyValueFactory<Employee,SimpleStringProperty>("username"));
     tcPassword.setCellValueFactory(new PropertyValueFactory<Employee,SimpleStringProperty>("password"));
     tcFirstName.setCellValueFactory(new PropertyValueFactory<Employee,SimpleStringProperty>("employeeName"));        
     tcLastName.setCellValueFactory(new PropertyValueFactory<Employee,SimpleStringProperty>("employeeLastName"));
     tcLevel.setCellValueFactory(new PropertyValueFactory<Employee,SimpleStringProperty>("employeeLevel"));        
     tcAdminStatus.setCellValueFactory(new PropertyValueFactory<Employee,SimpleStringProperty>("isAdmin")); 
     
     oblist = employeeDal.getData();
     
     tbvEmployee.setItems(oblist);
    }






}
