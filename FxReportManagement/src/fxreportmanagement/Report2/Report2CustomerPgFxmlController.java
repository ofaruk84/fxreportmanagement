/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;
import javafx.scene.Parent;
import fxreportmanagement.Report2.Entitates.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class Report2CustomerPgFxmlController implements Initializable {

    @FXML
    private ComboBox<?> cmbProjectName;
    @FXML
    private TextField txtInspectionField;
    @FXML
    private TextField txtEvaluationStandart;
    @FXML
    private TextField txtInspectionProcedure;
    @FXML
    private TextField txtInspectionScope;
    @FXML
    private TextField txtDrawingNo;
    @FXML
    private ComboBox<?> cmbSurfaceCondition;
    @FXML
    private ComboBox<?> cmbCustomer;
    @FXML
    private ComboBox<?> cmbStageOfExamination;
    @FXML
    private TextField txtPage;
    @FXML
    private Label lblReportNo;
    @FXML
    private Label lblReportDate;
    @FXML
    private ComboBox<?> cmbJobOrderNo;
    @FXML
    private ComboBox<?> cmbOfferNo;
    @FXML
    private Button btnSubmit;
    @FXML
    private TextField txtInspectionStandart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtPage.setText("5");
        
    }
    
    public String getPAge(){
        return txtPage.getText();
    }

    
    public Customer getCustomer(){
        
        String customer = (String)(cmbCustomer.getValue());
        String projectName = (String)(cmbProjectName.getValue());
        String inspectionPlace = txtInspectionField.getText();
        String inspectionStandart = txtInspectionStandart.getText();
        String evaluationStandart = txtEvaluationStandart.getText();
        String inspectionProcedure = txtInspectionProcedure.getText();
        String inspectionScope = txtInspectionScope.getText();       
        String drawingNo = txtDrawingNo.getText();
        String surfaceCondition = (String)(cmbSurfaceCondition.getValue());
        String stageOfExamination = (String)(cmbStageOfExamination.getValue());
        String page = txtPage.getText();        
        String reportNo = lblReportNo.getText();
        String reportDate = lblReportDate.getText();  
        String jobOrderNo = (String)(cmbJobOrderNo.getValue());  
        String offerNo = (String)(cmbOfferNo.getValue());
        
        return new Customer(customer, projectName, inspectionPlace, evaluationStandart, inspectionProcedure, drawingNo, surfaceCondition, stageOfExamination, page, reportNo, reportDate, jobOrderNo, offerNo);
        
        }

    @FXML
    private void handleBtnCustomerPgSubmit(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Report2ResultsPreviewFXML.fxml"));
        
        
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
        
        
        
    }
    
}
