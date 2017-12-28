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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ADI
 */


public class DeployScreenController implements Initializable {

    @FXML private TextField driverName;
  @FXML  private TextField nationalityField;
   @FXML private TextField teamField;
   @FXML private TextField ageField;
   @FXML private TextField driverID;
   @FXML private TextField raceField;
   @FXML private TextField poleField;
   @FXML private TextField winField;
   
   @FXML private Button check;
  @FXML  private TextField teamID;
   @FXML private TextField wcField;
   @FXML private TextField carID;
    @FXML
    private Button backButton;
    @FXML
    private Pane deployPane;
    
    
   
    

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       check.setDisable(false);
    }   
    
    @FXML
    public void add() throws SQLException{
         try {
            sqlConnection.ConnectDb1();
           
        } catch (SQLException ex) {
            Logger.getLogger(DeployScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         check.setDisable(true);
         Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
        String insert = "INSERT INTO driver (driverId, driverName, Nationality, TeamName, Age, Races, Pole, Wins, worldChampionship, carID, teamID) VALUES(?,?,?,?,?,?,?,?,?,?,?);"; 
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setString(1, driverID.getText());
                ps.setString(2,driverName.getText());
                ps.setString(3, nationalityField.getText());
                ps.setString(4, teamField.getText());
                ps.setInt(5,Integer.parseInt(ageField.getText()));
                ps.setInt(6,Integer.parseInt(raceField.getText()));
                ps.setInt(7,Integer.parseInt(poleField.getText()));
                ps.setInt(8,Integer.parseInt(winField.getText()));
                ps.setInt(9,Integer.parseInt(wcField.getText()));
                ps.setString(10,carID.getText());
                ps.setString(11,teamID.getText());
                ps.execute();
                                             
    }
    @FXML
    public void update() throws SQLException{
       check.setDisable(false);
       try {
            sqlConnection.ConnectDb1();
           
        } catch (SQLException ex) {
            Logger.getLogger(DeployScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         check.setDisable(true);
         Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
       String update = "UPDATE driver SET driverName='"+driverName.getText()+"',Nationality='"+nationalityField.getText()+"' where driverId ='"+driverID.getText()+"';";
       Statement st = conn.createStatement();
        st.executeUpdate(update);
    }
        
    @FXML
    public void remove() throws SQLException{
         try {
            sqlConnection.ConnectDb1();
           
        } catch (SQLException ex) {
            Logger.getLogger(DeployScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
         check.setDisable(false);
         Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
         
         String remove = "DELETE FROM driver WHERE driverId="+"'"+driverID.getText()+"';";
        Statement st = conn.createStatement();
        st.executeUpdate(remove);
    }
    
    @FXML
    public void checkStatus() throws SQLException{
       check.setDisable(false);
        String x = driverID.getText();
        System.out.println(x);
        String sql = "select * from driver where driverId= '"+x+"';";
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/f1db","root","akshatrai");
        conn = sqlConnection.ConnectDb1();
        
        ResultSet rs = conn.createStatement().executeQuery(sql);
        System.out.println(rs);
        if(rs.next()){
               System.out.println("entering");
              driverName.setText(rs.getString(2));
              System.out.println(rs.getString(3));
              nationalityField.setText(rs.getString(3));
              teamField.setText(rs.getString(4));
              ageField.setText(String.valueOf(rs.getInt(5)));
              raceField.setText(String.valueOf(rs.getInt(6)));
              poleField.setText(String.valueOf(rs.getInt(7)));
              winField.setText(String.valueOf(rs.getInt(8)));
              wcField.setText(String.valueOf(rs.getInt(9)));
              carID.setText(rs.getString(10));
              teamID.setText(rs.getString(12));
              
        }
    }
    public void goBack(){
           Pane viewButtonPane = null;
        try {
            viewButtonPane = FXMLLoader.load(getClass().getResource("secondScreen.fxml"));
             
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       deployPane.getChildren().setAll(viewButtonPane);
    }
    
}
