/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.REquipment;
import fxreportmanagement.HelperClasses.FxmlPageLoader;
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
public class Report1Controller implements Initializable {

    @FXML
    private BorderPane bpMain;
    @FXML
    private Button btnCustomer;
    @FXML
    private Button btnTestArrangements;
    @FXML
    private Button btnInspectionResults;
    @FXML
    private Button btnREquipment;
    
    private REquipment equipment;
    
    private String equipmentName;
    
    private static Report1Controller instance;
    
    public Report1Controller() {
        
        instance = this;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public static Report1Controller getInstance(){
        return instance;
    }
    
    @FXML
    private void handleBtnCustomerAction(ActionEvent event) {

        Pane view = FxmlPageLoader.getPage("Report2/Report2CustomerPgFxml");

        bpMain.setCenter(view);
    }

    @FXML
    private void handleBtnTestArrangementsAction(ActionEvent event) {

        Pane view = FxmlPageLoader.getPage("Report1/RTestArrangements");

        bpMain.setCenter(view);
    }

    @FXML
    private void handleBtnInspectionResultsAction(ActionEvent event) {

        Pane view = FxmlPageLoader.getPage("Report1/RInspectionResults");

        bpMain.setCenter(view);
    }

    @FXML
    private void handleBtnREquipmentAction(ActionEvent event) {
        
        
        Pane view = FxmlPageLoader.getPage("Report1/REquipment");
        REquipmentController.getInstance().setEquipmentType(equipmentName);
        REquipmentController.getInstance().setEquipment(equipment);
        bpMain.setCenter(view);
        
        

    }
    
    public void loadEqupimentName(String equipmentName) {

        this.equipmentName = equipmentName;

    }

    public void loadEquipment(REquipment eq) {
        
        equipment = eq;
        
    }    

}
