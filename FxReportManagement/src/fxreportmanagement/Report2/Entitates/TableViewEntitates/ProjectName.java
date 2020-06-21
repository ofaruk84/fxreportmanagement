/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2.Entitates.TableViewEntitates;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class ProjectName {

    private SimpleStringProperty projectName;

    public ProjectName(String projectName) {

        this.projectName = new SimpleStringProperty(projectName);

    }

    public String getProjectName() {

        return projectName.getValue();
    }

    @Override
    public String toString() {
        return projectName.getValue();
    }
    
    
}
