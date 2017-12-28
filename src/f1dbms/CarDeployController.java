/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import com.mysql.jdbc.Connection;
import f1dbms.SQLConnectionFile.sqlConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class CarDeployController implements Initializable {

    @FXML
    private TextField teamName;
    @FXML
    private TextField win;
    @FXML
    private TextField carId;
    @FXML
    private TextField pu;
    @FXML
    private Button check;
    @FXML
    private TextField teamId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkStatus(MouseEvent event) {
    }

    @FXML
    private void add(MouseEvent event) throws SQLException {
         try {
            sqlConnection.ConnectDb1();
           
        } catch (SQLException ex) {
            Logger.getLogger(DeployScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         check.setDisable(true);
         Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
         
         String insert = "insert into car (CarId,TeamName,PowerUnit,Wins,TeamID) values (?,?,?,?,?)";
         PreparedStatement ps = conn.prepareStatement(insert);
         ps.setString(1,carId.getText());
         ps.setString(2, teamName.getText());
         ps.setString(3, pu.getText());
         ps.setInt(4, Integer.parseInt(win.getText()));
         ps.setString(5,teamId.getText());
         ps.execute();
         
                
         //Statement st = conn.createStatement();
       // s//t.executeUpdate(insert);
        
    }

    @FXML
    private void update(MouseEvent event) throws SQLException {
         try {
            sqlConnection.ConnectDb1();
           
        } catch (SQLException ex) {
            Logger.getLogger(DeployScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         check.setDisable(true);
         Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
    }

    @FXML
    private void remove(MouseEvent event) throws SQLException {
         try {
            sqlConnection.ConnectDb1();
           
        } catch (SQLException ex) {
            Logger.getLogger(DeployScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         check.setDisable(true);
         Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
         
         String remove = "delete from car where CarId =  ?";
         PreparedStatement ps = conn.prepareStatement(remove);
         ps.setString(1,carId.getText());
         ps.execute();
    
    
    }
    
}
