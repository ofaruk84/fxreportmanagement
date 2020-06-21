/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import fxreportmanagement.Report2.Entitates.CustomerTab;
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
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
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

    private String equipmentName;

    private Equipment equipment;
    
    private CustomerTab customerTab;

    private static Report2FxmlController instance;
    @FXML
    private Button btnTestArrangements;

    public Report2FxmlController() {

        instance = this;
    }

    public static Report2FxmlController getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //Customer Page Button
    @FXML
    private void handleBtnCustomerAction(ActionEvent event) {

        Pane view = fpl.getPage("Report2/Report2CustomerPgFxml");

        bpMain.setCenter(view);

    }
    
    //Equipment Page Button
    @FXML
    private void handleBtnEquipmentAction(ActionEvent event) {

        Pane view = fpl.getPage("Report2/Report2EquipmentPgFxml");
        Report2EquipmentPgFxmlController.getInstance().setEquipmentType(equipmentName);
        System.out.println("Main R2  Equipment Button");
        Report2EquipmentPgFxmlController.getInstance().setEquipment(equipment);

        bpMain.setCenter(view);
    }
    
    //Inspection Results Page Button
    @FXML
    private void handleBtnInspectionResultsAction(ActionEvent event) {

        Pane view = fpl.getPage("Report2/Report2InspectionResultsPgFxml");

        bpMain.setCenter(view);

    }
    
    //Load Equipment Name(To Equipment Page)
    public void loadEqupimentName(String equipmentName) {

        this.equipmentName = equipmentName;

    }
    
    //Load Equipment(To Equipment Page)
    public void loadEquipment(Equipment eq) {
        
        equipment = eq;
        System.out.println("R2 controller load Equipment");
    }
    
    public void setCustomerTab(CustomerTab customerTab){
        
    }
}
