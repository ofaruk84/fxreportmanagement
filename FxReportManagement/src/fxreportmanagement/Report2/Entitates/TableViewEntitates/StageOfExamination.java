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
 */
public class StageOfExamination {

    private SimpleStringProperty stageOfExamination;

    public StageOfExamination(String stageOfExamination) {

        this.stageOfExamination = new SimpleStringProperty(stageOfExamination);
    }

    public String getStageOfExamination() {
        return stageOfExamination.getValue();
    }

}
