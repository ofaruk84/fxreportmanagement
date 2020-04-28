/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Login;

import fxreportmanagement.DatabaseOperations.DatabaseAccess.EmployeeDal;
import fxreportmanagement.HelperClasses.FxmlPageLoader;
import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class LoginFxmlController implements Initializable {

    @FXML
    private AnchorPane ancLogin;
    @FXML
    private AnchorPane ancLeftSide;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblMessage;
    
    private EmployeeDal employeeDal;
    @FXML
    private Button btnAdminLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        employeeDal = new EmployeeDal();
        // TODO
    }    
    
    //Log In Button
    @FXML
    private void handleBtnLogIn(ActionEvent event) throws IOException{
        
        String username = txtUsername.getText();
        String password = txtUsername.getText();
        
        try {
          
            ResultSet rs = employeeDal.logIn(username, password);
            
            if(!employeeDal.verifyLogin(rs)){
                lblMessage.setText("Suceess");
            }else{
                lblMessage.setText("Wrong Username Or Password");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }
        
        //Openning Home Page
        Parent root =FXMLLoader.load(getClass().getResource("/fxreportmanagement/HomePage/HomePageFxml.fxml"));
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
         
        
    }
    
    //Log In As A Admin Button
    @FXML
    private void handleBtnAdminLogIn(ActionEvent event) throws IOException {
        
        String username = txtUsername.getText();
        String password = txtUsername.getText();
 
        try {
            ResultSet rs = employeeDal.logInAsAdmin(username, password);
            if(!employeeDal.verifyLogin(rs)){
                lblMessage.setText("Suceess");
            }else{
                lblMessage.setText("Wrong Username Or Password");
            }
            
        } 
        catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        }        

        //Opening admin Window
           
        String fileLoc = "Login/AdminLogin/AdminLoginMainFxml";
        FxmlPageLoader.loadPage(fileLoc);
        
        
    }
    
}
