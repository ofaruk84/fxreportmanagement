/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseAccess;

import fxreportmanagement.DatabaseOperations.DatabaseEntitates.Equipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Faruk
 */
public class EquipmentDal {

    private Equipment equipment;
    private DBHelper dbHelper;
    private Connection connection;

    public EquipmentDal() {

        equipment = new Equipment();
        dbHelper = new DBHelper();

        try {
            establishConnection();
            System.out.println("Connection Established");
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Establish Connection
    public void establishConnection() throws SQLException {

        connection = dbHelper.getConecConnection();

    }

    //Add Equipment
    public void add(Equipment e) {

        String sqlQuery = "insert into equipmentm (poleDistance,equipment,mpCarrierMedium,magTech,uvLightIntensity,distanceOfLight) values(?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, e.getPoleDistance());
            statement.setString(2, e.getEquipment());
            statement.setString(3, e.getMpCarrierMedium());
            statement.setString(4, e.getMagTech());
            statement.setString(5, e.getUvLightIntencity());
            statement.setString(6, e.getDistanceOfLight());

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Delete Equipment
    public void delete(int id) {
        String sqlQuery = "delete from equipmentm where equipmentId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }

    }

    //Update Equipment
    public void update(int index, Equipment e) {

        String sqlQuery = "update equipmentm set poleDistance = ?,equipment = ?,mpCarrierMedium = ?,magTech = ?,uvLightIntensity = ?,distanceOfLight = ? where equipmentId =?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, e.getPoleDistance());
            statement.setString(2, e.getEquipment());
            statement.setString(3, e.getMpCarrierMedium());
            statement.setString(4, e.getMagTech());
            statement.setString(5, e.getUvLightIntencity());
            statement.setString(6, e.getDistanceOfLight());
            statement.setInt(7, index);

            statement.executeUpdate();
        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }

    }

    //Get Data from Equipment Table
    public ObservableList<Equipment> getData() {

        ObservableList<Equipment> oblist = FXCollections.observableArrayList();
        String sqlQuery = "select * from equipmentm";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                oblist.add(new Equipment(Integer.parseInt(rs.getString("equipmentId")), rs.getString("poleDistance"), rs.getString("equipment"), rs.getString("mpCarrierMedium"),
                        rs.getString("magTech"), rs.getString("uvLightIntensity"), rs.getString("distanceOfLight")));
            }

        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }
        return oblist;

    }
    
    //Get EquipmentName
    public ObservableList<String> getEQName() {

        ObservableList<String> oblist = FXCollections.observableArrayList();
        String sqlQuery = "select equipment from equipmentm";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                oblist.add(rs.getString("equipment"));
            }

        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }
        return oblist;

    }
    
    //Get Information Of Selected Equipment
    public Equipment getEquipment(String eqName) {

        String query = "select * from equipmentm where equipment = ?";

        equipment = null;
        PreparedStatement statement;
        try {

            statement = connection.prepareStatement(query);

            statement.setString(1, eqName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                equipment = new Equipment(rs.getString("poleDistance"), rs.getString("mpCarrierMedium"), rs.getString("magTech"), rs.getString("uvLightIntensity"), rs.getString("distanceOfLight"));
            }

        } catch (SQLException ex) {
            DBHelper.showErrorMessage(ex);
        }

        return equipment;
    }

}
