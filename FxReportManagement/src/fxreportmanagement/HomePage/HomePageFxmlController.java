/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HomePage;

import com.jfoenix.controls.JFXComboBox;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EmployeeDal;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EquipmentDal;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.REquipmentDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.REquipment;
import fxreportmanagement.HelperClasses.ExcelExporter;
import fxreportmanagement.HelperClasses.FxmlPageLoader;
import fxreportmanagement.Report1.Entitates.REquipmentTab;
import fxreportmanagement.Report1.Report1Controller;
import fxreportmanagement.Report2.Report2FxmlController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class HomePageFxmlController implements Initializable {

    @FXML
    private Label lblDate;
    @FXML
    private Button btnOpen;
    @FXML
    private RadioButton rbRadiographic;
    @FXML
    private ToggleGroup report;
    @FXML
    private RadioButton rbMagnetic;


    @FXML
    private BorderPane bpMain;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        getDate();
    }

    //Open Selected Report
    @FXML
    private void handleBtnOpen(ActionEvent event) throws IOException {

        String fileUrl = null;

        if (rbMagnetic.isSelected()) {


            fileUrl = "Report2/Report2OptionsPgFxml";
            FxmlPageLoader.loadSameScene(bpMain, fileUrl);



        }

        if (rbRadiographic.isSelected()) {

            fileUrl = "Report1/Report1Options";
            FxmlPageLoader.loadSameScene(bpMain, fileUrl);
           

        }

    }

    public void getDate() {

        LocalDate date = LocalDate.now();

        String time = date.toString();

        lblDate.setText(time);

    }


}
