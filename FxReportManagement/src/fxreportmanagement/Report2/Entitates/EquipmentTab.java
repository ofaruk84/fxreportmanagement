
package fxreportmanagement.Report2.Entitates;

import javafx.beans.property.SimpleStringProperty;


public class EquipmentTab {
    
    private SimpleStringProperty poleDistance;
    private SimpleStringProperty equipment;
    private SimpleStringProperty mpCarrierMedium;
    private SimpleStringProperty magTech;
    private SimpleStringProperty uvLightIntesity;
    private SimpleStringProperty distanceOfLight;
    private SimpleStringProperty examinationArea;
    private SimpleStringProperty currentType;
    private SimpleStringProperty luxmeter;
    private SimpleStringProperty testMedium;
    private SimpleStringProperty demagnetization;
    private SimpleStringProperty heatTreatment;
    private SimpleStringProperty surfaceTemparature;
    private SimpleStringProperty gaussFieldStrength;
    private SimpleStringProperty surfaceCondition;
    private SimpleStringProperty identicationOfLightEquipment;
    private SimpleStringProperty liftingTestDateNo;
    private SimpleStringProperty weldType;
    private SimpleStringProperty standartDevitions;
    private SimpleStringProperty inspectionDates;
    private SimpleStringProperty description;

    public EquipmentTab() {
    }
    
    
    public EquipmentTab(String poleDitance,String equipment,String mpCarrierMedium,String magTech,String uvLightIntensity,String distanceOfLight,
           String examinationArea,String currentType,String luxmeter,String testMedium,String demagnetization,String heatTreatmenet,
           String surfaceTemperature,String gaussFieldStrength,String surfaceCondition,String identifactionOfLightEquipment,
           String liftingTestDateNo,String weldType,String standartDevitions,String inspectionDates,String description){
        
        this.poleDistance = new SimpleStringProperty(poleDitance);
        this.equipment = new SimpleStringProperty(equipment);
        this.mpCarrierMedium = new SimpleStringProperty(mpCarrierMedium);
        this.magTech = new SimpleStringProperty(magTech);
        this.uvLightIntesity = new SimpleStringProperty(uvLightIntensity);
        this.distanceOfLight = new SimpleStringProperty(distanceOfLight);
        this.examinationArea = new SimpleStringProperty(examinationArea);
        this.currentType = new SimpleStringProperty(currentType);
        this.luxmeter = new SimpleStringProperty(luxmeter);
        this.testMedium = new SimpleStringProperty(testMedium);
        this.demagnetization = new SimpleStringProperty(demagnetization);
        this.heatTreatment = new SimpleStringProperty(heatTreatmenet);
        this.surfaceTemparature = new SimpleStringProperty(surfaceTemperature);
        this.gaussFieldStrength = new SimpleStringProperty(gaussFieldStrength);
        this.surfaceCondition = new SimpleStringProperty(surfaceCondition);
        this.identicationOfLightEquipment = new SimpleStringProperty(identifactionOfLightEquipment);
        this.liftingTestDateNo = new SimpleStringProperty(liftingTestDateNo);
        this.weldType = new SimpleStringProperty(weldType);
        this.standartDevitions = new SimpleStringProperty(standartDevitions);
        this.inspectionDates = new SimpleStringProperty(inspectionDates);
        this.description = new SimpleStringProperty(description);        
        
        
        }

    public String getPoleDistance() {
        return poleDistance.getValue();
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

    public String getUvLightIntesity() {
        return uvLightIntesity.getValue();
    }

    public String getDistanceOfLight() {
        return distanceOfLight.getValue();
    }

    public String getExaminationArea() {
        return examinationArea.getValue();
    }

    public String getCurrentType() {
        return currentType.getValue();
    }

    public String getLuxmeter() {
        return luxmeter.getValue();
    }

    public String getTestMedium() {
        return testMedium.getValue();
    }

    public String getDemagnetization() {
        return demagnetization.getValue();
    }

    public String getHeatTreatment() {
        return heatTreatment.getValue();
    }

    public String getSurfaceTemparature() {
        return surfaceTemparature.getValue();
    }

    public String getGaussFieldStrength() {
        return gaussFieldStrength.getValue();
    }

    public String getSurfaceCondition() {
        return surfaceCondition.getValue();
    }

    public String getIdenticationOfLightEquipment() {
        return identicationOfLightEquipment.getValue();
    }

    public String getLiftingTestDateNo() {
        return liftingTestDateNo.getValue();
    }

    public String getWeldType() {
        return weldType.getValue();
    }

    public String getStandartDevitions() {
        return standartDevitions.getValue();
    }

    public String getInspectionDates() {
        return inspectionDates.getValue();
    }

    public String getDescription() {
        return description.getValue();
    }
    
        
    
}
