/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EmployeeDal;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EquipmentDal;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.REquipmentDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.REquipment;
import fxreportmanagement.HelperClasses.DataKeeper;
import fxreportmanagement.HelperClasses.ExcelExporter;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport2;
import fxreportmanagement.HelperClasses.FxmlPageLoader;
import fxreportmanagement.Report1.Entitates.REquipmentTab;
import fxreportmanagement.Report2.Entitates.CustomerOptions;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class Report2OptionsPgFxmlController implements Initializable {

    @FXML
    private AnchorPane ancMain;

    @FXML
    private JFXComboBox<String> cmbEquipment;
    @FXML
    private JFXComboBox<String> cmbOpeartor;
    @FXML
    private JFXComboBox<String> cmbEvaluated;
    @FXML
    private JFXComboBox<String> cmbConfirmation;
    @FXML
    private Button btnOpen;
    @FXML
    private JFXTextField txtProjectName;
    @FXML
    private TableView<ProjectName> tbvProjectName;
    @FXML
    private Button btnAddProjectName;
    @FXML
    private Button btnDeleteProjectName;
    @FXML
    private Button btnSaveProjectName;
    @FXML
    private JFXTextField txtStageOfExam;
    @FXML
    private TableView<StageOfExamination> tbvStageOfExam;
    @FXML
    private Button btnAddStageOfExam;
    @FXML
    private Button btnDeleteStageOfExam;
    @FXML
    private Button btnSaveSurfaceCondition;
    @FXML
    private TableView<SurfaceCondition> tbvSurfaceCondition;
    @FXML
    private Button btnAddSurfaceCondition;
    @FXML
    private Button btnDeleteSurfaceCondition;
    @FXML
    private JFXTextField txtSurfaceCondition;
    @FXML
    private TableColumn<ProjectName, String> tcProjectName;
    @FXML
    private TableColumn<StageOfExamination, String> tcStageOfExam;
    @FXML
    private TableColumn<SurfaceCondition, String> tcSurfaceCondition;

    private ObservableList<ProjectName> projectNames = FXCollections.observableArrayList();

    private ObservableList<SurfaceCondition> surfaceConditions = FXCollections.observableArrayList();

    private ObservableList<StageOfExamination> stageOfExams = FXCollections.observableArrayList();

    private Equipment equipment;

    private REquipmentDal requipmentDal;

    private REquipment requipment;

    private REquipmentTab requipmentTab;

    private EquipmentDal equipmentDal;

    private EmployeeDal employeeDal;

    private ObservableList<String> oblist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        defaultTableViewSetUp();

        equipmentDal = new EquipmentDal();
        employeeDal = new EmployeeDal();

        populateCmbEquipment();
        populateCmbEmployees();
    }

    @FXML
    private void handleBtnOpen(ActionEvent event) {

        ExcelExporterAsposeReport2.setOperator(cmbOpeartor.getValue());
        
        ExcelExporterAsposeReport2.setEvaluated(cmbEvaluated.getValue());
        
        ExcelExporterAsposeReport2.setConfirmation(cmbConfirmation.getValue());
        
        String fileUrl = "Report2/Report2Fxml";
        FxmlPageLoader.loadSameScene(ancMain, fileUrl);

        String value = (String) cmbEquipment.getValue();
        equipment = equipmentDal.getEquipment(value);
        Report2FxmlController.getInstance().loadEqupimentName(value);
        Report2FxmlController.getInstance().loadEquipment(equipment);
    }

    @FXML
    private void handleBtnAddProjectNameAction(ActionEvent event) {

        addProjectName();

    }

    @FXML
    private void handleBtnDeleteProjectNameAction(ActionEvent event) {

        deleteProjectName();
    }

    @FXML
    private void handleBtnSaveProjectNameAction(ActionEvent event) {

        saveProjectName();
        System.out.println("R2 Op Project Name Saved");
    }

    @FXML
    private void handleBtnAddStageOfExaminationAction(ActionEvent event) {

        addStageOfExamination();
    }

    @FXML
    private void handleBtnDeleteStageOfExamAction(ActionEvent event) {

        deleteStageOfExamination();
    }

    @FXML
    private void handleBtnSaveStageOfExamAction(ActionEvent event) {

        saveStageOfExamination();
        System.out.println("R2 Op Stage Of Examination Saved");
    }

    @FXML
    private void handleBtnAddSurfaceConditionAction(ActionEvent event) {

        addSurfaceCondition();
    }

    @FXML
    private void handleBtnDeleteSurfaceConditionAction(ActionEvent event) {

        deleteSurfaceCondition();
    }

    @FXML
    private void handleBtnSaveSurfaceConditionAction(ActionEvent event) {

        saveSurfaceCondition();
        System.out.println("R2 Op Surface Condition Saved");
    }

    private void defaultTableViewSetUp() {

        tbvProjectName.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tbvSurfaceCondition.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tbvStageOfExam.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    //Get Project Name
    private ProjectName getProjectName() {

        return new ProjectName(txtProjectName.getText());

    }

    //Add Project Name Table
    private void addProjectName() {

        tcProjectName.setCellValueFactory(new PropertyValueFactory<ProjectName, String>("projectName"));

        tbvProjectName.getItems().add(getProjectName());

    }

    //Delete Project Name
    private void deleteProjectName() {

        ObservableList<ProjectName> selectedRows, allItems;

        allItems = tbvProjectName.getItems();

        selectedRows = tbvProjectName.getSelectionModel().getSelectedItems();

        for (ProjectName projectName : selectedRows) {

            allItems.remove(projectName);

        }

    }

    //Save Project Name
    private void saveProjectName() {

        projectNames = tbvProjectName.getItems();

        DataKeeper.setProjectNames(projectNames);

    }

    //Get SurfaceCondition
    private SurfaceCondition getSurfaceCondition() {

        return new SurfaceCondition(txtSurfaceCondition.getText());

    }

    //Add SurfaceCondition Table
    private void addSurfaceCondition() {

        tcSurfaceCondition.setCellValueFactory(new PropertyValueFactory<SurfaceCondition, String>("surfaceCondition"));

        tbvSurfaceCondition.getItems().add(getSurfaceCondition());

    }

    //Delete SurfaceCondition
    private void deleteSurfaceCondition() {

        ObservableList<SurfaceCondition> selectedRows, allItems;

        allItems = tbvSurfaceCondition.getItems();

        selectedRows = tbvSurfaceCondition.getSelectionModel().getSelectedItems();

        for (SurfaceCondition surfaceCondition : selectedRows) {

            allItems.remove(surfaceCondition);

        }

    }

    //Save SurfaceCondition
    private void saveSurfaceCondition() {

        surfaceConditions = tbvSurfaceCondition.getItems();
        
        DataKeeper.setSurfaceConditions(surfaceConditions);

    }

    //Get Stage Of Examination
    private StageOfExamination getStageOfExam() {

        return new StageOfExamination(txtStageOfExam.getText());

    }

    //Add Stage Of Examination Table
    private void addStageOfExamination() {

        tcStageOfExam.setCellValueFactory(new PropertyValueFactory<StageOfExamination, String>("stageOfExamination"));

        tbvStageOfExam.getItems().add(getStageOfExam());

    }

    //Delete Stage Of Examination
    private void deleteStageOfExamination() {

        ObservableList<StageOfExamination> selectedRows, allItems;

        allItems = tbvStageOfExam.getItems();

        selectedRows = tbvStageOfExam.getSelectionModel().getSelectedItems();

        for (StageOfExamination stageOfExamination : selectedRows) {

            allItems.remove(stageOfExamination);

        }

    }

    //Save Stage Of Examination
    private void saveStageOfExamination() {

        stageOfExams = tbvStageOfExam.getItems();
        
        DataKeeper.setStageOfExaminations(stageOfExams);

    }

    private void populateCmbEquipment() {

        oblist = equipmentDal.getEQName();

        cmbEquipment.setItems(oblist);

    }

    private void populateCmbEmployees() {

        oblist = employeeDal.getEmployeeName();
        cmbConfirmation.setItems(oblist);
        cmbEvaluated.setItems(oblist);
        cmbOpeartor.setItems(oblist);
    }

}
