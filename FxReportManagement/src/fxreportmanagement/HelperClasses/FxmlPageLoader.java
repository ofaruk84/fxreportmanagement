/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxreportmanagement.HelperClasses;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Faruk
 */
public class FxmlPageLoader {

    private static Pane view;

    public static Pane getPage(String fileName) {

        try {
            URL fileUrl = fxreportmanagement.FxReportManagement.class.getResource("/fxreportmanagement/Report2/" + fileName + ".fxml");
            view = new FXMLLoader().load(fileUrl);
        } catch (IOException ex) {
            Logger.getLogger(FxmlPageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return view;

    }

    public static void loadPage(String fileLoc) {

        URL fileUrl = fxreportmanagement.FxReportManagement.class.getResource("/fxreportmanagement/" + fileLoc + ".fxml");
        Parent root = null;
        try {
            root = FXMLLoader.load(fileUrl);
        } catch (IOException ex) {
            Logger.getLogger(FxmlPageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static Pane getPageforAdmin(String fileName) {

        try {
            URL fileUrl = fxreportmanagement.FxReportManagement.class.getResource("/fxreportmanagement/Login/AdminLogin/" + fileName + ".fxml");
            view = new FXMLLoader().load(fileUrl);
        } catch (IOException ex) {
            Logger.getLogger(FxmlPageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return view;

    }

    public static void loadSameScene(Node node, String fileName) {

        URL fileUrl = fxreportmanagement.FxReportManagement.class.getResource("/fxreportmanagement/" + fileName + ".fxml");
        Parent root = null;
        try {
            root = FXMLLoader.load(fileUrl);
        } catch (IOException ex) {
            Logger.getLogger(FxmlPageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

}
