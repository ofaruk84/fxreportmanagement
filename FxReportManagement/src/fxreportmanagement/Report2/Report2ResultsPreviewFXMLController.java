/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import fxreportmanagement.Report2.Entitates.Customer;
import javafx.scene.Parent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class Report2ResultsPreviewFXMLController implements Initializable {

    @FXML
    private Button btnGEt;
    @FXML
    private TextField txtInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    

    @FXML
    public void handleBtnInfo(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Report2CustomerPgFXML.fxml"));
        Parent root = loader.load();
        
        Report2CustomerPgFxmlController customerPgController = loader.getController();
        
        //Customer customer = customerPgController.getCustomer();
         System.out.println("212"); 
         String s =customerPgController.getPAge();
         System.out.println(s);
        txtInfo.setText(customerPgController.getPAge());
        System.out.println("21");        
    }
    
    
    
}
