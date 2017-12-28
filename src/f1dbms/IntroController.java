/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class IntroController implements Initializable {

    @FXML
    private MediaView mv;
    MediaPlayer mp;
    Media me;
    @FXML
    private Pane rootpane;
    @FXML
    private Button move;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        move.setVisible(false);
         String path = new File("src\\intro.mp4").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mp.setAutoPlay(true);
        mv.setMediaPlayer(mp);
        mp.play();
        mp.setOnEndOfMedia(new Runnable() {
             @Override
             public void run() {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            move.setVisible(true);
             
             }
         });
        
        
        
    }

@FXML public void nextFun(){
    Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       rootpane.getChildren().setAll(viewButtonPane);
}    
    
}
