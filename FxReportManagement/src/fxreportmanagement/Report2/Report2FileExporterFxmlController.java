/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.Report2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fxreportmanagement.HelperClasses.ExcelExporterAsposeReport2;
import fxreportmanagement.HelperClasses.PdfExporter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Faruk
 * 
 * Ömer Faruk Korkmaz 
 * 170503014
 */
public class Report2FileExporterFxmlController implements Initializable {

    @FXML
    private JFXTextField txtFileName;
    @FXML
    private JFXButton btnExcel;
    @FXML
    private JFXButton btnPDF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btnPDF.setVisible(false);
    }

    @FXML
    private void handleBtnExcelAction(ActionEvent event) {
        
        ExcelExporterAsposeReport2.exportGUI(txtFileName.getText());
       
        btnPDF.setVisible(true);
    }

    @FXML
    private void handleBtnPDFAction(ActionEvent event) {
        
        System.out.println("girdi");
        
        PdfExporter.exportPDF(txtFileName.getText());
        System.out.println("created");
        
    }

}
