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
public class RInspectionResults {

    private SimpleStringProperty shootingArea;

    private SimpleStringProperty filmNo;

    private SimpleStringProperty materialType;

    private SimpleStringProperty weldingType;

    private SimpleStringProperty welderNo;

    private SimpleStringProperty position;

    private SimpleStringProperty thickness;

    private SimpleStringProperty IQI;

    private SimpleStringProperty visibleIQI;

    private SimpleStringProperty density;

    private SimpleStringProperty x12;

    private SimpleStringProperty x16;

    private SimpleStringProperty x24;

    private SimpleStringProperty x36;

    private SimpleStringProperty x48;

    private SimpleStringProperty x40;

    private SimpleStringProperty defectLoc;

    private SimpleStringProperty defectType;

    private SimpleStringProperty preEvaluation;

    private SimpleStringProperty finalEvaluation;

    public RInspectionResults(String shootingArea, String filmNo, String materialType, String weldingType,
            String welderNo, String position, String thickness, String IQI,String visibleIQI,
            String density, String x12, String x16, String x24, String x36,
            String x48, String x40, String defectLoc, String defectType,
            String preEvaluation, String finalEvaluation) {

        this.shootingArea = new SimpleStringProperty(shootingArea);
        
        this.filmNo = new SimpleStringProperty(filmNo);
        
        this.materialType = new SimpleStringProperty(materialType);
        
        this.weldingType = new SimpleStringProperty(weldingType);
        
        this.welderNo = new SimpleStringProperty(welderNo);
        
        this.position = new SimpleStringProperty(position);
        
        this.thickness = new SimpleStringProperty(thickness);
        
        this.IQI = new SimpleStringProperty(IQI);
        
        this.visibleIQI = new SimpleStringProperty(visibleIQI);
        
        this.density = new SimpleStringProperty(density);
        
        this.x12 = new SimpleStringProperty(x12);
        
        this.x16 = new SimpleStringProperty(x16);
        
        this.x24 = new SimpleStringProperty(x24);
        
        this.x36 = new SimpleStringProperty(x36);
        
        this.x48 = new SimpleStringProperty(x40);
        
        this.x40 = new SimpleStringProperty(x40);
        
        this.defectLoc = new SimpleStringProperty(defectLoc);
        
        this.defectType = new SimpleStringProperty(defectType);
        
        this.preEvaluation = new SimpleStringProperty(preEvaluation);
        
        this.finalEvaluation = new SimpleStringProperty(finalEvaluation);

    }

}