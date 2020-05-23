/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
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

}
