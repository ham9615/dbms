/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import f1dbms.SQLConnectionFile.sqlConnection;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


/**
 *
 * @author ADI
 */
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class FXMLDocumentController implements Initializable {
    @FXML Pane rootPane;
    @FXML TextField idField;
    @FXML PasswordField passwordField;
    Stage  stage; 
    Parent root;
    @FXML Button button;
    
 
    
    
    @FXML public void viewButton(MouseEvent event) throws SQLException {
        Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
             sqlConnection.ConnectDb1();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootPane.getChildren().setAll(viewButtonPane);
    }
    
    @FXML public void loginButton(MouseEvent event) throws IOException, SQLException{
        if(idField.getText().equals("hamster")&&passwordField.getText().equals("hammertime")){
            Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
             sqlConnection.ConnectDb1();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootPane.getChildren().setAll(viewButtonPane);
        }else{
             stage = new Stage();
   root = FXMLLoader.load(getClass().getResource("loginDeniedPopup.fxml"));
   stage.setScene(new Scene(root));
   stage.setTitle("My modal window");
   stage.initModality(Modality.APPLICATION_MODAL);
   stage.initOwner(button.getScene().getWindow());
   stage.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
