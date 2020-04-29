/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;


import fxreportmanagement.Report2.Entitates.InspectionResults;
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
    private TableColumn<InspectionResults,String> tcId;
    @FXML
    private TableColumn<InspectionResults,String> tcWeldNo;
    @FXML
    private TableColumn<InspectionResults,String> tcTestLength;
    @FXML
    private TableColumn<InspectionResults,String> tcWeldingProcess;
    @FXML
    private TableColumn<InspectionResults,String> tcThikness;
    @FXML
    private TableColumn<InspectionResults,String> tcDiameter;
    @FXML
    private TableColumn<InspectionResults,String> tcDefectType;
    @FXML
    private TableColumn<InspectionResults,String> tcDefectLoc;
    @FXML
    private TableColumn<InspectionResults,String> tcResult;
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


    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        data = FXCollections.observableArrayList();
        ObservableList<String> cmbRes = FXCollections.observableArrayList("OK","RED");
        cmbResult.setItems(cmbRes);

        
        
    }
    
    
    private void populateTable(){
     
    

        String weldNo = txtWeldNo.getText();
        String testLength = txtTestLength.getText();
        String weldingProcess = txtWeldingProcess.getText();
        String thickness = txtDiameter.getText();
        String diameter = txtDiameter.getText();
        String defectType = txtDefectType.getText();
        String defectLoc = txtDefectLoc.getText(); 
        String result = (String)(cmbResult.getValue());
     
     
        InspectionResults ir = new InspectionResults(weldNo, testLength, weldingProcess, thickness, diameter, defectType, defectLoc, result);
     
        data.add(ir);
         
    
        tcId.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("id"));
        tcWeldNo.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("weldNo"));        
        tcTestLength.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("testLength"));
        tcWeldingProcess.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("weldingProcess"));
        tcThikness.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("thickness"));
        tcDiameter.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("diameter"));
        tcDefectType.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("defectType"));
        tcDefectLoc.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("defectLoc"));
        tcResult.setCellValueFactory(new PropertyValueFactory<InspectionResults,String>("result"));
        
        
        
        //assign
        tbvInspectionResults.setItems(data);
        
     
 }
    
    @FXML
    private void handleBtnSubmit(ActionEvent event) {
          
        System.out.println("butona giridi");
        populateTable();

      

    }
     
    
    
    
    //Getter-Setters---------------------------------//
    /**
     * @return the txtWeldNo
     */
    public TextField getTxtWeldNo() {
        return txtWeldNo;
    }
    /**
     * @return the txtTestLength
     */
    public TextField getTxtTestLength() {
        return txtTestLength;
    }

    /**
     * @return the txtWeldingProcess
     */
    public TextField getTxtWeldingProcess() {
        return txtWeldingProcess;
    }

    /**
     * @return the txtThickness
     */
    public TextField getTxtThickness() {
        return txtThickness;
    }

    /**
     * @return the txtDiameter
     */
    public TextField getTxtDiameter() {
        return txtDiameter;
    }

    /**
     * @return the txtDefectType
     */
    public TextField getTxtDefectType() {
        return txtDefectType;
    }

    /**
     * @return the txtDefectLoc
     */
    public TextField getTxtDefectLoc() {
        return txtDefectLoc;
    }

    /**
     * @return the cmbResult
     */
    public ComboBox<String> getCmbResult() {
        return cmbResult;
    }

    /**
     * @return the tcWeldNo
     */
    public TableColumn getTcWeldNo() {
        return tcWeldNo;
    }

    /**
     * @return the tbvInspectionResults
     */
    public TableView getTbvInspectionResults() {
        return tbvInspectionResults;
    }

    /**
     * @return the tcId
     */
    public TableColumn getTcId() {
        return tcId;
    }

    /**
     * @return the tcTestLength
     */
    public TableColumn getTcTestLength() {
        return tcTestLength;
    }

    /**
     * @return the tcWeldingProcess
     */
    public TableColumn getTcWeldingProcess() {
        return tcWeldingProcess;
    }

    /**
     * @return the tcThikness
     */
    public TableColumn getTcThikness() {
        return tcThikness;
    }

    /**
     * @return the tcDiameter
     */
    public TableColumn getTcDiameter() {
        return tcDiameter;
    }

    /**
     * @return the tcDefectType
     */
    public TableColumn getTcDefectType() {
        return tcDefectType;
    }

    /**
     * @return the tcDefectLoc
     */
    public TableColumn getTcDefectLoc() {
        return tcDefectLoc;
    }

    /**
     * @return the tcResult
     */
    public TableColumn getTcResult() {
        return tcResult;
    }
    //--------------------------------------------//
    



    

    

 
 
 
 
    public void populateTableDeneme(InspectionResults ir){
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
    

