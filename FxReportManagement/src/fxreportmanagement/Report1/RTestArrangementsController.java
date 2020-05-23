/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
    
}
