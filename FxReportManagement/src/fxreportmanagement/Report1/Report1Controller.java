/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

        bpMain.setCenter(view);
        
        System.out.println("yuk");

    }

}
