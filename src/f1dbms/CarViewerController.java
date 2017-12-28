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
public class CarViewerController implements Initializable {

    @FXML
    private Text carid;
    @FXML
    private Text pu;
    @FXML
    private Text team;
    @FXML
    private Text win;
    @FXML
    private Text teamId;
    @FXML
    private ImageView carImg;
    @FXML
    private Button loadButton;
    Connection conn = null;

   String txt;
     public void getParam(String param){
        txt = param;
        System.out.println(param);}
    @FXML public void viewData() throws SQLException, IOException{
        String sql = "select * from cart where teamName like '"+txt+"%'";
        conn = sqlConnection.ConnectDb1();
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        System.out.println(rs);
        if(rs.next()){
            
            carid.setText(rs.getString(1));
            team.setText(rs.getString(2));
            pu.setText(rs.getString(3));
            win.setText(String.valueOf(rs.getInt(4)));
            teamId.setText(rs.getString(6));
            
            Blob imageBlob = rs.getBlob(5);
            byte[] blobimg = imageBlob.getBytes(1, (int) imageBlob.length());
            ByteArrayInputStream bis = new ByteArrayInputStream(blobimg);
            BufferedImage read = ImageIO.read(bis);
            Image image = SwingFXUtils.toFXImage(read, null);
            carImg.setImage(image);
            
        }
        
        
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
}
