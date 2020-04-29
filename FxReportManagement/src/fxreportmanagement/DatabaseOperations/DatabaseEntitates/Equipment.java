/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.DatabaseOperations.DatabaseEntitates;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faruk
 */
public class Equipment {
    
    SimpleIntegerProperty id;
    SimpleStringProperty equipment;
    SimpleStringProperty mpCarrierMedium;
    SimpleStringProperty magTech;
    SimpleStringProperty uvLightIntensity;
    SimpleStringProperty distanceOfLight;

    public Equipment() {
    }

   
    
    
    public Equipment(int equipmentId,String equipment,String mpCarrierMedium,String magTech,String uvLightIntensity,String distanceOfLight) {
        
      this.id = new SimpleIntegerProperty(equipmentId);
      this.equipment = new SimpleStringProperty(equipment);
      this.mpCarrierMedium = new SimpleStringProperty(mpCarrierMedium);
      this.magTech = new SimpleStringProperty(magTech);
      this.uvLightIntensity = new SimpleStringProperty(uvLightIntensity);
      this.distanceOfLight = new SimpleStringProperty(distanceOfLight);
        
        
    }

    
    
    
    
    public int getId() {
        return id.getValue();
    }

    public String getEquipment() {
        return equipment.getValue();
    }

    public String getMpCarrierMedium() {
        return mpCarrierMedium.getValue();
    }

    public String getMagTech() {
        return magTech.getValue();
    }

    public String getUvLightIntencity() {
        return uvLightIntensity.getValue();
    }

    public String getDistanceOfLight() {
        return distanceOfLight.getValue();
    }
    





















}



