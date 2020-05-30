/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.Report1.Entitates.REquipmentTab;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    @FXML
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleBtnSubmitAction(ActionEvent event) {
    }

    private REquipmentTab getRequipment() {

        String equipment = lblEquipment.getText();
        String usedDevice = txtUsedDevice.getText();
        String deviceEnergy = getDeviceEnergy();
        String pbScenes = txtPbScenes.getText();
        String exposureTime = txtExposureTime.getText();
        String filmFocusDistance = txtFilmFocusDistance.getText();
        String filters = txtFilters.getText();
        String heatTreatment = txtHeatTreatment.getText();
        String filmBrand = txtFilmBrand.getText();
        String filmType = getFilmType();
        String en = getIQIType();
        String astm = getIQIType();
        String sourceSide = getIQIType();
        String filmSide = getIQIType();
        String automatic = getFilmProcessType();
        String manual = getFilmProcessType();
        String temperature = getFilmProcessType();
        String x12 = txtX12.getText();
        String x16 = txtX16.getText();
        String x24 = txtX24.getText();
        String x36 = txtX36.getText();
        String x48 = txtX48.getText();
        String x40 = txtX40.getText();
        String suitibleFilm = txtSuitibleFilm.getText();
        String repairFilm = txtRepairFilm.getText();
        
        return new REquipmentTab(equipment, usedDevice, deviceEnergy, pbScenes, 
                exposureTime, filmFocusDistance, filters, heatTreatment, filmBrand, filmType, en, astm,
                sourceSide, filmSide, automatic, manual, temperature, x12, x16, x24, x36, x48, x40, suitibleFilm, repairFilm);

    }
    
    

    private String getDeviceEnergy() {

        String result = null;

        if (rbRi192.isSelected()) {
            result = "0";
        }
        if (rbSe75.isSelected()) {
            result = "1";
        }
        if (rbXRay.isSelected()) {
            result = "2";
        }

        return result;
    }

    private String getFilmType() {

        String result = null;

        if (rbD4.isSelected()) {
            result = "0";
        }
        if (rbD5.isSelected()) {
            result = "1";
        }
        if (rbD7.isSelected()) {
            result = "2";
        }

        return result;

    }

    private String getIQIType() {

        String result = null;

        if (rbEn.isSelected()) {
            result = "0";
        }
        if (rbAstm.isSelected()) {
            result = "1";
        }
        if (rbSourceSide.isSelected()) {
            result = "2";
        }
        if (rbFilmSide.isSelected()) {
            result = "3";
        }

        return result;

    }

    private String getFilmProcessType() {

        String result = null;

        if (rbAutomatic.isSelected()) {
            result = "0";
        }
        if (rbManual.isSelected()) {
            result = "1";
        }

        return result;

    }

}
