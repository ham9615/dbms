/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import f1dbms.SQLConnectionFile.*;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class SecondScreenController implements Initializable {
        
    @FXML Pane secondPane;
    @FXML
    private TextField searchfield;
    @FXML
    private Button search;
    @FXML
    private RadioButton driver;
    @FXML
    private RadioButton car;
    @FXML
    private RadioButton champion;
    @FXML
    private RadioButton constructor;
 
    @FXML
    private Button addButton;
    @FXML
    private Button modify;
    @FXML
    private Button remove;
    
    @FXML public void driverList(MouseEvent event){
        
        Pane driverButtonPane = null;
        try {
            driverButtonPane = FXMLLoader.load(getClass().getResource("driverTable.fxml"));
        } catch (IOException ex) {
            System.out.print("Entering d");
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        secondPane.getChildren().setAll(driverButtonPane);
        
    }
    
    @FXML public void constructorList(MouseEvent event){
        Pane constructorButtonPane = null;
        try{
           constructorButtonPane  = FXMLLoader.load(getClass().getResource("constructorTable.fxml"));
            
        }
        catch(IOException ex){
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        secondPane.getChildren().setAll(constructorButtonPane);
    }
    
     @FXML public void calendarList(MouseEvent event){
        Pane calendarButtonPane = null;
        try{
           calendarButtonPane  = FXMLLoader.load(getClass().getResource("calendarTable.fxml"));
            
        }
        catch(IOException ex){
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        secondPane.getChildren().setAll(calendarButtonPane);
    }
      
     
     
     
    @FXML
     public void deployDisplay(MouseEvent event) throws IOException{
              radioLoader rl = new radioLoader();
         String search = searchfield.getText();
         
         if(driver.isSelected()){
           
            rl.createInstance(search, "driverViewer.fxml",1);
             
         }
         else if(champion.isSelected()){
             
         }
         else if(car.isSelected()){
             rl.createInstance(search, "carViewer.fxml",3);
             
             
         }else if(constructor.isSelected())
         {
             rl.createInstance(search, "constructorViewer.fxml",2);
         }
         else{
             
         }
         
     }
    
    /**
     * Initializes the controller class.
     */
     //You need to make changes here
     @FXML public void addDrop(MouseEvent event) {
                    
         
         Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("deployScreen.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       secondPane.getChildren().setAll(viewButtonPane);
                
        
      
        
        
                 }
     
     @FXML public void deployRemove(){
      
         Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("carDeploy.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       secondPane.getChildren().setAll(viewButtonPane);
     }
     
     @FXML public void deployModify(){
         Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("constructorDeploy.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       secondPane.getChildren().setAll(viewButtonPane);
     }
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      modify.setVisible(false);
    }    
    
}
