/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Faruk
 */

//749.6-564.8 #f0932b-turuncu ##273c75-hover;


public class Report2FxmlController implements Initializable {

    @FXML
    private Button btnCustomer;
    @FXML
    private BorderPane bpMain;
    @FXML
    private Button btnEquipment;
    
    private fxreportmanagement.HelperClasses.FxmlPageLoader fpl = null;
    @FXML
    private Button btnInspectionResults;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBtnCustomerAction(ActionEvent event) {
        
       
        
        Pane view = fpl.getPage("Report2CustomerPgFxml");
        
        bpMain.setCenter(view);
        
    }

    @FXML
    private void handleBtnEquipmentAction(ActionEvent event) {
        
        Pane view = fpl.getPage("Report2EquipmentPgFxml");
        
        bpMain.setCenter(view);
    }

    @FXML
    private void handleBtnInspectionResultsAction(ActionEvent event) {
        
        
        Pane view = fpl.getPage("Report2InspectionResultsPgFxml");
        
        bpMain.setCenter(view);    
        
        
    }
    
}
