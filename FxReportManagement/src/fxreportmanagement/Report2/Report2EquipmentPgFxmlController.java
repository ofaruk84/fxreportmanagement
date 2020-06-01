/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import fxreportmanagement.HelperClasses.ExcelExporter;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport2;
import fxreportmanagement.Report2.Entitates.CustomerTab;
import fxreportmanagement.Report2.Entitates.EquipmentTab;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;

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
    private ComboBox<String> cmbCurrentType;
    @FXML
    private Label lblSurfaceTemperature;
    @FXML
    private TextField txtLiftingTestDateNo;
    @FXML
    private RadioButton rbtnButtWeld;
    @FXML
    private RadioButton rbtnFilledWeld;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtStandartDerivations;
    @FXML
    private Label lblInspectionDates;
    @FXML
    private ToggleGroup weldType;

    private Equipment equipment1;

    private CustomerTab customerTab;

    private final static ObservableList<String> oblist = FXCollections.observableArrayList("AC", "DC");

    private static Report2EquipmentPgFxmlController instance; //Create Instance
    @FXML
    private Button btnEquipmentSubmit;

    //Constructor
    public Report2EquipmentPgFxmlController() {
        instance = this;

    }

    //Get Instance Of Report2 Equipment Page
    public static Report2EquipmentPgFxmlController getInstance() {

        return instance;
    }

    //Initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setInitialValues();
        fill();

    }

    //Equipment Submit Button
    @FXML
    private void handleBtnEquipmentSubmit(ActionEvent event) {

//        ExcelExporter.setEquitmentTab(getEquipment());

        boolean res = verifyTextboxes();
        if (res) {
            
            ExcelExporterAsposeReport2.setEquipment(getEquipment());
            System.out.println("R2 Equipment Setted");
        }else{
            System.out.println("Fill the Gaps");}
    }

    //Get Equipment Information from GUI
    private EquipmentTab getEquipment() {

        String poleDistance = txtPoleDistance.getText();
        String equipment = txtEquipment.getText();
        String mpCarrierMedium = txtCarrierMedium.getText();
        String magTech = txtMagTech.getText();
        String uvLightIntesity = txtUvLightIntencity.getText();
        String distanceOfLight = txtDistanceOfLight.getText();
        String examinationArea = txtExaminationArea.getText();
        String currentType = (String) cmbCurrentType.getValue();
        String luxmeter = txtLuxmeter.getText();
        String testMedium = txtTestMedium.getText();
        String demagnetization = txtDemagnetization.getText();
        String heatTreatment = txtHeatTreatment.getText();
        String surfaceTemparature = lblSurfaceTemperature.getText();
        String gaussFieldStrength = txtGaussFieldStrength.getText();
        String surfaceCondition = txtSurfaceCondition.getText();
        String identicationOfLightEquipment = txtIdenOfLightEquip.getText();
        String liftingTestDateNo = txtLiftingTestDateNo.getText();
        String weldType = "";
        if (rbtnButtWeld.isSelected()) {
            weldType = "Butt Weld";
        }
        if (rbtnFilledWeld.isSelected()) {
            weldType = "Filled Weld";
        }
        String standartDevitions = txtStandartDerivations.getText();
        String inspectionDates = lblInspectionDates.getText();
        String description = txtDescription.getText();

        return new EquipmentTab(poleDistance, equipment, mpCarrierMedium, magTech, uvLightIntesity, distanceOfLight, examinationArea, currentType,
                luxmeter, testMedium, demagnetization, heatTreatment, surfaceTemparature, gaussFieldStrength,
                surfaceCondition, identicationOfLightEquipment,
                liftingTestDateNo, weldType, standartDevitions, inspectionDates, description);

    }

    //Set Equipment Type(Name)(From Home Page)
    public void setEquipmentType(String value) {

        txtEquipment.setText(value);

    }

    //Set Equipment(From Home Page)
    public void setEquipment(Equipment eq) {

        equipment1 = eq;

        txtPoleDistance.setText(equipment1.getPoleDistance());
        txtCarrierMedium.setText(equipment1.getMpCarrierMedium());
        txtMagTech.setText(equipment1.getMagTech());
        txtUvLightIntencity.setText(equipment1.getUvLightIntencity());
        txtDistanceOfLight.setText(equipment1.getDistanceOfLight());

    }

    //Set Initial Values
    private void setInitialValues() {
        txtExaminationArea.setText("WELD + HAZ");
        cmbCurrentType.setItems(oblist);
        cmbCurrentType.getSelectionModel().selectFirst();
        txtLuxmeter.setText("1200 LUX");
        txtGaussFieldStrength.setText("3.2 kA/m");
        txtSurfaceCondition.setText("GRINDING");
        txtIdenOfLightEquip.setText("***");
        lblInspectionDates.setText("value");
        lblSurfaceTemperature.setText("value");

    }

    //Fill Junk Values
    private void fill() {
        txtTestMedium.setText("Value");
        txtDemagnetization.setText("Value");
        txtHeatTreatment.setText("Value");
        txtLiftingTestDateNo.setText("Value");
        txtStandartDerivations.setText("Value");
        txtDescription.setText("Value");
    }

    //Set CustomerTab
    public void setCustomerTab(CustomerTab customerTab) {
        this.customerTab = customerTab;
    }

    //Verify
    private boolean verifyTextboxes() {

        boolean res = true;

        if (txtPoleDistance.getText().isEmpty()) {

            txtPoleDistance.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtEquipment.getText().isEmpty()) {

            txtEquipment.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtCarrierMedium.getText().isEmpty()) {

            txtCarrierMedium.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtMagTech.getText().isEmpty()) {

            txtMagTech.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtPoleDistance.getText().isEmpty()) {

            txtPoleDistance.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtUvLightIntencity.getText().isEmpty()) {

            txtUvLightIntencity.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtDistanceOfLight.getText().isEmpty()) {

            txtDistanceOfLight.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtExaminationArea.getText().isEmpty()) {

            txtExaminationArea.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (cmbCurrentType.getValue().isEmpty()) {

            cmbCurrentType.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtLuxmeter.getText().isEmpty()) {

            txtLuxmeter.setStyle("-fx-background-color: red;");
            res = false;
        }


        if (txtGaussFieldStrength.getText().isEmpty()) {

            txtGaussFieldStrength.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtSurfaceCondition.getText().isEmpty()) {

            txtSurfaceCondition.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtIdenOfLightEquip.getText().isEmpty()) {

            txtIdenOfLightEquip.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtLiftingTestDateNo.getText().isEmpty()) {

            txtLiftingTestDateNo.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtStandartDerivations.getText().isEmpty()) {

            txtStandartDerivations.setStyle("-fx-background-color: red;");
            res = false;
        }

        if (txtDescription.getText().isEmpty()) {

            txtDescription.setStyle("-fx-background-color: red;");
            res = false;
        }
        
        
        return res;

    }
}
