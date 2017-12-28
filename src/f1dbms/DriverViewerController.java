/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import f1dbms.SQLConnectionFile.sqlConnection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class DriverViewerController implements Initializable {

    @FXML
    private ImageView driverimage;
    @FXML
    private Text driverworldchamp;
    
    Connection conn;
    private Text lab;
    @FXML
    private Text namLab;
    @FXML
    private Text nationality;
    @FXML
    private Text age;
    @FXML Text team;
    @FXML
    private Text race;
    @FXML
    private Text pole;
    @FXML
    private Text win;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    String txt;
     public void getParam(String param){
        txt = param;
        System.out.println(param);
    }
    @FXML public void dipView() throws SQLException, IOException{
        
        String sql = "select * from driver where driverName like '"+txt+"%'";
        conn = sqlConnection.ConnectDb1();
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        System.out.println(rs);
        
        if(rs.next()){
            
            namLab.setText(rs.getString(2));
            nationality.setText(rs.getString(3));
            team.setText(rs.getString(4));
            age.setText(String.valueOf(rs.getInt(5)));
            race.setText(String.valueOf(rs.getInt(6)));
            pole.setText(String.valueOf(rs.getInt(7)));
            win.setText(String.valueOf(rs.getInt(8)));
            driverworldchamp.setText(String.valueOf(rs.getInt(9)));
             System.out.print(rs.getString(11));
            Blob imageBlob = rs.getBlob(11);
            byte[] blobimg = imageBlob.getBytes(1, (int) imageBlob.length());
            ByteArrayInputStream bis = new ByteArrayInputStream(blobimg);
            BufferedImage read = ImageIO.read(bis);
            Image image = SwingFXUtils.toFXImage(read, null);
            driverimage.setImage(image);
            
        }
        
       
        
        
        
        
    }
    
}