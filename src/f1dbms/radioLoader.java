/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ADI
 */
public class radioLoader {
    public void createInstance(String search,String loc,int i) throws IOException{
        
        Stage primaryStage = new Stage();
             FXMLLoader loader = new FXMLLoader();
             Pane root = loader.load(getClass().getResource(loc).openStream());
             if(i == 1){
                 DriverViewerController dvc = (DriverViewerController)loader.getController();
             dvc.getParam(search);
             }
             else if(i==2){
                 ConstructorViewerController c = (ConstructorViewerController)loader.getController();
                 c.getParam(search);
             }
             else if(i==3){
                 CarViewerController cvc = (CarViewerController)loader.getController();
                 cvc.getParam(search);
             }
             else if(i==4){
                 
             }
             Scene scene = new Scene(root);
             primaryStage.setScene(scene);
             primaryStage.show();
        
    }
}
