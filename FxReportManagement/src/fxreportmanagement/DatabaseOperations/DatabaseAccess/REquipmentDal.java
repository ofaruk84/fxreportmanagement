/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseAccess;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.REquipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Faruk
 * Ömer Faruk Korkmaz
 * 170503014
 */
public class REquipmentDal {

    private REquipment equipment = new REquipment();
    private DBHelper dbHelper = new DBHelper();
    private Connection connection;

    public REquipmentDal() {

        establishConnection();

    }

    //Establish Connection
    public void establishConnection() {

        try {
            connection = dbHelper.getConecConnection();
        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }

    }

    //Add Equipment
    public void add(REquipment e) {

        String sqlQuery = "insert into equipmentm (equipment,usedDevice,focalSpotSize,exposureTime,filmFocusDistance,pbScenes) values(?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, e.getEquipment());
            statement.setString(2, e.getUsedDevice());
            statement.setString(3, e.getFocalSpotSize());
            statement.setString(4, e.getExposureTime());
            statement.setString(5, e.getFilmFocusDistance());
            statement.setString(6, e.getPbScenes());

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Delete Equipment
    public void delete(int id) {
        String sqlQuery = "delete from equipmentr where equipmentId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Update Equipment
    public void update(int index, REquipment e) {

        String sqlQuery = "update equipmentm set equipment = ?,usedDevice = ?,focalSpotSize = ?,exposureTime = ?,filmFocusDistance = ?,pbScenes = ? where equipmentId =?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, e.getEquipment());
            statement.setString(2, e.getUsedDevice());
            statement.setString(3, e.getFocalSpotSize());
            statement.setString(4, e.getExposureTime());
            statement.setString(5, e.getFilmFocusDistance());
            statement.setString(6, e.getPbScenes());
            statement.setInt(7, index);

            statement.executeUpdate();
        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }

    }

    //Get Data from Equipment Table
    public ObservableList<REquipment> getData() {

        ObservableList<REquipment> oblist = FXCollections.observableArrayList();
        String sqlQuery = "select * from equipmentr";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                oblist.add(new REquipment(Integer.parseInt(rs.getString("equipmentId")), rs.getString("equipment"), rs.getString("usedDevice"), rs.getString("focalSpotSize"),
                        rs.getString("exposureTime"), rs.getString("filmFocusDistance"), rs.getString("pbScenes")));
            }

        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }
        return oblist;

    }
    
    
    //Get EquipmentName
    public ObservableList<String> getEQName() {

        ObservableList<String> oblist = FXCollections.observableArrayList();
        String sqlQuery = "select equipment from equipmentr";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                oblist.add(rs.getString("equipment"));
            }

        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }
        return oblist;

    }  
    
    
    //Get Information Of Selected Equipment
    public REquipment getEquipment(String eqName) {

        String query = "select * from equipmentr where equipment = ?";

        equipment = null;
        PreparedStatement statement;
        try {

            statement = connection.prepareStatement(query);

            statement.setString(1, eqName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                equipment = new REquipment(rs.getString("usedDevice"), rs.getString("focalSpotSize"), rs.getString("exposureTime"), rs.getString("filmFocusDistance"), rs.getString("pbScenes"));
            }

        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }

        return equipment;
    }
        

}
