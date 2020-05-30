/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import fxreportmanagement.Report1.Entitates.RTestArrangements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Faruk
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleBtnSubmitAction(ActionEvent event) {
    }
    
    
    private RTestArrangements getRTestArrangements() {

        String ta1 = Boolean.toString(getTa1());
        String ta2 = Boolean.toString(getTa2());
        String ta3 = Boolean.toString(getTa3());
        String ta4 = Boolean.toString(getTa4());
        String ta5 = Boolean.toString(getTa5());
        String ta6 = Boolean.toString(getTa6());
        String description = txtDescription.getText();
        String date = lblDate.getText();
        
        return new RTestArrangements(ta1, ta2, ta3, ta4, ta5, ta6, description, date);
        
    }

    private boolean getTa1() {

        return rbTa1.isSelected();
    }

    private boolean getTa2() {

        return rbTa2.isSelected();
    }

    private boolean getTa3() {

        return rbTa3.isSelected();
    }

    private boolean getTa4() {

        return rbTa4.isSelected();
    }

    private boolean getTa5() {

        return rbTa5.isSelected();
    }

    private boolean getTa6() {

        return rbTa6.isSelected();
    }

}
