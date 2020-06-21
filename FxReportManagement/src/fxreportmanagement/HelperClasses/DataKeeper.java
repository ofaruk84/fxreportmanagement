/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

import fxreportmanagement.Report2.Entitates.TableViewEntitates.ProjectName;
import fxreportmanagement.Report2.Entitates.TableViewEntitates.StageOfExamination;
import fxreportmanagement.Report2.Entitates.TableViewEntitates.SurfaceCondition;
import javafx.collections.ObservableList;

/**
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz
 * 170503014
 */
public class DataKeeper {

    private static ObservableList<ProjectName> projectNames;

    private static ObservableList<SurfaceCondition> surfaceConditions;

    private static ObservableList<StageOfExamination> stageOfExaminations;

    public static ObservableList<ProjectName> getProjectNames() {
        return projectNames;
    }

    public static void setProjectNames(ObservableList<ProjectName> projectNames) {
        DataKeeper.projectNames = projectNames;
    }

    public static ObservableList<SurfaceCondition> getSurfaceConditions() {
        return surfaceConditions;
    }

    public static void setSurfaceConditions(ObservableList<SurfaceCondition> surfaceConditions) {
        DataKeeper.surfaceConditions = surfaceConditions;
    }

    public static ObservableList<StageOfExamination> getStageOfExaminations() {
        return stageOfExaminations;
    }

    public static void setStageOfExaminations(ObservableList<StageOfExamination> stageOfExaminations) {
        DataKeeper.stageOfExaminations = stageOfExaminations;
    }

}
