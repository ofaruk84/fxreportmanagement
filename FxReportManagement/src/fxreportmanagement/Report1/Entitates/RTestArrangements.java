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
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class RTestArrangements {
    
    
    private SimpleStringProperty ta1;
    private SimpleStringProperty ta2;
    private SimpleStringProperty ta3;
    private SimpleStringProperty ta4;
    private SimpleStringProperty ta5;
    private SimpleStringProperty ta6;
    private SimpleStringProperty description;
    private SimpleStringProperty date;
    
    
    public RTestArrangements(String ta1,String ta2,String ta3,String ta4,String ta5,String ta6,String description,String date){
        
        this.ta1 = new SimpleStringProperty(ta1);
        this.ta2 = new SimpleStringProperty(ta2);
        this.ta3 = new SimpleStringProperty(ta3);
        this.ta4 = new SimpleStringProperty(ta4);
        this.ta5 = new SimpleStringProperty(ta5);
        this.ta6 = new SimpleStringProperty(ta6);
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(date);
        
    }

    public String getTa1() {
        return ta1.getValue();
    }

    public String getTa2() {
        return ta2.getValue();
    }

    public String getTa3() {
        return ta3.getValue();
    }

    public String getTa4() {
        return ta4.getValue();
    }

    public String getTa5() {
        return ta5.getValue();
    }

    public String getTa6() {
        return ta6.getValue();
    }

    public String getDescription() {
        return description.getValue();
    }

    public String getDate() {
        return date.getValue();
    }
    
    
}
