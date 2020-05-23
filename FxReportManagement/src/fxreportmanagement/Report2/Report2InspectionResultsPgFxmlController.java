/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import com.jfoenix.controls.JFXButton;
import fxreportmanagement.HelperClasses.ExcelExporter;
import fxreportmanagement.Report2.Entitates.InspectionResults;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class Report2InspectionResultsPgFxmlController implements Initializable {

    @FXML
    private TableView<InspectionResults> tbvInspectionResults;
    @FXML
    private TableColumn<InspectionResults, String> tcId;
    @FXML
    private TableColumn<InspectionResults, String> tcWeldNo;
    @FXML
    private TableColumn<InspectionResults, String> tcTestLength;
    @FXML
    private TableColumn<InspectionResults, String> tcWeldingProcess;
    @FXML
    private TableColumn<InspectionResults, String> tcThikness;
    @FXML
    private TableColumn<InspectionResults, String> tcDiameter;
    @FXML
    private TableColumn<InspectionResults, String> tcDefectType;
    @FXML
    private TableColumn<InspectionResults, String> tcDefectLoc;
    @FXML
    private TableColumn<InspectionResults, String> tcResult;
    @FXML
    private TextField txtWeldNo;
    @FXML
    private TextField txtTestLength;
    @FXML
    private TextField txtWeldingProcess;
    @FXML
    private TextField txtThickness;
    @FXML
    private TextField txtDiameter;
    @FXML
    private TextField txtDefectType;
    @FXML
    private TextField txtDefectLoc;
    @FXML
    private ComboBox<String> cmbResult;
    @FXML
    private Label lblWeldNo;
    @FXML
    private Label lblTestLength;
    @FXML
    private Label lblWeldingProcess;
    @FXML
    private Label lblThickness;
    @FXML
    private Label lblDiameter;
    @FXML
    private Label lblDefectType;
    @FXML
    private Label lblDefectLoc;
    @FXML
    private Label lblResult;
    @FXML
    private Button btnSubmit;

    private static ObservableList<InspectionResults> data;
    @FXML
    private JFXButton btnSave;
    
    private static Vector<InspectionResults> inspectionResultses = new Vector<InspectionResults>();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        ObservableList<String> cmbRes = FXCollections.observableArrayList("OK", "RED");
        cmbResult.setItems(cmbRes);

    }

    private void populateTable() {



        InspectionResults ir = getInspectionResults();

        data.add(ir);

        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("id"));
        tcWeldNo.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("weldNo"));
        tcTestLength.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("testLength"));
        tcWeldingProcess.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("weldingProcess"));
        tcThikness.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("thickness"));
        tcDiameter.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("diameter"));
        tcDefectType.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("defectType"));
        tcDefectLoc.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("defectLoc"));
        tcResult.setCellValueFactory(new PropertyValueFactory<InspectionResults, String>("result"));

        //assign
        tbvInspectionResults.setItems(data);

    }

    @FXML
    private void handleBtnSubmit(ActionEvent event) {

        

        inspectionResultses.add(getInspectionResults());
        populateTable();

    }

    private InspectionResults getInspectionResults() {

        String weldNo = txtWeldNo.getText();
        String testLength = txtTestLength.getText();
        String weldingProcess = txtWeldingProcess.getText();
        String thickness = txtDiameter.getText();
        String diameter = txtDiameter.getText();
        String defectType = txtDefectType.getText();
        String defectLoc = txtDefectLoc.getText();
        String result = (String) (cmbResult.getValue());

        return new InspectionResults(weldNo, testLength, weldingProcess, thickness, diameter, defectType, defectLoc, result);

    }

    @FXML
    private void handleBtnSave(ActionEvent event) {
        
        System.out.println(inspectionResultses.get(0).getDefectLoc());
        ExcelExporter.setInspectionResults(inspectionResultses);
        
        ExcelExporter.exportGUI();
        
        
    }

    public void populateTableDeneme(InspectionResults ir) {
//        
//         data.add(ir);
//         
//    
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("id"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("weldNo"));        
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("testLength"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("weldingProcess"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("thickness"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("diameter"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("defectType"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("defectLoc"));
//        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("result"));
//        
//        
//        
//        //assign
//        tbvInspectionResults.setItems(data);
//        
//        
    }//Old

}
