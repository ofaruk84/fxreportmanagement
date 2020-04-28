/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Login.AdminLogin;

import com.jfoenix.controls.JFXButton;
import fxreportmanagement.HelperClasses.FxmlPageLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class AdminLoginMainFxmlController implements Initializable {

    @FXML
    private BorderPane bpMain;
    @FXML
    private JFXButton btnEmployee;
    @FXML
    private JFXButton btnCustomer;
    @FXML
    private JFXButton btnEquipment;
    
    
    private Pane view;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        view = FxmlPageLoader.getPageforAdmin("AdminEmployeePageFxml");
        bpMain.setCenter(view);
    }    

    @FXML
    private void handleBtnEmployee(ActionEvent event) {
        
        view = FxmlPageLoader.getPageforAdmin("AdminEmployeePageFxml");
        bpMain.setCenter(view);
    }

    @FXML
    private void handleBtnCustomer(ActionEvent event) {
        
        view = FxmlPageLoader.getPageforAdmin("AdminCustomerPageFxml");
        bpMain.setCenter(view);        
        
    }

    @FXML
    private void handleBtnEquipment(ActionEvent event) {
        view = FxmlPageLoader.getPageforAdmin("AdminEquipmentPageFxml");
        bpMain.setCenter(view);
    }
    
}
