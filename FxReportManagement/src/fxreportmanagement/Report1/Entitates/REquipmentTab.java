/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1.Entitates;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faruk
 */
public class REquipmentTab {

    private SimpleStringProperty equipment;
    private SimpleStringProperty usedDevice;
//    private SimpleStringProperty ri12;
//    private SimpleStringProperty se75;
//    private SimpleStringProperty xRay;

    private SimpleStringProperty deviceEnergy;
    private SimpleStringProperty pbScenes;
    private SimpleStringProperty exposureTime;
    private SimpleStringProperty filmFocusDistance;
    private SimpleStringProperty filters;
    private SimpleStringProperty heatTreatment;
    private SimpleStringProperty filmBrand;
    private SimpleStringProperty filmType;
//    private SimpleStringProperty d4;
//    private SimpleStringProperty d5;
//    private SimpleStringProperty d7;
    private SimpleStringProperty en;
    private SimpleStringProperty astm;
    private SimpleStringProperty sourceSide;
    private SimpleStringProperty filmSide;
    private SimpleStringProperty automatic;
    private SimpleStringProperty manual;
    private SimpleStringProperty temperature;
    private SimpleStringProperty x12;
    private SimpleStringProperty x16;
    private SimpleStringProperty x24;
    private SimpleStringProperty x36;
    private SimpleStringProperty x48;
    private SimpleStringProperty x40;
    private SimpleStringProperty suitibleFilm;
    private SimpleStringProperty repairFilm;

    public REquipmentTab(String equipment, String usedDevice, /*String ri12, String se75, String xRay*/ String deviceEnergy, String pbScenes, String exposureTime, String filmFocusDistance,
            String filters, String heatTreatment, String filmBrand, /*String d4, String d5, String d7*/ String filmType, String en, String astm, String sourceSide,
            String filmSide, String automatic, String manual, String temperature, String x12, String x16, String x24, String x36,
            String x48, String x40, String suitibleFilm, String repairFilm) {

        this.equipment = new SimpleStringProperty(equipment);
        this.usedDevice = new SimpleStringProperty(usedDevice);
        this.deviceEnergy = new SimpleStringProperty(deviceEnergy);
//        this.ri12 = new SimpleStringProperty(ri12);
//        this.se75 = new SimpleStringProperty(se75);
//        this.xRay = new SimpleStringProperty(xRay);
        this.pbScenes = new SimpleStringProperty(pbScenes);
        this.exposureTime = new SimpleStringProperty(exposureTime);
        this.filmFocusDistance = new SimpleStringProperty(filmFocusDistance);
        this.filters = new SimpleStringProperty(filters);
        this.heatTreatment = new SimpleStringProperty(heatTreatment);
        this.filmBrand = new SimpleStringProperty(filmBrand);
        this.filmType = new SimpleStringProperty(filmType);
//        this.d4 = new SimpleStringProperty(d4);
//        this.d5 = new SimpleStringProperty(d5);
//        this.d7 = new SimpleStringProperty(d7);
        this.en = new SimpleStringProperty(en);
        this.astm = new SimpleStringProperty(astm);
        this.sourceSide = new SimpleStringProperty(sourceSide);
        this.filmSide = new SimpleStringProperty(filmSide);
        this.automatic = new SimpleStringProperty(automatic);
        this.manual = new SimpleStringProperty(manual);
        this.temperature = new SimpleStringProperty(temperature);
        this.x12 = new SimpleStringProperty(x12);
        this.x16 = new SimpleStringProperty(x16);
        this.x24 = new SimpleStringProperty(x24);
        this.x36 = new SimpleStringProperty(x36);
        this.x48 = new SimpleStringProperty(x48);
        this.x40 = new SimpleStringProperty(x40);
        this.suitibleFilm = new SimpleStringProperty(suitibleFilm);
        this.repairFilm = new SimpleStringProperty(repairFilm);

    }

    public String getEquipment() {
        return equipment.getValue();
    }

    public String getUsedDevice() {
        return usedDevice.getValue();
    }
    public String getDeviceEnergy() {
        return deviceEnergy.getValue();
    }
//    public String getRi12() {
//        return ri12.getValue();
//    }
//
//    public String getSe75() {
//        return se75.getValue();
//    }
//
//    public String getxRay() {
//        return xRay.getValue();
//    }
    public String getPbScenes() {
        return pbScenes.getValue();
    }

    public String getExposureTime() {
        return exposureTime.getValue();
    }

    public String getFilmFocusDistance() {
        return filmFocusDistance.getValue();
    }

    public String getFilters() {
        return filters.getValue();
    }

    public String getHeatTreatment() {
        return heatTreatment.getValue();
    }

    public String getFilmBrand() {
        return filmBrand.getValue();
    }

    public String getFilmType() {
        return filmType.getValue();
    }
//
//    public String getD4() {
//        return d4.getValue();
//    }
//
//    public String getD5() {
//        return d5.getValue();
//    }
//
//    public String getD7() {
//        return d7.getValue();
//    }

    public String getEn() {
        return en.getValue();
    }

    public String getAstm() {
        return astm.getValue();
    }

    public String getSourceSide() {
        return sourceSide.getValue();
    }

    public String getFilmSide() {
        return filmSide.getValue();
    }

    public String getAutomatic() {
        return automatic.getValue();
    }

    public String getManual() {
        return manual.getValue();
    }

    public String getTemperature() {
        return temperature.getValue();
    }

    public String getX12() {
        return x12.getValue();
    }

    public String getX16() {
        return x16.getValue();
    }

    public String getX24() {
        return x24.getValue();
    }

    public String getX36() {
        return x36.getValue();
    }

    public String getX48() {
        return x48.getValue();
    }

    public String getX40() {
        return x40.getValue();
    }

    public String getSuitibleFilm() {
        return suitibleFilm.getValue();
    }

    public String getRepairFilm() {
        return repairFilm.getValue();
    }

}
