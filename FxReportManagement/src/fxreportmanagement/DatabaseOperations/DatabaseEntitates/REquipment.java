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
 * 
 * Ömer Faruk Korkmaz
 * 170503014
 */
public class REquipment {

    SimpleIntegerProperty id;
    SimpleStringProperty equipment;
    SimpleStringProperty usedDevice;
    SimpleStringProperty focalSpotSize;
    SimpleStringProperty exposureTime;
    SimpleStringProperty filmFocusDistance;
    SimpleStringProperty pbScenes;

    public REquipment() {
    }

    public REquipment(String equipment) {

        this.equipment = new SimpleStringProperty(equipment);

    }

    public REquipment(String usedDevice, String focalSpotSize,
            String exposureTime, String filmFocusDistance, String pbScenes) {

        this.usedDevice = new SimpleStringProperty(usedDevice);
        this.focalSpotSize = new SimpleStringProperty(focalSpotSize);
        this.exposureTime = new SimpleStringProperty(exposureTime);
        this.filmFocusDistance = new SimpleStringProperty(filmFocusDistance);
        this.pbScenes = new SimpleStringProperty(pbScenes);

    }

    public REquipment(int id, String equipment, String usedDevice, String focalSpotSize,
            String exposureTime, String filmFocusDistance, String pbScenes) {

        this.id = new SimpleIntegerProperty(id);
        this.equipment = new SimpleStringProperty(equipment);
        this.usedDevice = new SimpleStringProperty(usedDevice);
        this.focalSpotSize = new SimpleStringProperty(focalSpotSize);
        this.exposureTime = new SimpleStringProperty(exposureTime);
        this.filmFocusDistance = new SimpleStringProperty(filmFocusDistance);
        this.pbScenes = new SimpleStringProperty(pbScenes);

    }

    public int getId() {
        return id.getValue();
    }

    public String getEquipment() {
        return equipment.getValue();
    }

    public String getUsedDevice() {
        return usedDevice.getValue();
    }

    public String getFocalSpotSize() {
        return focalSpotSize.getValue();
    }

    public String getExposureTime() {
        return exposureTime.getValue();
    }

    public String getFilmFocusDistance() {
        return filmFocusDistance.getValue();
    }

    public String getPbScenes() {
        return pbScenes.getValue();
    }

}
