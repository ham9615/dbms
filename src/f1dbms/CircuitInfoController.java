/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import com.mysql.jdbc.Connection;
import f1dbms.SQLConnectionFile.sqlConnection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class CircuitInfoController implements Initializable {

    @FXML
    private Text name;
    @FXML
    private Text laps;
    @FXML
    private Text laprec;
    @FXML
    private Text len;
    @FXML
    private ImageView cirimg;

    /**
     * Initializes the controller class.
     */
    
   Connection conn;
    String x;
    @FXML
    private Text len1;
    void getInfo(String lead) {
            x= lead;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOSystem.out.println(rs);
        
       
        
        
        
    }

    @FXML
    public void show() throws IOException{
    
     String sql = "select * from raceinfo where raceId = '" + x +"'";
        try {
            conn = sqlConnection.ConnectDb1();
        } catch (SQLException ex) {
            Logger.getLogger(CircuitInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            ResultSet rs;
            rs = conn.createStatement().executeQuery(sql);
            System.out.println(rs);
            if(rs.next()){
                laps.setText(String.valueOf(rs.getInt(5)));
                len.setText(rs.getString(4));
                Blob imageBlob = rs.getBlob(6);
                name.setText(rs.getString(1));
                laprec.setText(rs.getString(3));
            byte[] blobimg = imageBlob.getBytes(1, (int) imageBlob.length());
            ByteArrayInputStream bis = new ByteArrayInputStream(blobimg);
            BufferedImage read = ImageIO.read(bis);
            Image image = SwingFXUtils.toFXImage(read, null);
            cirimg.setImage(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CircuitInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}    

    
    
}
