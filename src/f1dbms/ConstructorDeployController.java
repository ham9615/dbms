/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1dbms;

import com.mysql.jdbc.Connection;
import f1dbms.SQLConnectionFile.sqlConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ADI
 */
public class ConstructorDeployController implements Initializable {

    @FXML
    private TextField teamName;
    @FXML
    private TextField win;
    @FXML
    private TextField teamId;
    @FXML
    private TextField carId;
    @FXML
    private Button check;
    @FXML
    private TextField teamBase;
    @FXML
    private Button add;
    @FXML
    private Button remove;
    @FXML
    private TextField champion;
    @FXML
    private TextField teamPrincipal;
    @FXML Pane constructorPane;

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
        String x = "insert into constructor (TeamId, teamBase, teamName, CarID, Championships, Wins,TeamPrincipal) values (?,?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(x);
        ps.setString(1, teamId.getText());
        ps.setString(2, teamBase.getText());
        ps.setString(3, teamName.getText());
        ps.setString(4, carId.getText());
        ps.setInt(5,Integer.parseInt(champion.getText()));
        ps.setInt(6,Integer.parseInt(win.getText()));
        ps.setString(7,teamPrincipal.getText());
        
        ps.execute();
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
         
         String remove = "delete from constructor where TeamId = ?";
         PreparedStatement ps = conn.prepareStatement(remove);
         ps.setString(1, teamId.getText());
         ps.execute();
    }
     public void goBack(){
           Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       constructorPane.getChildren().setAll(viewButtonPane);
    }
    
}
