/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import fxreportmanagement.DatabaseOperations.DatabaseAccess.CustomerDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Customer;
import fxreportmanagement.HelperClasses.DataKeeper;
import fxreportmanagement.HelperClasses.ExcelExporter;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport1;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport2;
import fxreportmanagement.Report2.Entitates.CustomerTab;
import fxreportmanagement.Report2.Entitates.TableViewEntitates.ProjectName;
import fxreportmanagement.Report2.Entitates.TableViewEntitates.StageOfExamination;
import fxreportmanagement.Report2.Entitates.TableViewEntitates.SurfaceCondition;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class Report2CustomerPgFxmlController implements Initializable {

    @FXML
    private ComboBox<String> cmbProjectName;
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
    private ComboBox<String> cmbSurfaceCondition;
    @FXML
    private ComboBox<String> cmbCustomer;
    @FXML
    private ComboBox<String> cmbStageOfExamination;
    @FXML
    private TextField txtPage;
    @FXML
    private Label lblReportNo;
    @FXML
    private Label lblReportDate;
    @FXML
    private Label lblInspectionPlace;
    @FXML
    private ComboBox<String> cmbJobOrderNo;
    @FXML
    private ComboBox<String> cmbOfferNo;
    @FXML
    private Button btnSubmit;
    @FXML
    private TextField txtInspectionStandart;

    private ObservableList<String> oblist;

    private final ObservableList<String> oblistCmb = FXCollections.observableArrayList("Values");//Temp Values

    private ObservableList<ProjectName> projectNames;
    private ObservableList<String> olProjectName = FXCollections.observableArrayList();

    private ObservableList<SurfaceCondition> surfaceConditions;
    private ObservableList<String> olSurfaceCondition = FXCollections.observableArrayList();

    private ObservableList<StageOfExamination> stageOfExaminations;
    private ObservableList<String> olStageOfExaminations = FXCollections.observableArrayList();

    private Customer customer;
    private CustomerDal customerDal;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        customerDal = new CustomerDal();
        getProjectName();
        getStageOfExamination();
        getSurfaceCondition();
        populateCmbCustomer();
        setInitialValue();

    }

    //Customer Submit Button
    @FXML
    private void handleBtnCustomer(ActionEvent event) {

//        ExcelExporter.setCustomerTab(getCustomer());
        ExcelExporterAsposeReport2.setCustomer(getCustomer());
        ExcelExporterAsposeReport1.setCustomer(getCustomer());
        System.out.println("R2 Customer Setted");

    }

    //Get Customer Information From The GUI
    private CustomerTab getCustomer() {

        String customer = (String) (cmbCustomer.getValue());
        String projectName = (String) (cmbProjectName.getValue());
        String inspectionPlace = lblInspectionPlace.getText();
        String inspectionStandart = txtInspectionStandart.getText();
        String evaluationStandart = txtEvaluationStandart.getText();
        String inspectionProcedure = txtInspectionProcedure.getText();
        String inspectionScope = txtInspectionScope.getText();
        String drawingNo = txtDrawingNo.getText();
        String surfaceCondition = (String) (cmbSurfaceCondition.getValue());
        String stageOfExamination = (String) (cmbStageOfExamination.getValue());
        String page = txtPage.getText();
        String reportNo = lblReportNo.getText();
        String reportDate = lblReportDate.getText();
        String jobOrderNo = (String) (cmbJobOrderNo.getValue());
        String offerNo = (String) (cmbOfferNo.getValue());

        return new CustomerTab(customer, projectName, inspectionPlace, inspectionStandart, evaluationStandart, inspectionProcedure, inspectionScope, drawingNo, surfaceCondition, stageOfExamination, page, reportNo, reportDate, jobOrderNo, offerNo);

    }

    //Populate CustomerName ComboBox 
    private void populateCmbCustomer() {

        oblist = customerDal.getCustomerName();
        cmbCustomer.setItems(oblist);
        cmbCustomer.getSelectionModel().selectFirst();

    }

    //Get Customer City from Customer Combobox 
    @FXML
    private void handleCmbCustomer(ActionEvent event) {

        String value = (String) cmbCustomer.getValue();
        customer = customerDal.getCustomerCity(value);
        lblInspectionPlace.setText(customer.getCustomerCity());

    }

    //Set Initial Values
    private void setInitialValue() {

        txtInspectionStandart.setText("TS EN ISO 17638");
        txtEvaluationStandart.setText("TS EN ISO 23278 Class B");
        txtInspectionProcedure.setText("P-101-004");
        txtInspectionScope.setText("%20");
        txtDrawingNo.setText("-");
        txtPage.setText("1");

        cmbProjectName.setItems(olProjectName);
        cmbProjectName.getSelectionModel().selectFirst();

        cmbSurfaceCondition.setItems(olSurfaceCondition);
        cmbSurfaceCondition.getSelectionModel().selectFirst();

        cmbStageOfExamination.setItems(olStageOfExaminations);
        cmbStageOfExamination.getSelectionModel().selectFirst();

        cmbJobOrderNo.setItems(oblistCmb);
        cmbJobOrderNo.getSelectionModel().selectFirst();

        cmbOfferNo.setItems(oblistCmb);
        cmbOfferNo.getSelectionModel().selectFirst();

        lblInspectionPlace.setText("Value");
        lblReportDate.setText("Value");
        lblReportNo.setText("Value");

    }

    public void getProjectName() {

        projectNames = DataKeeper.getProjectNames();

        for (ProjectName projectName : projectNames) {

            olProjectName.add(projectName.getProjectName());
        }
    }

    public void getSurfaceCondition() {

        surfaceConditions = DataKeeper.getSurfaceConditions();

        for (SurfaceCondition surfaceCondition : surfaceConditions) {

            olSurfaceCondition.add(surfaceCondition.getSurfaceCondition());

        }
    }

    public void getStageOfExamination() {

        stageOfExaminations = DataKeeper.getStageOfExaminations();

        for (StageOfExamination stageOfExamination : stageOfExaminations) {

            olStageOfExaminations.add(stageOfExamination.getStageOfExamination());

        }
    }

}
