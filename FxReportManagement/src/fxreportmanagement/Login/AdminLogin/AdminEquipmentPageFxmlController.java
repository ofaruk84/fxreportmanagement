/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Login.AdminLogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.DatabaseOperations.DatabaseAccess.EquipmentDal;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Employee;
import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class AdminEquipmentPageFxmlController implements Initializable {

    @FXML
    private JFXTextField txtEquipment;
    @FXML
    private JFXTextField txtMpCarrierMedium;
    @FXML
    private JFXTextField txtMagTech;
    @FXML
    private JFXTextField txtUvLightIntencity;
    @FXML
    private JFXTextField txtDistanceOfLight;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private TableView<Equipment> tbvEquipment;
    @FXML
    private TableColumn<Equipment, SimpleIntegerProperty> tcId;
    @FXML
    private TableColumn<Equipment, SimpleStringProperty> tcPoleDistance;
    @FXML
    private TableColumn<Equipment, SimpleStringProperty> tcEquipment;
    @FXML
    private TableColumn<Equipment, SimpleStringProperty> tcMpCarierMedium;
    @FXML
    private TableColumn<Equipment, SimpleStringProperty> tcMagTech;
    @FXML
    private TableColumn<Equipment, SimpleStringProperty> tcUvLightIntencity;
    @FXML
    private TableColumn<Equipment, SimpleStringProperty> tcDistanceOfLight;

    private Equipment equipment;
    private EquipmentDal equipmentDal;
    private static ObservableList<Equipment> oblist;

    private int index = 0;
    @FXML
    private JFXTextField txtPoleDistance;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equipmentDal = new EquipmentDal();
        populateTable();
    }

    @FXML
    private void handleBtnAdd(ActionEvent event) {

        equipmentDal.add(getEquipment());
        populateTable();

    }

    @FXML
    private void handleBtnUpdate(ActionEvent event) {
        equipment = getEquipment();
        equipmentDal.update(index, equipment);
        populateTable();
    }

    @FXML
    private void handleBtnDelete(ActionEvent event) {
        equipmentDal.delete(index);
        populateTable();
    }

    @FXML
    private void handleGetClickedRow(MouseEvent event) {

        equipment = tbvEquipment.getSelectionModel().getSelectedItem();

        txtPoleDistance.setText(equipment.getPoleDistance());
        txtEquipment.setText(equipment.getEquipment());
        txtMpCarrierMedium.setText(equipment.getMpCarrierMedium());
        txtMagTech.setText(equipment.getMagTech());
        txtUvLightIntencity.setText(equipment.getUvLightIntencity());
        txtDistanceOfLight.setText(equipment.getDistanceOfLight());

        index = equipment.getId();

    }

    //Get Employee From GUI
    public Equipment getEquipment() {

        int id = index;
        String poleDistance = txtPoleDistance.getText();
        String equipment = txtEquipment.getText();
        String mpCarrier = txtMpCarrierMedium.getText();
        String magTech = txtMagTech.getText();
        String uvLight = txtUvLightIntencity.getText();
        String distanceOfLight = txtDistanceOfLight.getText();

        return new Equipment(id, poleDistance, equipment, mpCarrier, magTech, uvLight, distanceOfLight);

    }

    //Populating Table
    public void populateTable() {

        tcId.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleIntegerProperty>("id"));
        tcPoleDistance.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleStringProperty>("poleDistance"));
        tcEquipment.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleStringProperty>("equipment"));
        tcMpCarierMedium.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleStringProperty>("mpCarrierMedium"));
        tcMagTech.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleStringProperty>("magTech"));
        tcUvLightIntencity.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleStringProperty>("uvLightIntencity"));
        tcDistanceOfLight.setCellValueFactory(new PropertyValueFactory<Equipment, SimpleStringProperty>("distanceOfLight"));

        oblist = equipmentDal.getData();

        tbvEquipment.setItems(oblist);
    }

}
