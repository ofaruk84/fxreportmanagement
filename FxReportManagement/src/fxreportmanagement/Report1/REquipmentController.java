/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.REquipment;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport1;
import fxreportmanagement.Report1.Entitates.REquipmentTab;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class REquipmentController implements Initializable {

    @FXML
    private Label lblEquipment;
    @FXML
    private JFXTextField txtUsedDevice;
    private JFXRadioButton rbRi192;
    @FXML
    private JFXRadioButton rbXRay;
    @FXML
    private JFXRadioButton rbSe75;
    @FXML
    private JFXTextField txtExposureTime;
    @FXML
    private JFXTextField txtFilmFocusDistance;
    @FXML
    private JFXTextField txtFilters;
    @FXML
    private JFXTextField txtHeatTreatment;
    @FXML
    private JFXTextField txtPbScenes;
    @FXML
    private JFXTextField txtFilmBrand;
    @FXML
    private JFXRadioButton rbD4;
    @FXML
    private JFXRadioButton rbD7;
    @FXML
    private JFXRadioButton rbD5;
    @FXML
    private JFXRadioButton rbEn;
    @FXML
    private JFXRadioButton rbAstm;
    @FXML
    private JFXRadioButton rbFilmSide;
    @FXML
    private JFXRadioButton rbSourceSide;
    @FXML
    private JFXRadioButton rbAutomatic;
    @FXML
    private JFXRadioButton rbManual;
    @FXML
    private Label lblTemperature;
    @FXML
    private JFXTextField txtX12;
    @FXML
    private JFXTextField txtX16;
    @FXML
    private JFXTextField txtX24;
    @FXML
    private JFXTextField txtX48;
    @FXML
    private JFXTextField txtX40;
    @FXML
    private JFXTextField txtSuitibleFilm;
    @FXML
    private JFXTextField txtRepairFilm;
    @FXML
    private JFXButton btnSubmit;
    @FXML
    private JFXTextField txtX36;

    private static REquipmentController instance; // Create Instance
    @FXML
    private JFXTextField txtFocalSpotsize;
    @FXML
    private JFXRadioButton rbIr192;
    @FXML
    private ToggleGroup deviceEnergy;
    @FXML
    private ToggleGroup IQITech1;
    @FXML
    private ToggleGroup filmProcessingTech;
    @FXML
    private ToggleGroup filmType;
    @FXML
    private ToggleGroup IQITech;

    //Constructor
    public REquipmentController() {

        instance = this;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fill();

    }

    //Get Instance
    public static REquipmentController getInstance() {
        return instance;
    }

    //Equipment Page Submit Button
    @FXML
    private void handleBtnSubmitAction(ActionEvent event) {

        ExcelExporterAsposeReport1.setEquipment(getRequipment());
        System.out.println("R1 Equipment Setted");
    }

    //Get Equipment Informations From GUI
    private REquipmentTab getRequipment() {

        String equipment = lblEquipment.getText();
        String usedDevice = txtUsedDevice.getText();
        String ir192 = getIr192();
        String se75 = getSe75();
        String xRay = getXray();
        String focalSpotSize = txtFocalSpotsize.getText();

        String pbScenes = txtPbScenes.getText();
        String exposureTime = txtExposureTime.getText();
        String filmFocusDistance = txtFilmFocusDistance.getText();
        String filters = txtFilters.getText();
        String heatTreatment = txtHeatTreatment.getText();
        String filmBrand = txtFilmBrand.getText();

        String d4 = getD4();
        String d5 = getD5();
        String d7 = getD7();

        String en = getEn();
        String astm = getAstm();
        String sourceSide = getSourceSide();
        String filmSide = getFilmSide();

        String automatic = getAutomatic();
        String manual = getManuel();
        String temperature = lblTemperature.getText();

        String x12 = txtX12.getText();
        String x16 = txtX16.getText();
        String x24 = txtX24.getText();
        String x36 = txtX36.getText();
        String x48 = txtX48.getText();
        String x40 = txtX40.getText();
        String suitibleFilm = txtSuitibleFilm.getText();
        String repairFilm = txtRepairFilm.getText();

        return new REquipmentTab(equipment, usedDevice, ir192, se75, xRay, focalSpotSize,
                pbScenes, exposureTime, filmFocusDistance, filters, heatTreatment, filmBrand,
                d4, d5, d7, en, astm, sourceSide, filmSide, automatic, manual, temperature,
                x12, x16, x24, x36, x48, x40, suitibleFilm, repairFilm);

    }

    //Set Equipment Type/Name (From Home Page)
    public void setEquipmentType(String value) {

        lblEquipment.setText(value);

    }

    //Set Equipment(From Home Page)
    public void setEquipment(REquipment equipment) {

        txtUsedDevice.setText(equipment.getUsedDevice());
        txtFocalSpotsize.setText(equipment.getFocalSpotSize());
        txtExposureTime.setText(equipment.getExposureTime());
        txtFilmFocusDistance.setText(equipment.getFilmFocusDistance());
        txtPbScenes.setText(equipment.getPbScenes());

    }

    private void fill() {

        lblTemperature.setText("val");
        txtHeatTreatment.setText("val");
        txtFilters.setText("filters");
        txtX12.setText("12");
        txtX16.setText("12");
        txtX24.setText("12");
        txtX36.setText("12");
        txtX48.setText("12");
        txtX40.setText("12");
        txtSuitibleFilm.setText("Value");
        txtRepairFilm.setText("value");
        txtFilmBrand.setText("Kodak");
        

    }

    private String getIr192() {

        String res = "0";

        if (rbIr192.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getSe75() {

        String res = "0";

        if (rbSe75.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getXray() {

        String res = "0";

        if (rbXRay.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getEn() {

        String res = "0";

        if (rbEn.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getAstm() {

        String res = "0";

        if (rbAstm.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getD4() {

        String res = "0";

        if (rbD4.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getD5() {
        
        String res = "0";
        
        if(rbD5.isSelected()){
            res = "1";
        }
        return res;
    }

    private String getD7() {


        String res = "0";
        
        if(rbD7.isSelected()){
            res = "1";
        }
        return res;        
    }

    private String getSourceSide() {
        
        String res = "0";
        
        if(rbSourceSide.isSelected()){
            res = "1";
        }
        return res;
    }

    private String getFilmSide() {
        
        String res = "0";
        
        if(rbFilmSide.isSelected()){
            res = "1";
        }
        return res;
    }

    private String getAutomatic() {
              
        String res = "0";
        
        if(rbAutomatic.isSelected()){
            res = "1";
        }
        return res;
    }

    private String getManuel() {
        
        String res = "0";
        
        if(rbManual.isSelected()){
            res = "1";
        }
        return res;
    }

}
