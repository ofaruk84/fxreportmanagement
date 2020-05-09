/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HomePage;

import fxreportmanagement.DatabaseOperations.DatabaseAccess.EquipmentDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import fxreportmanagement.HelperClasses.FxmlPageLoader;
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

    private ObservableList<String> oblist;

    private Equipment equipment;
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
        equipmentDal = new EquipmentDal();
        getDate();
        populateCmb();

    }

    //Open Selected Report
    @FXML
    private void handleBtnOpen(ActionEvent event) throws IOException {

        String fileUrl = null;

        if (rbMagnetic.isSelected()) {

            fileUrl = "Report2/Report2Fxml";
            FxmlPageLoader.loadSameScene(bpMain, fileUrl);

            String value = (String) cmbEquipment.getValue();
            equipment = equipmentDal.getEquipment(value);
            Report2FxmlController.getInstance().loadEqupimentName(value);
            Report2FxmlController.getInstance().loadEquipment(equipment);

        }

        if (rbRadiographic.isSelected()) {

            //fileUrl = "Report1/Report1Fxml";
        }

    }

    public void getDate() {

        LocalDate date = LocalDate.now();

        String time = date.toString();

        lblDate.setText(time);

    }

    private void populateCmb() {

        oblist = equipmentDal.getEQName();
        System.out.println(oblist);
        cmbEquipment.setItems(oblist);

    }

}
