/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport1;
import fxreportmanagement.Report1.Entitates.RTestArrangements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Faruk
 * 
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class RTestArrangementsController implements Initializable {

    @FXML
    private JFXRadioButton rbTa1;
    @FXML
    private JFXRadioButton rbTa2;
    @FXML
    private JFXRadioButton rbTa3;
    @FXML
    private JFXRadioButton rbTa4;
    @FXML
    private JFXRadioButton rbTa5;
    @FXML
    private JFXRadioButton rbTa6;
    @FXML
    private TextField txtDescription;
    @FXML
    private JFXButton btnSubmit;
    @FXML
    private Label lblDate;
    @FXML
    private ToggleGroup testArrangements;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleBtnSubmitAction(ActionEvent event) {
        
        ExcelExporterAsposeReport1.setTestArrangements(getRTestArrangements());
        System.out.println("R1 Test Arrangements Setted");
    }
    
    
    private RTestArrangements getRTestArrangements() {

        String ta1 = getTa1();
        String ta2 = getTa2();
        String ta3 = getTa3();
        String ta4 = getTa4();
        String ta5 = getTa5();
        String ta6 = getTa6();
        String description = txtDescription.getText();
        String date = lblDate.getText();
        
        return new RTestArrangements(ta1, ta2, ta3, ta4, ta5, ta6, description, date);
        
    }
    
    
    
    
    private String getTa1() {

        String res = "0";

        if (rbTa1.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getTa2() {

        String res = "0";

        if (rbTa2.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getTa3() {

        String res = "0";

        if (rbTa3.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getTa4() {

        String res = "0";

        if (rbTa4.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getTa5() {

          String res = "0";

        if (rbTa5.isSelected()) {
            res = "1";
        }
        return res;
    }

    private String getTa6() {

        String res = "0";

        if (rbTa6.isSelected()) {
            res = "1";
        }
        return res;
    }

}
