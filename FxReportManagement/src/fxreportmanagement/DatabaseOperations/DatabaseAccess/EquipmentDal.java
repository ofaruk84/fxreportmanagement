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
import java.util.logging.Level;
import java.util.logging.Logger;
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
 public void establishConnection() throws SQLException{
     
    
       connection = dbHelper.getConecConnection();
        
 }
 
 
    //Add Equipment
    public void add(Equipment e){
        
      String sqlQuery ="insert into equipmentm (equipment,mpCarrierMedium,magTech,uvLightIntensity,distanceOfLight) values(?,?,?,?,?)";
      
    try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1,e.getEquipment());
        statement.setString(2, e.getMpCarrierMedium());
        statement.setString(3,e.getMagTech());
        statement.setString(4,e.getUvLightIntencity());
        statement.setString(5,e.getDistanceOfLight());
 
        
        statement.executeUpdate();
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    } 
  
    }
    
    //Delete Equipment
    public void delete(int id){
       String sqlQuery ="delete from equipmentm where equipmentId = ?";
      
    try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1,id);

        statement.executeUpdate();
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    }
    
    }
    
    
    //Update Equipment
    public void update(int index,Equipment e){

      String sqlQuery ="update equipmentm set equipment = ?,mpCarrierMedium = ?,magTech = ?,uvLightIntensity = ?,distanceOfLight = ? where employeeId =?";
      
    try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1,e.getEquipment());
        statement.setString(2, e.getMpCarrierMedium());
        statement.setString(3,e.getMagTech());
        statement.setString(4,e.getUvLightIntencity());
        statement.setString(5,e.getDistanceOfLight());
        statement.setInt(6, index);
        
        statement.executeUpdate();
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    }         
        
    }


    //Get Data from Equipment Table
    public ObservableList<Equipment> getData(){
     
     ObservableList<Equipment> oblist = FXCollections.observableArrayList();
     String sqlQuery ="select * from equipmentm";
     
    try {
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            oblist.add(new Equipment(Integer.parseInt(rs.getString("equipmentId")),rs.getString("equipment"), rs.getString("mpCarrierMedium"),
                    rs.getString("magTech"), rs.getString("uvLightIntensity"), rs.getString("distanceOfLight")));
        }
        
    } catch (SQLException ex) {
        dbHelper.showErrorMessage(ex);
    }
    return oblist;    
        
    }    
    
    
    
    
 




}