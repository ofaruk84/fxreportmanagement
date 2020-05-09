/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class Report2EquipmentPgFxmlController implements Initializable {

    @FXML
    private TextField txtPoleDistance;
    @FXML
    private TextField txtEquipment;
    @FXML
    private TextField txtCarrierMedium;
    @FXML
    private TextField txtMagTech;
    @FXML
    private TextField txtUvLightIntencity;
    @FXML
    private TextField txtDistanceOfLight;
    @FXML
    private TextField txtExaminationArea;
    @FXML
    private TextField txtLuxmeter;
    @FXML
    private TextField txtTestMedium;
    @FXML
    private TextField txtDemagnetization;
    @FXML
    private TextField txtHeatTreatment;
    @FXML
    private TextField txtGaussFieldStrength;
    @FXML
    private TextField txtSurfaceCondition;
    @FXML
    private TextField txtIdenOfLightEquip;
    @FXML
    private ComboBox<?> cmbCurrentType;
    @FXML
    private Label lblSurfaceTemperature;
    @FXML
    private TextField txtLiftingTestDateNo;
    @FXML
    private RadioButton rbtnButtWeld;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtStandartDerivations;
    @FXML
    private Label lblInspectionDates;
    @FXML
    private Button btnSubmit2;
    @FXML
    private RadioButton rbtnFilledeld1;

    private Equipment equipment1;

    private static Report2EquipmentPgFxmlController instance;

    public Report2EquipmentPgFxmlController() {
        instance = this;

    }

    public static Report2EquipmentPgFxmlController getInstance() {

        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setEquipmentType(String value) {

        txtEquipment.setText(value);

    }

    public void setEquipment(Equipment eq) {

        equipment1 = eq;
        System.out.println(equipment1.getDistanceOfLight() + "geldi");

//     String poleDistance = equipment1.getPoleDistance();
//     String equipment = equipment1.getEquipment();
//     String mpCarrier = equipment1.getMpCarrierMedium();
//     String magTech = equipment1.getMagTech();
//     String uvLight = equipment1.getUvLightIntencity();
//     String distanceOfLight =equipment1.getDistanceOfLight();
//     
//        
        txtPoleDistance.setText(equipment1.getPoleDistance());
//      txtEquipment.setText(equipment1.getEquipment());
        txtCarrierMedium.setText(equipment1.getMpCarrierMedium());
        txtMagTech.setText(equipment1.getMagTech());
        txtUvLightIntencity.setText(equipment1.getUvLightIntencity());
        txtDistanceOfLight.setText(equipment1.getDistanceOfLight());

    }

}
