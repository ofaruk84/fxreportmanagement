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
    private ComboBox<String> cmbEquipment;

    private EquipmentDal equipmentDal;

    private EmployeeDal employeeDal;

    private ObservableList<String> oblist;

    private Equipment equipment;

    private REquipmentDal requipmentDal;

    private REquipment requipment;

    private REquipmentTab requipmentTab;
    @FXML
    private BorderPane bpMain;
    @FXML
    private JFXComboBox<String> cmbOpeartor;
    @FXML
    private JFXComboBox<String> cmbEvaluated;
    @FXML
    private JFXComboBox<String> cmbConfirmation;
    @FXML
    private JFXComboBox<String> cmbREquipment;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equipmentDal = new EquipmentDal();
        employeeDal = new EmployeeDal();
        requipmentDal = new REquipmentDal();

        getDate();
        populateCmbEquipment();
        populateCmbEmployees();
        populateCmbREquipment();

    }

    //Open Selected Report
    @FXML
    private void handleBtnOpen(ActionEvent event) throws IOException {

        String fileUrl = null;

        if (rbMagnetic.isSelected()) {

            ExcelExporter.setOperator(cmbOpeartor.getValue());
            ExcelExporter.setEvaluated(cmbEvaluated.getValue());
            ExcelExporter.setConfirmation(cmbConfirmation.getValue());
            ExcelExporter.setDate(lblDate.getText());

            fileUrl = "Report2/Report2Fxml";
            FxmlPageLoader.loadSameScene(bpMain, fileUrl);

            String value = (String) cmbEquipment.getValue();
            equipment = equipmentDal.getEquipment(value);
            Report2FxmlController.getInstance().loadEqupimentName(value);
            Report2FxmlController.getInstance().loadEquipment(equipment);

        }

        if (rbRadiographic.isSelected()) {

            fileUrl = "Report1/Report1";
            FxmlPageLoader.loadSameScene(bpMain, fileUrl);

            String value = (String) cmbREquipment.getValue();
            requipment = requipmentDal.getEquipment(value);
            Report1Controller.getInstance().loadEqupimentName(value);
            Report1Controller.getInstance().loadEquipment(requipment);            

        }

    }

    public void getDate() {

        LocalDate date = LocalDate.now();

        String time = date.toString();

        lblDate.setText(time);

    }

    private void populateCmbEquipment() {

        oblist = equipmentDal.getEQName();

        cmbEquipment.setItems(oblist);

    }

    private void populateCmbREquipment() {

        oblist = requipmentDal.getEQName();

        cmbREquipment.setItems(oblist);

    }

    private void populateCmbEmployees() {

        oblist = employeeDal.getEmployeeName();
        cmbConfirmation.setItems(oblist);
        cmbEvaluated.setItems(oblist);
        cmbOpeartor.setItems(oblist);
    }

}
