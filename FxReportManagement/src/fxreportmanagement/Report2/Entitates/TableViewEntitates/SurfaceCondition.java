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
public class SurfaceCondition {

    private SimpleStringProperty surfaceCondition;

    public SurfaceCondition(String surfaceCondition) {

        this.surfaceCondition = new SimpleStringProperty(surfaceCondition);

    }

    public String getSurfaceCondition() {
        return surfaceCondition.getValue();
    }

}
