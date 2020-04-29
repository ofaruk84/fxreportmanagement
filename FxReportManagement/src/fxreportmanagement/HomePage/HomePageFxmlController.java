/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HomePage;

import fxreportmanagement.HelperClasses.FxmlPageLoader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faruk
 */
public class HomePageFxmlController implements Initializable {


    @FXML
    private Label lblDate;
    @FXML
    private Button btnOpen;
    @FXML
    private RadioButton rbRadiographic;
    @FXML
    private ToggleGroup report;
    @FXML
    private RadioButton rbMagnetic;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        getDate();
        
    }    


    
    
    //Open Selected Report
    @FXML
    private void handleBtnOpen(ActionEvent event) throws IOException {
        
        String fileUrl = null;
    
        if(rbMagnetic.isSelected()){
         
          fileUrl ="Report2/Report2Fxml";
          FxmlPageLoader.loadPage(fileUrl);
          
           
        }
        
        if(rbRadiographic.isSelected()){
           
         //fileUrl = "Report1/Report1Fxml";
        }
        

        
        
        
    }
    
    public void getDate(){
    
        LocalDate date = LocalDate.now();
        
        String time = date.toString();
        
        lblDate.setText(time);
    
    }

}
