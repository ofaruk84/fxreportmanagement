/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class RInspectionResultsController implements Initializable {

    @FXML
    private TableView<?> tbvResults;
    @FXML
    private TableColumn<?, ?> tcShootingArea;
    @FXML
    private TableColumn<?, ?> tcFilmNo;
    @FXML
    private TableColumn<?, ?> tcMaterialType;
    @FXML
    private TableColumn<?, ?> tcPosition;
    @FXML
    private TableColumn<?, ?> tcWeldingType;
    @FXML
    private TableColumn<?, ?> tcWelderNo;
    @FXML
    private TableColumn<?, ?> tcVisibleIQI;
    @FXML
    private TableColumn<?, ?> tcThickness;
    @FXML
    private TableColumn<?, ?> tcIQI;
    @FXML
    private TableColumn<?, ?> tcPreEvaluation;
    @FXML
    private TableColumn<?, ?> tcDensity;
    @FXML
    private TableColumn<?, ?> tcX12;
    @FXML
    private TableColumn<?, ?> tcFinalEvaluation;
    @FXML
    private TableColumn<?, ?> tcDefectLoc;
    @FXML
    private TableColumn<?, ?> tcDefectType;
    @FXML
    private TableColumn<?, ?> tcX36;
    @FXML
    private TableColumn<?, ?> tcX48;
    @FXML
    private TableColumn<?, ?> tcX16;
    @FXML
    private TableColumn<?, ?> tcX24;
    @FXML
    private TableColumn<?, ?> tcX40;

    @FXML
    private Button btnSave;
    @FXML
    private TextField txtShootingArea;
    @FXML
    private TextField txtFilmNo;
    @FXML
    private TextField txtMaterialType;
    @FXML
    private TextField txtWeldingType;
    @FXML
    private TextField txtWelderNo;
    @FXML
    private TextField txtPosition;
    @FXML
    private TextField txtThickness;
    @FXML
    private TextField txtIQI;
    @FXML
    private TextField txtVisibleIQI;
    @FXML
    private TextField txtDensity;
    @FXML
    private TextField txtX12;
    @FXML
    private TextField txtX16;
    @FXML
    private TextField txtX24;
    @FXML
    private TextField txtX36;
    @FXML
    private TextField txtX48;
    @FXML
    private TextField txtX40;
    @FXML
    private TextField txtDefectLoc;
    @FXML
    private TextField txtDefectType;
    @FXML
    private TextField txtPreEvaluation;
    @FXML
    private TextField txtFinalEvaluation;
    @FXML
    private Button btnSubmit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleBtnSaveAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnSubmitAction(ActionEvent event) {
    }
}
