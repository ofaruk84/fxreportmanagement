



package fxreportmanagement.Report2.Entitates;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*

 * @author Faruk 

 * Ömer Faruk Korkmaz 
 * 170503014

*/


public class InspectionResults {
    
    
    
    //fields
    private static SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    private SimpleStringProperty weldNo;
    private SimpleStringProperty testLength;
    private SimpleStringProperty weldingProcess;
    private SimpleStringProperty thickness;
    private SimpleStringProperty diameter;
    private SimpleStringProperty defectType;
    private SimpleStringProperty defectLoc;
    private SimpleStringProperty result;

 
public InspectionResults(){



}

public InspectionResults(String weldNo,String testLength,String weldingProcess,String thickness,String diameter,String defectType,String defectLoc,String result){

    int id = this.id.get();
    id++;
    this.id.set(id);
    this.weldNo = new SimpleStringProperty(weldNo);
    this.testLength= new SimpleStringProperty(testLength);
    this.weldingProcess = new SimpleStringProperty(weldingProcess);
    this.thickness = new SimpleStringProperty(thickness);
    this.diameter = new SimpleStringProperty(diameter);
    this.defectType = new SimpleStringProperty(defectType);
    this.defectLoc = new SimpleStringProperty(defectLoc);
    this.result = new SimpleStringProperty(result);

}
    
    
 
     
    
    public static String getId() {
        return Integer.toString(id.get());
    }


    public String getWeldNo() {
        return weldNo.get();
    }

     void setWeldNo(String weldNo) {
        this.weldNo.set(weldNo);
    }

  
    public String getTestLength() {
        return testLength.get();
    }
    
    public String getWeldingProcess() {
        return weldingProcess.getValue();
    }
    
    public void setWeldingProcess(String weldingProcess){
        this.weldingProcess.setValue(weldingProcess);
    }

    public void setTestLength(String testLength) {
        this.testLength.set(testLength);
    }


    public String getThickness() {
        return thickness.get();
    }


    public void setThickness(String thickness) {
        this.thickness.set(thickness);
    }


    public String getDiameter() {
        return diameter.get();
    }


    public void setDiameter(String diameter) {
        this.diameter.set(diameter);
    }


    public String getDefectType() {
        return defectType.get();
    }


    public void setDefectType(String defectType) {
        this.defectType.set(defectType);
    }


    public String getDefectLoc() {
        return defectLoc.get();
    }


    public void setDefectLoc(String defectLoc) {
        this.defectLoc.set(defectLoc);
    }


    public String getResult() {
        return result.get();
    }


    public void setResult(String result) {
        this.result.set(result);
    }

 

    
    
}
