/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2.Entitates;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faruk
 */
public class CustomerOptions {
    
    
    private SimpleStringProperty projectName;
    
    private SimpleStringProperty surfaceCondition;
    
    private SimpleStringProperty stageOfExamination;

   
    
    public CustomerOptions(String projectName,String surfaceCondition,String stageOfExamination) {
        
        this.projectName = new SimpleStringProperty(projectName);
        
        this.surfaceCondition = new SimpleStringProperty(surfaceCondition);
        
        this.stageOfExamination = new SimpleStringProperty(stageOfExamination);
        
    }
    
    public String getProjectName(){
        
        return  projectName.getValue();
    }

    public String getSurfaceCondition() {
        return surfaceCondition.getValue();
    }

    public String getStageOfExamination() {
        return stageOfExamination.getValue();
    }
    
    
    
    
    
}
