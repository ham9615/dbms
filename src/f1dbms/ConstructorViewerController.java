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
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class ConstructorViewerController implements Initializable {

    @FXML
    private Text teamName;
    @FXML
    private Text teamPrincipal;
    @FXML
    private Text championship;
    @FXML
    private Text teamBase;
    @FXML
    private Text win;
    @FXML
    private Button loadButton;
Connection conn = null;
    /**
     * Initializes the controller class.
     */
    String txt;
    @FXML
    private ImageView teamImg;
     public void getParam(String param){
        txt = param;
        System.out.println(param);
    }
    
    @FXML
    public void viewStatus() throws SQLException, IOException{
        
         String sql = "select * from constructor where teamName like '"+txt+"%'";
        conn = sqlConnection.ConnectDb1();
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        System.out.println(rs);
        
        if(rs.next()){
            teamBase.setText(rs.getString(3));
            teamName.setText(rs.getString(4));
            championship.setText(String.valueOf(rs.getInt(5)));
            win.setText(String.valueOf(rs.getInt(6)));
            teamPrincipal.setText(rs.getString(7));
            Blob imageBlob = rs.getBlob(8);
            byte[] blobimg = imageBlob.getBytes(1, (int) imageBlob.length());
            ByteArrayInputStream bis = new ByteArrayInputStream(blobimg);
            BufferedImage read = ImageIO.read(bis);
            Image image = SwingFXUtils.toFXImage(read, null);
            teamImg.setImage(image);
            
                    
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
