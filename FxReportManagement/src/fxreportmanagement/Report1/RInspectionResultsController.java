/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport1;
import fxreportmanagement.Report1.Entitates.RInspectionResults;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class RInspectionResultsController implements Initializable {

    @FXML
    private TableView<RInspectionResults> tbvResults;
    @FXML
    private TableColumn<RInspectionResults, String> tcShootingArea;
    @FXML
    private TableColumn<RInspectionResults, String> tcFilmNo;
    @FXML
    private TableColumn<RInspectionResults, String> tcMaterialType;
    @FXML
    private TableColumn<RInspectionResults, String> tcPosition;
    @FXML
    private TableColumn<RInspectionResults, String> tcWeldingType;
    @FXML
    private TableColumn<RInspectionResults, String> tcWelderNo;
    @FXML
    private TableColumn<RInspectionResults, String> tcVisibleIQI;
    @FXML
    private TableColumn<RInspectionResults, String> tcThickness;
    @FXML
    private TableColumn<RInspectionResults, String> tcIQI;
    @FXML
    private TableColumn<RInspectionResults, String> tcPreEvaluation;
    @FXML
    private TableColumn<RInspectionResults, String> tcDensity;
    @FXML
    private TableColumn<RInspectionResults, String> tcX12;
    @FXML
    private TableColumn<RInspectionResults, String> tcFinalEvaluation;
    @FXML
    private TableColumn<RInspectionResults, String> tcDefectLoc;
    @FXML
    private TableColumn<RInspectionResults, String> tcDefectType;
    @FXML
    private TableColumn<RInspectionResults, String> tcX36;
    @FXML
    private TableColumn<RInspectionResults, String> tcX48;
    @FXML
    private TableColumn<RInspectionResults, String> tcX16;
    @FXML
    private TableColumn<RInspectionResults, String> tcX24;
    @FXML
    private TableColumn<RInspectionResults, String> tcX40;

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

    private static Vector<RInspectionResults> vector = new Vector<RInspectionResults>();

    private static ObservableList<RInspectionResults> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        fill();
    }

    @FXML
    private void handleBtnSaveAction(ActionEvent event) {
        
        ExcelExporterAsposeReport1.setInspectionResults(vector);
        System.out.println("R1 IR Setted");
        ExcelExporterAsposeReport1.exportGUI();
        
    }

    @FXML
    private void handleBtnSubmitAction(ActionEvent event) {

        vector.add(getInspectionResults());
        populateTable();
    }

    

    

    private RInspectionResults getInspectionResults() {

        String shootingArea = txtShootingArea.getText();
        String filmNo = txtFilmNo.getText();
        String materialType = txtMaterialType.getText();
        String weldingType = txtWeldingType.getText();
        String welderNo = txtWelderNo.getText();
        String position = txtPosition.getText();
        String thickness = txtThickness.getText();
        String IQI = txtIQI.getText();
        String visibleIQI = txtVisibleIQI.getText();
        String density = txtDensity.getText();
        String x12 = txtX12.getText();
        String x16 = txtX16.getText();
        String x24 = txtX24.getText();
        String x36 = txtX36.getText();
        String x48 = txtX48.getText();
        String x40 = txtX40.getText();
        String defectLoc = txtDefectLoc.getText();
        String defectType = txtDefectType.getText();
        String preEvaluation = txtPreEvaluation.getText();
        String finalEvaluation = txtFinalEvaluation.getText();

        return new RInspectionResults(shootingArea, filmNo, materialType, weldingType, welderNo, position,
                thickness, IQI, visibleIQI, density, x12, x16, x24, x36, x48, x40, defectLoc, defectType, preEvaluation, finalEvaluation);

    }

    private void populateTable() {

        RInspectionResults rInspectionResults = getInspectionResults();
        data.add(rInspectionResults);

        tcShootingArea.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("shootingArea"));
        tcFilmNo.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("filmNo"));
        tcMaterialType.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("materialType"));
        tcWeldingType.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("weldingType"));
        tcWelderNo.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("welderNo"));
        tcPosition.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("position"));
        tcThickness.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("thickness"));
        tcIQI.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("IQI"));
        tcVisibleIQI.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("visibleIQI"));
        tcDensity.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("density"));
        tcX12.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("x12"));
        tcX16.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("x16"));
        tcX24.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("x24"));
        tcX36.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("x36"));
        tcX48.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("x48"));
        tcX40.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("x40"));
        tcDefectLoc.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("defectLoc"));
        tcDefectType.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("defectType"));
        tcPreEvaluation.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("preEvaluation"));
        tcFinalEvaluation.setCellValueFactory(new PropertyValueFactory<RInspectionResults, String>("finalEvaluation"));

        tbvResults.setItems(data);

    }

    private void fill() {

        txtShootingArea.setText("1");
        txtFilmNo.setText("1");
        txtMaterialType.setText("1");
        txtWeldingType.setText("1");
        txtWelderNo.setText("1");
        txtPosition.setText("1");
        txtThickness.setText("1");
        txtIQI.setText("1");
        txtVisibleIQI.setText("1");
        txtDensity.setText("1");
        txtX12.setText("1");
        txtX16.setText("1");
        txtX24.setText("1");
        txtX36.setText("1");
        txtX48.setText("1");
        txtX40.setText("1");
        txtDefectLoc.setText("1");
        txtDefectType.setText("1");
        txtPreEvaluation.setText("1");
        txtFinalEvaluation.setText("1");
    }

}
